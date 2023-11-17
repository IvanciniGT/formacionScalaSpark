package com.curso
package juego

import juego.ResultadosPartida.Resultado

trait Reglas[P <: Partida] {
  def calculaResultado(partida: P): Resultado
}