package com.curso
package diccionario

import org.scalatest.funsuite.AnyFunSuiteLike

class DiccionarioUtilsTest extends AnyFunSuiteLike {

  test("La distancia entre manzana y manzano es 1") {
    assert(DiccionarioUtils.distance("manzana", "manzano") == 1)
  }
  test("La distancia entre manzana y manana es 1") {
    assert(DiccionarioUtils.distance("manzana", "manzano") == 1)
  }
  test("La distancia entre manana y manzano es 2") {
    assert(DiccionarioUtils.distance("manana", "manzano") == 2)
  }
/*
  test("Cargar diccionario de Español" ){
    val palabrasCargadas: Map[String, Array[String ]] = DiccionarioUtils.leerFicheroDeDiccionario("src/test/resources/ficheros", "español")
    assert(palabrasCargadas.contains("manzana"))
    assert(palabrasCargadas.contains("melón"))
    assert(palabrasCargadas("manzana").length == 1)
    assert(palabrasCargadas("melón").length == 2)
    assert(palabrasCargadas("manzana")(0)== "Fruto del manzano")
    assert(palabrasCargadas("melón")(0)== "Fruto del melonero")
    assert(palabrasCargadas("melón")(1)== "Persona con pocas luces")
  }*/
}










