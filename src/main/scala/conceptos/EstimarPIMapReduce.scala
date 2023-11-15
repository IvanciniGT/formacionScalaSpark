package com.curso
package conceptos

object EstimarPIMapReduce {

  def main(args: Array[String]): Unit = {
    val numeroDePuntos = 200000000
    val numeroPuntosDentro = (1 to numeroDePuntos).toList                    // Colección de puntos
      .map( tirada => (Math.random(), Math.random()) )                           // Colección de coordenadas
      .map( coordenadas => coordenadas._1 * coordenadas._1 + coordenadas._2 * coordenadas._2 )
      .count( distancia => distancia <= 1)
    val PI = 4.0 * numeroPuntosDentro / numeroDePuntos
    println(s"PI es aproximadamente $PI")
  }
}
