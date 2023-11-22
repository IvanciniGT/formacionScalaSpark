package com.curso
package juegoapp.repositories

import java.sql.{Connection, DriverManager}

object DBConnectionProvider {
  val url = "jdbc:mysql://63.32.44.28:3333/midb"
  val driver = "com.mysql.cj.jdbc.Driver"
  val usuario = "usuario"
  val contrasena = "password"
  Class.forName(driver)
  val connection: Connection = DriverManager.getConnection(url, usuario, contrasena)
}





















