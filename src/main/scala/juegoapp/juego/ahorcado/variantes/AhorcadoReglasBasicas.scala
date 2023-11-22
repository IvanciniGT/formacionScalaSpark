package com.curso
package juegoapp.juego.ahorcado.variantes

import juegoapp.entity.{Jugador, ResultadosPartida}
import juegoapp.juego.ahorcado.{AhorcadoPartida, AhorcadoReglas}

object AhorcadoReglasBasicas extends AhorcadoReglas{

  val vidasIniciales = 6;

  override def iniciarPartida(jugador: Jugador, nombreJuego: String): AhorcadoPartida =
    new AhorcadoPartidaImpl(jugador = jugador, nombreJuego = nombreJuego)

  override def asignarPalabra(partida: AhorcadoPartida, palabra: String): AhorcadoPartida =
    new AhorcadoPartidaImpl(jugador = partida.jugador,
                            nombreJuego = partida.nombreJuego,
                            palabraAAdivinar = palabra)


  override def calculaResultado(partida: AhorcadoPartida, letra: Object*): AhorcadoPartida = {
    this.calculaResultado(partida, letra(0).asInstanceOf[Char])
  }
  private def calculaResultado(partida: AhorcadoPartida, letra: Char): AhorcadoPartida = {

  }


}

private class AhorcadoPartidaImpl (
  val palabraAAdivinar: String = _,
  val vidasQueMeQuedan: Int = AhorcadoReglasBasicas.vidasIniciales,
  val resultado: ResultadosPartida.Resultado = _,
  val jugador: Jugador = _,
  val nombreJuego: String = _,
  val letrasUsadas: List[Char] = List()
)extends AhorcadoPartida {
  val palabraEnmascarada:String = if (palabraAAdivinar == null) null
                                  else Utilidades.enmascararPalabra(palabraAAdivinar,letrasUsadas )
}

private object Utilidades {
  def normalizarCaracter(c:Char): Char = c.toLower

  def enmascararPalabra(palabraAAdivinar: String, letrasUsadas: List[Char]): String = {
    palabraAAdivinar.toList.map(
      caracter => {
        if(
          caracter == ' ' || caracter == '-' ||
          letrasUsadas.contains(normalizarCaracter(caracter))
        ) caracter
        else
          '_'
      }
    ).toString
  }
}