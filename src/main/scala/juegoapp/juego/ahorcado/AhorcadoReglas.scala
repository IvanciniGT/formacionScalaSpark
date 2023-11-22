package com.curso
package juegoapp.juego.ahorcado

import juegoapp.juego.Reglas

import com.curso.juegoapp.entity.Jugador

trait AhorcadoReglas extends Reglas[AhorcadoPartida] {

  def iniciarPartida(jugador: Jugador, nombreJuego: String): AhorcadoPartida

  def asignarPalabra(partida:AhorcadoPartida, palabra: String): AhorcadoPartida

}
