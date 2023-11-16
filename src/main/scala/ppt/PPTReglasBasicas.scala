package com.curso
package ppt
import ppt.ResultadosPartida.Resultado

object PPTReglasBasicas extends PPTReglas{
  object Piedra extends PPTEleccion("PIEDRA")
  // val Piedra = new PPTEleccion("PIEDRA")
  object Papel extends PPTEleccion("PAPEL")
  object Tijera extends PPTEleccion("TIJERA")
  val elecciones = new List[PPTEleccion](Piedra, Papel, Tijera)

  override def calculaResultado(eleccionDeLaComputadora: PPTEleccion, eleccionDelJugador: PPTEleccion): Resultado = {

  }

  override def getEleccionesPermitidas: List[PPTEleccion] = elecciones
}
