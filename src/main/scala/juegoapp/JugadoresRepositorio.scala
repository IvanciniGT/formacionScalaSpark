package com.curso
package juegoapp

import juegoapp.entity.Jugador

trait JugadoresRepositorio {
  def existe(nombre:String): Boolean
  def getJugador(nombre:String): Option[Jugador]

  def altaJugador(nombre: String): Jugador
}
