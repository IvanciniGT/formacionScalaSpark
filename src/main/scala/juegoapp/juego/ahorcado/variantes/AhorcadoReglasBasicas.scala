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


  override def calculaResultado(partida: AhorcadoPartida, letra: Any*): AhorcadoPartida = {
    if(letra.length != 1) throw new IllegalArgumentException("Se debe pasar una letra")
    if(! letra(0).isInstanceOf[Char]) throw new IllegalArgumentException("Se debe pasar una letra")
    this.calculaResultadoInterno(partida, letra(0).asInstanceOf[Char])
  }
  private def calculaResultadoInterno(partida: AhorcadoPartida, letra: Char): AhorcadoPartida = {
    val palabraNormalizada = Utilidades.normalizarPalabra(partida.palabraAAdivinar)
    val nuevaLetra = Utilidades.normalizarCaracter(letra)

    var vidasNuevas = partida.vidasQueMeQuedan
    var letrasUsadasNuevas = partida.letrasUsadas
    var resultadosPartidaNuevos = partida.resultado

    if(letrasUsadasNuevas.contains(nuevaLetra)) return partida
    letrasUsadasNuevas = nuevaLetra :: letrasUsadasNuevas
    if(palabraNormalizada.contains(nuevaLetra)) {
      if(!palabraNormalizada.exists(
        caracter => !letrasUsadasNuevas.contains(caracter) && caracter != ' ' && caracter != '-'
      ))
        resultadosPartidaNuevos = ResultadosPartida.JugadorGana

    }else{
      vidasNuevas = vidasNuevas - 1
      if(vidasNuevas == 0)
        resultadosPartidaNuevos = ResultadosPartida.ComputadoraGana
    }
    new AhorcadoPartidaImpl(
      jugador = partida.jugador,
      nombreJuego = partida.nombreJuego,
      palabraAAdivinar = partida.palabraAAdivinar,
      vidasQueMeQuedan = vidasNuevas,
      resultado = resultadosPartidaNuevos,
      letrasUsadas = letrasUsadasNuevas
    )
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
  def normalizarPalabra(p: String): String = p.toList.map(normalizarCaracter).toString

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























