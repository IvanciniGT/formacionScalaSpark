package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.entity.ResultadosPartida.Resultado
import juegoapp.entity.{Jugador, ResultadosPartida}
import juegoapp.juego.ahorcado.{AhorcadoPartida, AhorcadoReglas}

object AhorcadoReglasBasicas extends AhorcadoReglas{

  private val vidasIniciales = 6;

  override def iniciarPartida(jugador: Jugador, nombreJuego: String, palabra: String): AhorcadoPartida = {
    return null
  }


  override def calculaResultado(partida: AhorcadoPartida, letra: Object*): Resultado = {
    // Se supone que la nueva letra añadida por el jugador llega en AhorcadoPArtida, dentro de letrasUsadas.
    // PREGUNTA MIA: Puedo garantizar esto?
    return null
  }
}

private class AhorcadoPatidaImpl (
  val palabraAAdivinar: String,
  val vidasQueMeQuedan: Int,
  val palabraEnmascarada: String,
  val resultado: ResultadosPartida.Resultado,
  val jugador: Jugador,
  val nombreJuego: String,
  val letrasUsadas: List[Char]
)extends AhorcadoPartida {
}