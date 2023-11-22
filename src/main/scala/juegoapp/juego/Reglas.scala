package com.curso
package juegoapp.juego

import juegoapp.entity.Partida

trait Reglas[P <: Partida] {

  def calculaResultado(partida: P, otrasCosas:Any*): P
}