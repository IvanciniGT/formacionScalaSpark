package com.curso
package juegoapp.juego.ahorcado

import com.curso.juegoapp.juego.Interfaz

trait AhorcadoInterfaz extends Interfaz[AhorcadoPartida] {
  def pedirEleccionJugador(partida: AhorcadoPartida, reglas: AhorcadoReglas): PPTEleccion
}
