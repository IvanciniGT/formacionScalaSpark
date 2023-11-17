package com.curso
package juego

import juego.ResultadosPartida.Resultado

trait Reglas {
  def calculaResultado(partida: Partida): Resultado

}