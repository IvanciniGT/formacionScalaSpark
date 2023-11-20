package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.entity.{Jugador, Partida}

class PPTPartida (jugador:Jugador, nombreJuego: String) extends Partida(jugador, nombreJuego) {
  var eleccionDeLaComputadora: PPTEleccion = _
  var eleccionDelJugador:PPTEleccion = _
}
