package com.curso

import java.sql.{Connection, DriverManager, ResultSet}

object H2DatabaseSQL {
  def main(args: Array[String]): Unit = {
    // Define the JDBC URL for the H2 database
    val url = "jdbc:h2:mem:test" // This creates an in-memory database called "test"

    // Create a connection to the H2 database
    //Class.forName("org.h2.Driver")
    val connection: Connection = DriverManager.getConnection(url, "sa", "")

    try {
      // Execute SQL queries or commands here
      val statement = connection.createStatement()

      // Example: Create a table
      statement.execute("CREATE TABLE IF NOT EXISTS my_table (id INT PRIMARY KEY, name VARCHAR(255))")

      // Example: Insert data
      statement.execute("INSERT INTO my_table VALUES (1, 'John')")
      statement.execute("INSERT INTO my_table VALUES (2, 'Alice')")

      // Example: Query data
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM my_table")

      while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val name = resultSet.getString("name")
        println(s"ID: $id, Name: $name")
      }

      resultSet.close()
    } finally {
      // Close the database connection
      if (connection != null) {
        connection.close()
      }
    }
  }
}