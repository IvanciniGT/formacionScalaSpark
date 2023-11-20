package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.juego.Reglas

trait PPTReglas extends Reglas[PPTPartida]{

  def getEleccionesPermitidas: List[PPTEleccion]

}
