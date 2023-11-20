package com.curso
package juegoapp.juego

import juegoapp.entity.{Jugador, Partida}

import com.curso.juegoapp.juego.ppt.{PPTInterfaz, PPTReglas}

trait Juego[P <: Partida, R <: Reglas[P], I <: Interfaz[P]] {
  def jugarPartida
  (jugador: Jugador, reglas: PPTReglas, interfaz: PPTInterfaz, nombreJuego: String): Partida
}
