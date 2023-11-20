package com.curso
package juegoapp.juego.ahorcado

import com.curso.juegoapp.entity.{Jugador, Partida}
import com.curso.juegoapp.juego.Juego

import scala.util.Random

object Ahorcado  extends Juego[AhorcadoPartida, AhorcadoReglas, AhorcadoInterfaz] {

  override def jugarPartida
  (jugador: Jugador, reglas: AhorcadoReglas, interfaz: AhorcadoInterfaz, nombreJuego:String ): Partida = {
    val partida = new AhorcadoPartida(jugador,nombreJuego );
    interfaz.mostrarBienvenidaAlJuego(partida)
    partida.eleccionDeLaComputadora = eleccionAlAzar(reglas.getEleccionesPermitidas)
    partida.eleccionDelJugador = interfaz.pedirEleccionJugador(partida, reglas);
    partida.resultado = reglas.calculaResultado(partida);
    interfaz.mostrarResultadoDeLaPartida(partida)
    partida
  }

  def eleccionAlAzar(valores: List[PPTEleccion]):PPTEleccion = valores(Random.nextInt(valores.length))

}
