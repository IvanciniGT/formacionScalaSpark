package com.curso
package juegoapp.juego.ahorcado

import juegoapp.entity.{Jugador, Partida}
import juegoapp.juego.Juego

object Ahorcado  extends Juego[AhorcadoPartida, AhorcadoReglas, AhorcadoInterfaz] {

  var repoPalabras: AhorcadoTemasRepositorio = _

  override def jugarPartida
  (jugador: Jugador, reglas: AhorcadoReglas, interfaz: AhorcadoInterfaz, nombreJuego:String): Partida = {
    var partida =reglas.iniciarPartida(jugador, nombreJuego)
    // Solicitar tema
    interfaz.mostrarBienvenidaAlJuego(partida)
    val tema: String = interfaz.solicitarTema(repoPalabras.temas)
    val palabra: String = repoPalabras.getPalabraAlAzar(tema)
    partida =reglas.asignarPalabra(partida, palabra)

    while(partida.resultado == null){
      val letra: Char = interfaz.solicitarLetra(partida)
      reglas.calculaResultado(partida, letra)
    }
    interfaz.mostrarResultadoDeLaPartida(partida)
    partida
  }
}
