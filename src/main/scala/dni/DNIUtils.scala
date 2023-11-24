package com.curso
package dni

import org.apache.spark.{SparkConf, SparkContext}

object DNIUtils {

  val regex = "(?i)^((\\d{1,8})|(\\d{1,3}\\.\\d{3})|(\\d{1,2}(\\.\\d{3}){2}))[- ]?[TRWAGMYFPDXBNJZSQVHLCKE]$"

  def validarDNI(dni:String): Boolean = {
    if(dni == null) return false
    if(dni.length > 12) return false
    if(dni.isEmpty) return false

    if(!dni.matches(regex)) return false

    val dniSinLetra = dni.substring(0, dni.length - 1).replaceAll("[ .-]","")
    val letra = dni.charAt(dni.length - 1).toUpper
    val numero = dniSinLetra.toInt

    val resto = numero % 23
    val letraCalculada = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(resto)

    letra == letraCalculada
  }
  def main(args:Array[String]):Unit ={
    val configuracion = new SparkConf()
                            .setAppName("DNIUtils") // Nombre a mi app en el cluster
                            //.setMaster("spark://IP_DEL_CLUSTER:7077")
                            .setMaster("local[2]")
    // TRUCO. Si apunto al un cluster con la palabra local, en automático Spark
    // levanta un cluster de pruebas en mi maquina, para ejecutar el código
    // Entre corchetes se indica el número de cores que permite usar al cluster

    val conexion = new SparkContext(configuracion)
    // Ahora tengo una conexión con un cluster de spark

    val listaDeDNIs = List("12345678Z",
      "53024501w",
      "53024501W",
      "53024501w",
      "53024501-W",
      "53024501 W",
      "53024.501 W",
      "53.024501W",
      "53.024.501a",
      )

    val contadorDeDNISInvalidos = conexion.longAccumulator("DNIS invalidos")
    // Ir contando los DNIS que no validan, a la que los valido
    val dnis_validos = conexion.parallelize(listaDeDNIs)
          .map(dni => {
            val valido = validarDNI(dni)
            println(dni + " " + valido)
            if(!valido){
              //contadorDeDNISInvalidos+=1
              contadorDeDNISInvalidos.add(1)
              println("El DNI " + dni + " no es valido. Llevo " + contadorDeDNISInvalidos + " DNIS invalidos ")
            }
            (dni, valido)
          })
          //.filter( tupla => tupla._2 == true)
          .filter( _._2)
          .collect()

    println("DNIS invalidos: " + contadorDeDNISInvalidos.value)

    dnis_validos
      .foreach( dniValidado => println(dniValidado._1 + " " + dniValidado._2))

    conexion.stop()
  }
}





















