package com.curso
package dni

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
    listaDeDNIs.map(dni => (dni, validarDNI(dni)))
               .foreach( dniValidado => println(dniValidado._1 + " " + dniValidado._2))
  }
}
