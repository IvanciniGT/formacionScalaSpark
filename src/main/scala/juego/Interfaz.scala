package com.curso
package juego

trait Interfaz [P <: Partida]{
  def mostrarResultadoDeLaPartida(partida: P): Unit
  def mostrarBienvenidaAlJuego(partida: P): Unit
}
