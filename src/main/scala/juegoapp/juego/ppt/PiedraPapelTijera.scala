package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.entity.{Jugador, Partida}
import com.curso.juegoapp.Juego

import scala.util.Random

class PiedraPapelTijera  extends Juego[PPTPartida, PPTReglas, PPTInterfaz] {

  override def jugarPartida
  (jugador: Jugador, reglas: PPTReglas, interfaz: PPTInterfaz): Partida = {
    val partida = new PPTPartida();
    partida.jugador = jugador
    interfaz.mostrarBienvenidaAlJuego(partida)
    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(partida, reglas);
    partida.resultado = reglas.calculaResultado(partida);
    interfaz.mostrarResultadoDeLaPartida(partida)
    partida
  }

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = valores(Random.nextInt(valores.length))

}
