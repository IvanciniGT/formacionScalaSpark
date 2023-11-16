package com.curso
package ppt
import ppt.ResultadosPartida.{ComputadoraGana, Empate, JugadorGana, Resultado}

object PPTReglasBasicas extends PPTReglas{
  object Piedra extends PPTEleccion("PIEDRA")
  // val Piedra = new PPTEleccion("PIEDRA")
  object Papel extends PPTEleccion("PAPEL")
  object Tijera extends PPTEleccion("TIJERA")
  private val elecciones = List[PPTEleccion](Piedra, Papel, Tijera)
  private val reglas = Map(
         // JUGADOR v           <----------------------------- COMPUTADORA ------------------>
                (Piedra , Map( (Piedra, Empate),(Papel, ComputadoraGana), (Tijera,JugadorGana) ) ),
                (Papel  , Map( (Piedra, JugadorGana),(Papel, Empate), (Tijera,ComputadoraGana) ) ),
                (Tijera , Map( (Piedra, ComputadoraGana),(Papel, JugadorGana), (Tijera,Empate) ) )
  )

  override def calculaResultado(eleccionDeLaComputadora: PPTEleccion,
                                eleccionDelJugador: PPTEleccion): Resultado = {
    reglas(eleccionDelJugador)(eleccionDeLaComputadora)
  }

  override def getEleccionesPermitidas: List[PPTEleccion] = elecciones
}
