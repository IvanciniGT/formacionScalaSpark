package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.juego.ppt.{PPTEleccion, PPTInterfaz, PPTPartida, PPTReglas}

import com.curso.juegoapp.entity.ResultadosPartida._

object AhorcadoInterfazConsola extends PPTInterfaz{

  override def pedirEleccionJugador(partida: PPTPartida, reglas: PPTReglas): PPTEleccion = {
    println("Opciones disponibles: ")
    reglas.getEleccionesPermitidas.foreach( eleccion => println("- "+eleccion))
    print("Elija una: ")
    val eleccion = scala.io.StdIn.readLine()
    reglas.getEleccionesPermitidas.find(_.nombre.equalsIgnoreCase(eleccion)).getOrElse({
      println("Eleccion no valida, intente de nuevo")
      pedirEleccionJugador(partida, reglas)
    })
  }

  override def mostrarResultadoDeLaPartida(partida: PPTPartida): Unit = {
    println(s"La computadora eligió: ${partida.eleccionDeLaComputadora}")
    println(s"El jugador eligió: ${partida.eleccionDelJugador}")
    println(s"El ganador es: ${
      partida.resultado match {
        case Empate => "Nadie!!! Habeis empatado"
        case JugadorGana => partida.jugador.nombre
        case ComputadoraGana => "La computadora"
      }
    }")
  }

  override def mostrarBienvenidaAlJuego(partida: _root_.com.curso.juegoapp.juego.ppt.PPTPartida): Unit = {
    println("Bienvenido al juego de Piedra, Papel o Tijera")
  }

}
