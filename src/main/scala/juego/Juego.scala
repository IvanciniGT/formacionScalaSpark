package com.curso
package juego

trait Juego [P<: Partida, R  <: Reglas[P], I  <: Interfaz[P]]{
  def jugarPartida(jugador: Jugador, reglas: R , interfaz: I): Partida
}
