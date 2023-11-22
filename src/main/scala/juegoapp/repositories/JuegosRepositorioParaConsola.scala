package com.curso
package juegoapp.repositories

import juegoapp.{JuegoConcreto, JuegosRepositorio}

import com.curso.juegoapp.juego.ahorcado.variantes.JuegoAhorcadoBasicoConsola
import com.curso.juegoapp.juego.ppt.variantes.JuegoPPTBasicoConsola

object JuegosRepositorioParaConsola extends JuegosRepositorio {
  def getJuegos: List[JuegoConcreto] = {
    List(JuegoPPTBasicoConsola,JuegoAhorcadoBasicoConsola)
  }
}
