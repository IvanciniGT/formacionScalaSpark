package com.curso
package juegoapp.repositories

import juegoapp.JugadoresRepositorio
import juegoapp.entity.Jugador

import scala.collection.mutable.ListBuffer

object JugadoresRepositorioEnMySQL extends JugadoresRepositorio{

  private val listadoUsuariosRegistrados = new ListBuffer[Jugador]();
  cargaInicialDeUsuarios()

  private def cargaInicialDeUsuarios():Unit={
    val statement = DBConnectionProvider.connection.createStatement()
    statement.executeQuery("CREATE TABLE IF NOT EXISTS jugadores( nombre VARCHAR(50) NOT NULL")
    val listadoDeNombres = statement.executeQuery("SELECT nombre FROM jugadores")
    while(listadoDeNombres.next()){
      val jugador = new Jugador(listadoDeNombres.getString("nombre"))
      listadoUsuariosRegistrados += jugador
    }
  }

  override def existe(nombre: String): Boolean =
    listadoUsuariosRegistrados.exists(jugador => jugador.nombre == nombre)

  override def getJugador(nombre: String): Option[Jugador] =
    listadoUsuariosRegistrados.find(jugador => jugador.nombre == nombre)

  override def altaJugador(nombre: String): Jugador = {
    DBConnectionProvider.connection.createStatement().execute("INSERT INTO jugadores VALUES ('"+nombre+"')")
    val jugador = new Jugador(nombre)
    listadoUsuariosRegistrados += jugador
    jugador
  }

}
