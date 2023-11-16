package com.curso
package conceptos

object ListasArgumentos {

  def main(args:Array[String]): Unit = {
    println(funcion(1,2))
    println(funcion2(1)(2))
  }

  def funcion(argumento1: Int, argumento2:Int):Int = argumento1 + argumento2
  def funcion2(argumento1: Int)(argumento2:Int):Int = argumento1 + argumento2

}
