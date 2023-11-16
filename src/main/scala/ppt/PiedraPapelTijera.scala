package com.curso
package ppt
import ppt.ResultadosPartida.Resultado

import scala.util.Random

class PiedraPapelTijera (interfaz: PPTInterfaz, reglas: PPTReglas) extends Juego {

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = valores(Random.nextInt(valores.length))

  override def jugarPartida(jugador: Jugador): Resultado = {
    interfaz.mostrarBienvenidaAlJuego(jugador);

    val partida = new PPTPartida();
    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(jugador, reglas.getEleccionesPermitidas);
    partida.resultado = reglas.calculaResultado(partida.eleccionDeLaComputadora, partida.eleccionDelJugador);

    interfaz.mostrarResultadoDeLaPartida(jugador, partida)
    partida.resultado
  }
}
