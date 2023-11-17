package com.curso
package juego.ppt

import juego.Reglas

trait PPTReglas extends Reglas{

  def getEleccionesPermitidas: List[PPTEleccion]

}
