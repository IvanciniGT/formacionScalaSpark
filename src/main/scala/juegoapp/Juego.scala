package com.curso
package juegoapp

import com.curso.juegoapp.entity.{Jugador, Partida}
import com.curso.juegoapp.juego.{Interfaz, Reglas}

trait Juego [P<: Partida, R  <: Reglas[P], I  <: Interfaz[P]]{
  def jugarPartida(jugador: Jugador, reglas: R , interfaz: I): Partida
}
