package com.curso
package juegoapp.juego

import com.curso.juegoapp.entity.Partida

trait Interfaz [P <: Partida]{
  def mostrarResultadoDeLaPartida(partida: P): Unit
  def mostrarBienvenidaAlJuego(partida: P): Unit
}
