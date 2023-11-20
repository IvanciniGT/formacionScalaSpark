package com.curso
package juegoapp

import juegoapp.entity.{EstadoAppJuegos, Jugador, Partida}

trait InterfazAppJuegos {
  def confirmarSalida(): Boolean = ???

  def mostrarEstadisticas(jugador: Jugador, partidas: List[Partida]): Unit = ???

  def solicitarJuego(getJuegos: List[JuegoConcreto]): JuegoConcreto = ???

  def solicitarOpcion(LISTADO_OPCIONES: List[String], estadoDeLaAplicacion: EstadoAppJuegos): String = ???

  def confirmaCreacionJugador(nombreJugador: String): Boolean = ???

  def mostrarBienvenidaAlJugador(estadoDeLaAplicacion: EstadoAppJuegos): Unit = ???

  def pedirJugador(): String = ???

  def mostrarBienvenida():Unit = ???

}
