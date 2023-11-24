package com.curso
package sparksql

import dni.DNIUtils

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object Ejemplo {

  def main(args:Array[String]):Unit= {

    val conexion = SparkSession
      .builder()
      .appName("Ejemplo")
      .master("local[*]")
      .getOrCreate()

    val datos = conexion.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("src/main/resources/ficheros/personas.csv")

    datos.show()

    // Mayores de edad
    datos.filter("edad >= 18").show()
    // Solo quiero nombre y apellidos
    datos.select("nombre", "apellidos").show()
    // Agrupar por apellido y contar
    datos.groupBy("apellidos").count().show()

    datos.createOrReplaceTempView("personas")
    val datos2 = conexion.sql("select * from personas where edad >= 18")

    datos2.show()
    // Eliminar los menores de edad
    val mayoresDeEdad = datos.filter("edad >= 18")

    // Validar el DNI. Opcion 1
    mayoresDeEdad.filter(fila => {
      val dni = fila.getAs[String]("dni")
      DNIUtils.validarDNI(dni)
    })/*.write
      .option("header", "true")
      .csv("src/main/resources/ficheros/mayoresDeEdad.csv")
      */
    // Validar el DNI. Opcion 2
    // Defino una User Defined Funcion
    //val miFuncionDeValidacion = udf((dni:String) => DNIUtils.validarDNI(dni))
    // Registro en spark esa función
    //conexion.udf.register("validarDNI", miFuncionDeValidacion)
    conexion.udf.register("validarDNI", udf(DNIUtils.validarDNI _))
    // Ya puedo usarla en mis queries
    mayoresDeEdad.filter("validarDNI(dni)").show()

    conexion.sql("select * from personas where validarDNI(dni)").show()
  }
}
