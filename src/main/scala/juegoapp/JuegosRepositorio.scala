package com.curso
package juegoapp

trait JuegosRepositorio {
  def getJuegos: List[Juego[_,_,_]]
}
