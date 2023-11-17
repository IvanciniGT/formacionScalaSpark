package com.curso
package juego.ppt

import juego.Partida

case class PPTPartida () extends Partida {
  var eleccionDeLaComputadora: PPTEleccion = _
  var eleccionDelJugador:PPTEleccion = _
}
