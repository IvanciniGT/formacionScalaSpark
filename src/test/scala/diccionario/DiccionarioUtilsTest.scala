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
}
