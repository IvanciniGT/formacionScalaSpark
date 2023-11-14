package com.curso
package conceptos

import diccionario.DiccionarioUtils

object MapReduce {

  def triplar(numero: Int): Int = numero * 3
  def esImpar(numero: Int): Boolean = numero % 2 != 0

  val listadoDeNumeros = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  listadoDeNumeros.map(triplar)     // Calculo el triple
                  .map( numero => numero - 5 ) // Resto 5 a cada número
                  .filter(esImpar)  // Me quedo con las impares
                  .foreach(println) // Imprimo

  val listadoPalabrasExistentes = List("manzana", "manzano", "melón")
  val palabraObjetivo = "manana"
  val DISTANCIA_MAXIMA = 2

  listadoPalabrasExistentes
    .filter(palabra => Math.abs(palabra.length - palabraObjetivo.length)<= DISTANCIA_MAXIMA)
    .map(palabra => (palabra, DiccionarioUtils.distance(palabra, palabraObjetivo)))
    .filter(tupla => tupla._2 <= DISTANCIA_MAXIMA)
    .sortBy(tupla => tupla._2)
    .take(8)
    .foreach(tupla => println(tupla._1))

  // TUPLE2
  def main(args: Array[String]): Unit = {}

  }
