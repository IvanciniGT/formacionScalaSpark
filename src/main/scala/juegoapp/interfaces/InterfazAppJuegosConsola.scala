package com.curso
package juegoapp.interfaces

import juegoapp.entity.{EstadoAppJuegos, Jugador, Partida, ResultadosPartida}

import com.curso.juegoapp.{InterfazAppJuegos, JuegoConcreto}

object InterfazAppJuegosConsola extends InterfazAppJuegos {
  override def confirmarSalida(): Boolean = {
    print("¿Está seguro que desea salir? (S/N) ")
    val respuesta = scala.io.StdIn.readLine()
    respuesta.equalsIgnoreCase("S")
  }

  override def mostrarEstadisticas(jugador: Jugador, partidas: List[Partida]): Unit = {
    println("Estadísticas del jugador " + jugador.nombre)
    println(" Partidas ganadas: " + partidas.count(partida => partida.resultado == ResultadosPartida.JugadorGana))
    println(" Partidas perdidas: " + partidas.count(partida => partida.resultado == ResultadosPartida.ComputadoraGana))
    println(" Partidas empatadas: " + partidas.count(partida => partida.resultado == ResultadosPartida.Empate))
  }

  override def solicitarJuego(getJuegos: List[JuegoConcreto]): JuegoConcreto = {
    println("Seleccione el juego que desea jugar: ")
    getJuegos.zipWithIndex.foreach(juego => println((juego._2 + 1) + ". " + juego._1.nombre))
    print("Seleccione un juego: ")
    val opcion = scala.io.StdIn.readInt()
    if(opcion > getJuegos.size || opcion < 1) {
      println("Opción inválida.")
      solicitarJuego(getJuegos)
    }else
      getJuegos(opcion - 1)
  }

  override def solicitarOpcion(LISTADO_OPCIONES: List[String], estadoDeLaAplicacion: EstadoAppJuegos): String = {
    println("Menú principal: ")
    LISTADO_OPCIONES.zipWithIndex.foreach(opcion => println((opcion._2 + 1) + ". " + opcion._1))
    print("Seleccione una opción: ")
    val opcion = scala.io.StdIn.readInt()
    // TODO Asegurar datos correctos
    LISTADO_OPCIONES(opcion - 1)
  }

  override def confirmaCreacionJugador(nombreJugador: String): Boolean = {
    print("El jugador " + nombreJugador + " no existe. ¿Desea crearlo? (S/N) ")
    val respuesta = scala.io.StdIn.readLine()
    respuesta.equalsIgnoreCase("S")
  }

  override def mostrarBienvenidaAlJugador(estadoDeLaAplicacion: EstadoAppJuegos): Unit =
    println("Bienvenido " + estadoDeLaAplicacion.jugador.nombre)

  override def pedirJugador(): String = {
    print("Introduzca su nombre de jugador: ")
    scala.io.StdIn.readLine()
  }

  override def mostrarBienvenida(): Unit =
    println("Bienvenido a la aplicación de juegos")

  override def mostrarConfirmacionDeCreacionDeJugador(estadoDeLaAplicacion: EstadoAppJuegos): Unit =
    println("El jugador " + estadoDeLaAplicacion.jugador.nombre + " ha sido creado. Bienvenido.")
}
