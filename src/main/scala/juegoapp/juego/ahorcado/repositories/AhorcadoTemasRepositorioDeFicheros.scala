package com.curso
package juegoapp.juego.ahorcado.repositories

import juegoapp.juego.ahorcado.AhorcadoTemasRepositorio

import scala.collection.mutable
import scala.io.Source
import scala.util.Random

object AhorcadoTemasRepositorioDeFicheros extends AhorcadoTemasRepositorio {
  val temas:Map[String, String] = leerFicheroDeTemas
  private val palabrasDeCadaTema =new mutable.HashMap [String, List[String]]()
  temas.keys.foreach(this.cargarPalabrasDelTema)
  def getPalabraAlAzar(tema:String):String = {
    val palabras = palabrasDeCadaTema(tema)
    palabras(Random.nextInt(palabras.length))
  }
  private def leerFicheroDeTemas:Map[String, String] = {
    val canal = Source.fromFile("src/main/resources/temas.txt")
      val temas = canal.getLines.map{linea =>
                                        val partes = linea.split("=")
                                        (partes(0), partes(1))
                                    }.toMap
    canal.close()
    temas
  }
  private def cargarPalabrasDelTema(tema:String):Unit = {
    val canal = Source.fromFile("src/main/resources/" + tema+".txt")
    val palabras = canal.getLines.toList
    canal.close()
    palabrasDeCadaTema(tema) = palabras
  }
}
