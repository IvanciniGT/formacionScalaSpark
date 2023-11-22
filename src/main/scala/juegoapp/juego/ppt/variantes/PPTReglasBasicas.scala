package com.curso
package juegoapp.juego.ppt.variantes

import juegoapp.entity.ResultadosPartida.{ComputadoraGana, Empate, JugadorGana}
import juegoapp.juego.ppt.{PPTEleccion, PPTPartida, PPTReglas}

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

  override def calculaResultado(partida: PPTPartida, otros:Any*): PPTPartida = {
    if(partida.eleccionDelJugador == null)
      throw new Exception("Me faltan datos")
    if(partida.eleccionDeLaComputadora == null)
      throw new Exception("Me faltan datos")
    partida.resultado = reglas(partida.eleccionDelJugador)(partida.eleccionDeLaComputadora)
    partida
  }

  override def getEleccionesPermitidas: List[PPTEleccion] = elecciones
}
