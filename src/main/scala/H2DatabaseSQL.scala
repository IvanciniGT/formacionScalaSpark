package com.curso

import java.sql.{Connection, DriverManager, ResultSet}

object H2DatabaseSQL {
  def main(args: Array[String]): Unit = {
    //val url = "jdbc:h2:mem:test"
    //Class.forName("org.h2.Driver")
    //val connection: Connection = DriverManager.getConnection(url, "sa", "")
    val url = "jdbc:mysql://63.32.44.28:3333/midb"
    Class.forName("com.mysql.cj.jdbc.Driver")
    val connection: Connection = DriverManager.getConnection(url, "usuario", "password")
    try {
      val statement = connection.createStatement()
      statement.execute("CREATE TABLE IF NOT EXISTS personas (id INT PRIMARY KEY, nombre VARCHAR(255))")
      statement.execute("DELETE FROM personas")
      statement.execute("INSERT INTO personas VALUES (1, 'Felipe')")
      statement.execute("INSERT INTO personas VALUES (2, 'Menchu')")
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM personas")

      while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val nombre = resultSet.getString("nombre")
        println(s"ID: $id, nombre: $nombre")
      }
      resultSet.close()
    } finally {
      if (connection != null) {
        connection.close()
      }
    }
  }
}





















