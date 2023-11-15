package com.curso
package conceptos

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    var numero = 45
    numero = 33

    val numero2: Int = 17
    // numero2 =44 Esto da error

    // Operadores
    // + - * / % & && | ||
    if (numero > 18) {
      println("Eres mayor de edad")
    } else {
      println("Eres menos de edad")
    }

    println( if(numero > 18) "Eres mayor de edad" else "Eres menos de edad")

    var c1= new Cuadrado(10);
    println(c1.lado);
    println(c1.area);
    //c1.lado=20;
    println(c1.area);

    val tupla1 = ("elemento1", "elemento2")
    println(tupla1._1)
    println(tupla1._2)
    val tupla2 = new Tuple2[String, String]("elemento1", "elemento2")

  }
}














