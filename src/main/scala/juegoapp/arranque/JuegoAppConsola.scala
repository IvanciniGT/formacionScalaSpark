package com.curso
package juegoapp.arranque

import juegoapp.JuegoAppFlujo
import juegoapp.interfaces.InterfazAppJuegosConsola
import juegoapp.repositories.{JuegosRepositorioParaConsola, JugadoresRepositorioEnMySQL, PartidasRepositorioEnRAM}

object JuegoAppConsola {

  def main(args:Array[String]): Unit = {
    new JuegoAppFlujo(
                        InterfazAppJuegosConsola,
                        JuegosRepositorioParaConsola,
                        JugadoresRepositorioEnMySQL,
                        PartidasRepositorioEnRAM).iniciarAppJuego()
    }

}
