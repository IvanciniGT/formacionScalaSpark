package com.curso
package juegoapp.juego

import juegoapp.entity.Partida
import juegoapp.entity.ResultadosPartida.Resultado

trait Reglas[P <: Partida] {

  def calculaResultado(partida: P, otrasCosas:Object*): Resultado
}