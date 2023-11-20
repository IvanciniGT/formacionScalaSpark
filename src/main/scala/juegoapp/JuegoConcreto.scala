package com.curso
package juegoapp

import juegoapp.entity.{Jugador, Partida}

trait JuegoConcreto{

  def nombre: String
  def jugarPartida(jugador: Jugador): Partida
}
