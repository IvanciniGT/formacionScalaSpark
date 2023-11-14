package com.curso
package conceptos

import scala.io.Source

object LeerFichero {
  def main(args: Array[String]): Unit = {
    val nombreFichero = "src/main/resources/ficheros/fichero.txt"
    val canalLectura = Source.fromFile(nombreFichero)
    val lineas = canalLectura.getLines()
    for (linea <- lineas) {
      println(linea)
    }
    canalLectura.close()
  }
}