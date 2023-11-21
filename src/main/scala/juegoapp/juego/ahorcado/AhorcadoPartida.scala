package com.curso
package juegoapp.juego.ahorcado

import juegoapp.entity.{Partida, ResultadosPartida}

trait AhorcadoPartida extends Partida {
  val palabraAAdivinar: String
  val letrasUsadas: List[Char]
  val vidasQueMeQuedan: Int
  val palabraEnmascarada: String
  val resultado: ResultadosPartida.Resultado
}