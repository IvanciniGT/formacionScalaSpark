package com.curso
package diccionario

import scala.io.Source

trait Diccionario {
  def idioma:String
  def existe(palabra:String):Boolean
  def getSignificados(palabra:String):Option[List[String]]
  def getSugerencias(palabra:String):List[String]
}

trait SuministradorDeDiccionarios {
  def tienesDiccionariosDe(idioma:String):Boolean
  def getDiccionario(idioma:String):Option[Diccionario]
}

object DiccionarioUtils{
  def distance(s1: String, s2: String): Int = {
    val dist = Array.tabulate(s2.length + 1, s1.length + 1) { (j, i) => if (j == 0) i else if (i == 0) j else 0 }

    @inline
    def minimum(i: Int*): Int = i.min

    for {j <- dist.indices.tail
         i <- dist(0).indices.tail} dist(j)(i) =
      if (s2(j - 1) == s1(i - 1)) dist(j - 1)(i - 1)
      else minimum(dist(j - 1)(i) + 1, dist(j)(i - 1) + 1, dist(j - 1)(i - 1) + 1)

    dist(s2.length)(s1.length)
  }

  def normalizarPalabra(palabra:String): String = palabra.trim().toLowerCase()

  def leerFicheroDeDiccionario(carpeta:String, idioma:String): Map[String, Array[String]] ={
    val nombreDelFichero = s"$carpeta/$idioma.diccionario.txt"
    val canalLectura = Source.fromFile(nombreDelFichero)
    val valorADevolver = canalLectura.getLines()
      .map(linea => linea.split("="))
      .map(array => (normalizarPalabra(array(0)), array(1).split("\\|")))
      .toMap
    canalLectura.close()
    valorADevolver
  }
}










