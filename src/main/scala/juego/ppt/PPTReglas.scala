package com.curso
package juego.ppt

import juego.Reglas

trait PPTReglas extends Reglas[PPTPartida]{

  def getEleccionesPermitidas: List[PPTEleccion]

}
