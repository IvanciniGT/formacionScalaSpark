package com.curso
package juegoapp

import juegoapp.entity.{Jugador, Partida}

trait PartidasRepositorio {
  def getPartidas(jugador: Jugador): List[Partida]

  def altaPartida(partida:Partida): Unit
}
