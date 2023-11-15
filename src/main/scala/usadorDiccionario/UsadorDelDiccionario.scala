package com.curso
package usadorDiccionario

import diccionario.SuministradorDeDiccionarios

object UsadorDelDiccionario {
  def main(args: Array[String]): Unit = {
    val idioma = "español"
    val palabra = "manana"
    if (SuministradorDeDiccionarios.tienesDiccionariosDe(idioma)) {
      val miDiccionario = SuministradorDeDiccionarios.getDiccionario(idioma).get
      if (miDiccionario.existe(palabra)) {
        println(s"La palabra $palabra existe")
        println("Sus significados son:")
        miDiccionario.getSignificados(palabra).get.foreach(println)
      }else{
        println(s"La palabra $palabra no existe")
        println("Quizás quisiste decir:")
        miDiccionario.getSugerencias(palabra).foreach(println)
      }
    }else{
      println(s"No hay diccionarios de $idioma")
    }
  }
}
