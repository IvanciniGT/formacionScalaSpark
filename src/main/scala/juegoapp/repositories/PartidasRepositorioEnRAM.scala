package com.curso
package juegoapp.repositories

import juegoapp.entity.{Jugador, Partida}

import com.curso.juegoapp.PartidasRepositorio

import scala.collection.mutable.ListBuffer

object PartidasRepositorioEnRAM extends PartidasRepositorio {

  private val listadoPartidas = new ListBuffer[Partida]();
  def getPartidas(jugador: Jugador): List[Partida] =
    listadoPartidas.filter(partida => partida.jugador == jugador).toList
  def altaPartida(partida:Partida): Unit =
    listadoPartidas += partida
}
