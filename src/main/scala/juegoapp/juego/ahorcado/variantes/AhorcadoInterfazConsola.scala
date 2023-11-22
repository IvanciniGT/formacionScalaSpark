package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.juego.ahorcado.{AhorcadoInterfaz, AhorcadoPartida, AhorcadoTemasRepositorio}

object AhorcadoInterfazConsola extends AhorcadoInterfaz{

  override def mostrarBienvenidaAlJuego(partida: AhorcadoPartida): Unit = {
    println("Bienvenido al juego: "+partida.nombreJuego)
  }

  override def solicitarLetra(partida: AhorcadoPartida): Char = {

  }

  override def solicitarTema(temas: AhorcadoTemasRepositorio): String = {

  }

  override def mostrarResultadoDeLaPartida(partida: AhorcadoPartida): Unit = {

  }
}
