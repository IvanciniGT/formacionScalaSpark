package com.curso
package juegoapp.entity

trait Partida {
  val jugador: Jugador
  val nombreJuego: String
  def resultado: ResultadosPartida.Resultado
}
