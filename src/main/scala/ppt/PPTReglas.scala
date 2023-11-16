package com.curso
package ppt

import ppt.ResultadosPartida.Resultado

trait PPTReglas {
  def calculaResultado(eleccionDeLaComputadora: PPTEleccion, eleccionDelJugador: PPTEleccion): Resultado

  def getEleccionesPermitidas: List[PPTEleccion]

}
