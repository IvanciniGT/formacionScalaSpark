package com.curso
package juegoapp.juego.ahorcado

import com.curso.juegoapp.juego.Reglas

trait AhorcadoReglas extends Reglas[AhorcadoPartida]{

  def getEleccionesPermitidas: List[PPTEleccion]

}
