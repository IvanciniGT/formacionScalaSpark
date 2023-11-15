package com.curso
package conceptos

object EstimarPI {

  def main(args: Array[String]): Unit = {
    val numeroDePuntos = 2000000000
    var numeroDePuntosDentro = 0
    for (i <- 1 to numeroDePuntos) {
      val x = Math.random()
      val y = Math.random()
      val distancia = x * x + y * y
      if (distancia < 1) numeroDePuntosDentro += 1
    }
    val PI = 4.0 * numeroDePuntosDentro / numeroDePuntos
    println(s"PI es aproximadamente $PI")
  }
}
