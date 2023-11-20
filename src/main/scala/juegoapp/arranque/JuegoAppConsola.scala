package com.curso
package juegoapp.arranque

import juegoapp.JuegoAppFlujo
import juegoapp.interfaces.InterfazAppJuegosConsola
import juegoapp.repositories.{JuegosRepositorioParaConsola, JugadoresRepositorioEnRAM, PartidasRepositorioEnRAM}

object JuegoAppConsola {

  def main(args:Array[String]): Unit = {
    new JuegoAppFlujo(
                        InterfazAppJuegosConsola,
                        JuegosRepositorioParaConsola,
                        JugadoresRepositorioEnRAM,
                        PartidasRepositorioEnRAM).iniciarAppJuego()
    }

}
