package com.curso
package juegoapp

trait JuegosRepositorio {
  def getJuegos: List[JuegoConcreto]
}
