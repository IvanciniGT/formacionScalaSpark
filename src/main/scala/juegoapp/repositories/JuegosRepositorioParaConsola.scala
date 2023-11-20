package com.curso
package juegoapp.repositories

import juegoapp.{JuegoConcreto, JuegosRepositorio}

import com.curso.juegoapp.juego.ppt.variantes.JuegoPPTBasicoConsola

object JuegosRepositorioParaConsola extends JuegosRepositorio {
  def getJuegos: List[JuegoConcreto] = {
    List.newBuilder(
      JuegoPPTBasicoConsola
    ).result()
  }
}
