package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.juego.Interfaz

trait PPTInterfaz extends Interfaz[PPTPartida] {
  def pedirEleccionJugador(partida: PPTPartida, reglas: PPTReglas): PPTEleccion
}
