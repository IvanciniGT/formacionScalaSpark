package com.curso
package juego.ppt

import juego.ResultadosPartida.Resultado
import juego.{Juego, Jugador}

import scala.util.Random

class PiedraPapelTijera  extends Juego {

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = valores(Random.nextInt(valores.length))

  override def jugarPartida(jugador: Jugador, interfaz: PPTInterfaz, reglas: PPTReglas): Resultado = {
    val partida = new PPTPartida();
    partida.jugador = jugador
    interfaz.mostrarBienvenidaAlJuego(partida);

    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(partida, reglas.getEleccionesPermitidas);
    partida.resultado = reglas.calculaResultado(partida);

    interfaz.mostrarResultadoDeLaPartida(partida)
    partida.resultado
  }
}
