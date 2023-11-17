package com.curso
package juego.ppt

import juego.{Interfaz, Partida}

trait PPTInterfaz extends Interfaz {
  def pedirEleccionJugador(partida: Partida, getEleccionesPermitidas: List[PPTEleccion]): PPTEleccion
}
