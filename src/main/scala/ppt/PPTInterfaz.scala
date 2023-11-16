package com.curso
package ppt

trait PPTInterfaz {
  def pedirEleccionJugador(jugador: Jugador, getEleccionesPermitidas: List[PPTEleccion]): PPTEleccion
  def mostrarResultadoDeLaPartida(jugador: Jugador, partida: Any): Unit
  def mostrarBienvenidaAlJuego(jugador: Jugador): Unit

}
