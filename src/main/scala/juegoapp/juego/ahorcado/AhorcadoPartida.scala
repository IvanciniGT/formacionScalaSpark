package com.curso
package juegoapp.juego.ahorcado

import com.curso.juegoapp.entity.{Jugador, Partida}

class AhorcadoPartida(jugador:Jugador, nombreJuego: String) extends Partida(jugador, nombreJuego) {
  var eleccionDeLaComputadora: PPTEleccion = _
  var eleccionDelJugador:PPTEleccion = _
}
