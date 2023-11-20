package com.curso
package juegoapp.repositories

import juegoapp.JugadoresRepositorio

import com.curso.juegoapp.entity.Jugador

import scala.collection.mutable.ListBuffer

object JugadoresRepositorioEnRAM extends JugadoresRepositorio{

  private val listadoUsuariosRegistrados = new ListBuffer[Jugador]();

  override def existe(nombre: String): Boolean =
    listadoUsuariosRegistrados.exists(jugador => jugador.nombre == nombre)

  override def getJugador(nombre: String): Option[Jugador] =
    listadoUsuariosRegistrados.find(jugador => jugador.nombre == nombre)

  override def altaJugador(nombre: String): Jugador = {
    val jugador = new Jugador(nombre)
    listadoUsuariosRegistrados += jugador
    jugador
  }

}
