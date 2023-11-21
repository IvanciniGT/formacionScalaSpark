package com.curso
package juegoapp.juego.ppt.variantes

import com.curso.juegoapp.entity.ResultadosPartida.{ComputadoraGana, Empate, JugadorGana, Resultado}

import com.curso.juegoapp.juego.ppt.{PPTEleccion, PPTPartida, PPTReglas}

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

  override def calculaResultado(partida: PPTPartida, otros:Object*): Resultado = {
    if(partida.eleccionDelJugador == null)
      throw new Exception("Me faltan datos")
    if(partida.eleccionDeLaComputadora == null)
      throw new Exception("Me faltan datos")
    reglas(partida.eleccionDelJugador)(partida.eleccionDeLaComputadora)
  }

  override def getEleccionesPermitidas: List[PPTEleccion] = elecciones
}
