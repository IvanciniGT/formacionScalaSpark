package com.curso
package juegoapp.juego.ahorcado

import com.curso.juegoapp.juego.Interfaz

trait AhorcadoInterfaz extends Interfaz[AhorcadoPartida] {
  def solicitarLetra(partida: AhorcadoPartida): Char

  def solicitarTema(temas:  Map[String, String]): String
}
