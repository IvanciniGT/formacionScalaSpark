package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.JuegoConcreto
import juegoapp.entity.{Jugador, Partida}
import juegoapp.juego.ahorcado.Ahorcado

import com.curso.juegoapp.juego.ahorcado.repositories.AhorcadoTemasRepositorioDeFicheros
object JuegoAhorcadoBasicoConsola extends JuegoConcreto{
  val nombre = "Ahorcado clásico"
  override def jugarPartida(jugador: Jugador): Partida = {
    Ahorcado.repoPalabras = AhorcadoTemasRepositorioDeFicheros
    Ahorcado.jugarPartida(jugador, AhorcadoReglasBasicas, AhorcadoInterfazConsola, nombre)
  }
}
