package com.curso
package conceptos

import scala.io.StdIn

object StandardIO {

  def main(args:Array[String]): Unit = {

    println("Escribe algo: ")
    val loEscrito = StdIn.readLine()
    println(s"Has escrito $loEscrito")

  }

}
