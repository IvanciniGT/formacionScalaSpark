package com.curso
package juegoapp.juego

import com.curso.juegoapp.entity.ResultadosPartida.Resultado
import com.curso.juegoapp.entity.Partida

trait Reglas[P <: Partida] {
  def calculaResultado(partida: P): Resultado
}