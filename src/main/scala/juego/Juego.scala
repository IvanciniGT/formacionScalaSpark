package com.curso
package juego

trait Juego {
  def jugarPartida(jugador: Jugador, reglas: Reglas, interfaz: Interfaz): Partida
}
