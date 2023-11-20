package com.curso
package juegoapp.juego.ppt.variantes

import juegoapp.JuegoConcreto

import com.curso.juegoapp.entity.{Jugador, Partida}
import com.curso.juegoapp.juego.ppt.PiedraPapelTijera

object JuegoPPTBasicoConsola extends JuegoConcreto{
  val nombre = "Piedra Papel Tijera (Reglas básicas)"
  override def jugarPartida(jugador: Jugador): Partida =
    PiedraPapelTijera.jugarPartida(jugador, PPTReglasBasicas, PPTInterfazConsola, nombre)
}
