package com.curso
package juegoapp.juego

import juegoapp.entity.{Jugador, Partida}

trait Juego[P <: Partida, R <: Reglas[P], I <: Interfaz[P]] {
  def jugarPartida
  (jugador: Jugador, reglas: R, interfaz: I, nombreJuego: String): Partida
}
