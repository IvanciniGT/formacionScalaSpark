package com.curso
package juegoapp.juego.ahorcado

trait AhorcadoTemasRepositorio {

  def temas:Map[String, String]
  def getPalabraAlAzar(tema:String):String

}
