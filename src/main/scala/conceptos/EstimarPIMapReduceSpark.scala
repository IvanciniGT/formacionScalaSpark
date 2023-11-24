package com.curso
package conceptos

import org.apache.spark.{SparkConf, SparkContext}

object EstimarPIMapReduceSpark {

  def main(args: Array[String]): Unit = {

    val configuracion = new SparkConf()
      .setAppName("DNIUtils") // Nombre a mi app en el cluster
//      .setMaster("local[2]")
    val conexion = new SparkContext(configuracion)


    val numeroDePuntos = 200000
    val numeroPuntosDentro = conexion.parallelize((1 to numeroDePuntos).toList )                   // Colección de puntos
      .map( tirada => (Math.random(), Math.random()) )                           // Colección de coordenadas
      .map( coordenadas => coordenadas._1 * coordenadas._1 + coordenadas._2 * coordenadas._2 )
      .filter( distancia => distancia <= 1)
      .count()
    val PI = 4.0 * numeroPuntosDentro / numeroDePuntos
    println(s"PI es aproximadamente $PI")

    conexion.stop()
  }
}
