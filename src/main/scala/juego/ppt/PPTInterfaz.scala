package com.curso
package juego.ppt

import juego.Interfaz

trait PPTInterfaz extends Interfaz[PPTPartida] {
  def pedirEleccionJugador(partida: PPTPartida, reglas: PPTReglas): PPTEleccion
}
