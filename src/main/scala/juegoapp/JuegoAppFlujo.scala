package com.curso
package juegoapp

import juegoapp.entity.EstadoAppJuegos

import scala.collection.mutable.ListBuffer

class JuegoAppFlujo (private val interfaz: InterfazAppJuegos,
                     private val repositorioDeJuegos: JuegosRepositorio,
                     private val repositorioDeJugadores: JugadoresRepositorio,
                     private val repositorioDePartidas: PartidasRepositorio){

  private val LISTADO_OPCIONES = new ListBuffer[ Tuple2[String, (EstadoAppJuegos)=>{}] ]  ()
  LISTADO_OPCIONES += (
                            ("Jugar a un juego", this.jugar _),
                            ("Estadísticas", this.estadisticas _),
                            ("Salir", this.salir _)
                          );
  val estadoDeLaAplicacion = new EstadoAppJuegos();

  def iniciarAppJuego(): Unit = {
    interfaz.mostrarBienvenida();

    while(true) {
      if(estadoDeLaAplicacion.jugador == null) {
        val nombreJugador = interfaz.pedirJugador();
        if (repositorioDeJugadores.existe(nombreJugador)) {
          estadoDeLaAplicacion.jugador = repositorioDeJugadores.getJugador(nombreJugador).get;
          interfaz.mostrarBienvenidaAlJugador(estadoDeLaAplicacion)
        } else {
          if (interfaz.confirmaCreacionJugador(nombreJugador))
            estadoDeLaAplicacion.jugador = repositorioDeJugadores.altaJugador(nombreJugador)
        }
      }else {
        // Llegados a este punto, tendría jugador
        // Mostrar un menu con las opciones: JUGAR, ESTADISTICAS, SALIR
        val opcionSeleccionada = interfaz.solicitarOpcion(LISTADO_OPCIONES.map(_._1).toList, estadoDeLaAplicacion)
        // Ejecutamos la opción indicada
        LISTADO_OPCIONES.filter(opcion => opcion._1 == opcionSeleccionada).head._2(estadoDeLaAplicacion)
      }
    }
  }

  def jugar(estado: EstadoAppJuegos): Unit ={
    val juego = interfaz.solicitarJuego(repositorioDeJuegos.getJuegos)
    val partida = juego.jugarPartida(estado.jugador)
    repositorioDePartidas.altaPartida(partida)
  }
  def estadisticas(estado: EstadoAppJuegos): Unit ={
    val partidas = repositorioDePartidas.getPartidas(estado.jugador)
    interfaz.mostrarEstadisticas(estado.jugador, partidas)
  }
  def salir(estado: EstadoAppJuegos): Unit ={
    if(interfaz.confirmarSalida())
      System.exit(0)
  }

}
