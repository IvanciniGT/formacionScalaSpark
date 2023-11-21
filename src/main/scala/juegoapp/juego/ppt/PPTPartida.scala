package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.entity.{Jugador, Partida, ResultadosPartida}

class PPTPartida (val jugador:Jugador, val nombreJuego: String) extends Partida {
  var resultado: ResultadosPartida.Resultado = _
  var eleccionDeLaComputadora: PPTEleccion = _
  var eleccionDelJugador:PPTEleccion = _
}
