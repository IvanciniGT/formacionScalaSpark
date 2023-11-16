package com.curso
package ppt
import ppt.ResultadosPartida.Resultado

class PiedraPapelTijera (interfaz: PPTInterfaz, reglas: PPTReglas) extends Juego {

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = ???

  override def jugarPartida(jugador: Jugador): Resultado = {
    interfaz.mostrarBienvenidaAlJuego(jugador);

    val partida = new PPTPartida();
    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(jugador, reglas.getEleccionesPermitidas;
    partida.resultado = reglas.calculaResultado(partida.eleccionDeLaComputadora, partida.eleccionDelJugador);

    interfaz.mostrarResultadoDeLaPartida(jugador, partida)
    partida.resultado
  }
}
