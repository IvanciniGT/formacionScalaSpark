package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.entity.ResultadosPartida
import juegoapp.juego.ahorcado.{AhorcadoInterfaz, AhorcadoPartida}

object AhorcadoInterfazConsola extends AhorcadoInterfaz{

  override def mostrarBienvenidaAlJuego(partida: AhorcadoPartida): Unit = {
    println("Bienvenido al juego: "+partida.nombreJuego)
  }

  override def solicitarLetra(partida: AhorcadoPartida): Char = {
    println("Tienes "+partida.vidasQueMeQuedan+" vidas")
    println("Letras usadas: "+partida.letrasUsadas.mkString(","))
    println("Palabra: "+partida.palabraEnmascarada)
    print("Dame una letra: ")
    scala.io.StdIn.readChar() // TODO validacion
  }

  override def solicitarTema(temas: Map[String, String]): String = {
    var temaLeido:String = null
    while(!temas.contains(temaLeido)) {
      println("Tenemos los temas:")
      temas.foreach(tema => println(s"[${tema._1}] - ${tema._2}"))
      print("Elije uno: ")
      temaLeido = scala.io.StdIn.readLine()
      if(!temas.contains(temaLeido))
        println("Tema no válido")
    }
    temaLeido
  }

  override def mostrarResultadoDeLaPartida(partida: AhorcadoPartida): Unit = {
    println("La partida ha terminado")
    println("La palabra era: " + partida.palabraAAdivinar)
    partida.resultado match {
      case ResultadosPartida.ComputadoraGana => println("Has perdido")
      case ResultadosPartida.JugadorGana => println("Has ganado")
    }
  }
}
