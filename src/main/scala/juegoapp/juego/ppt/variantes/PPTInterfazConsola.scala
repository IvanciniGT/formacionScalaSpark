package com.curso
package juegoapp.juego.ppt.variantes

import juegoapp.juego.ppt.{PPTEleccion, PPTInterfaz, PPTPartida, PPTReglas}

object PPTInterfazConsola extends PPTInterfaz{

  override def pedirEleccionJugador(partida: PPTPartida, reglas: PPTReglas): PPTEleccion = {
    println("Elija una de las siguientes opciones:")
    reglas.getEleccionesPermitidas.foreach( eleccion => println("- "+eleccion))
    val eleccion = scala.io.StdIn.readLine()
    reglas.getEleccionesPermitidas.find(_.nombre.equalsIgnoreCase(eleccion)).getOrElse({
      println("Eleccion no valida, intente de nuevo")
      pedirEleccionJugador(partida, reglas)
    })
  }

  override def mostrarResultadoDeLaPartida(partida: PPTPartida): Unit = {
    println(s"La computadora eligió ${partida.eleccionDeLaComputadora}")
    println(s"El jugador eligió ${partida.eleccionDelJugador}")
    println(s"El ganador es ${partida.resultado}")
  }

  override def mostrarBienvenidaAlJuego(partida: _root_.com.curso.juegoapp.juego.ppt.PPTPartida): Unit = {
    println("Bienvenido al juego de Piedra, Papel o Tijera")
  }

}
