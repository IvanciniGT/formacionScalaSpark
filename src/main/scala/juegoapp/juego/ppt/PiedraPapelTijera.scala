package com.curso
package juegoapp.juego.ppt

import com.curso.juegoapp.entity.{Jugador, Partida}
import com.curso.juegoapp.juego.Juego

import scala.util.Random

object PiedraPapelTijera  extends Juego[PPTPartida, PPTReglas, PPTInterfaz] {

  override def jugarPartida
  (jugador: Jugador, reglas: PPTReglas, interfaz: PPTInterfaz,nombreJuego:String ): Partida = {
    val partida = new PPTPartida(jugador,nombreJuego );
    interfaz.mostrarBienvenidaAlJuego(partida)
    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(partida, reglas);
    reglas.calculaResultado(partida);
    interfaz.mostrarResultadoDeLaPartida(partida)
    partida
  }

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = valores(Random.nextInt(valores.length))

}
