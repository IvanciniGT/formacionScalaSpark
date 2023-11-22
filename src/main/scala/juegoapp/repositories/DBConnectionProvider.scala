package com.curso
package juegoapp.repositories

import java.sql.{Connection, DriverManager}

object DBConnectionProvider {
  val url = "jdbc:mysql://3.250.35.170:3333/midb"
  val driver = "com.mysql.cj.jdbc.Driver"
  val usuario = "usuario"
  val contrasena = "password"
  Class.forName(driver)
  val connection: Connection = DriverManager.getConnection(url, usuario, contrasena)
}





















