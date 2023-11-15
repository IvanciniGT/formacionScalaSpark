package com.curso
package diccionario

import java.io.File
import java.nio.file.Files
import scala.collection.mutable
import scala.io.Source

trait Diccionario {
  def idioma:String
  def existe(palabra:String):Boolean
  def getSignificados(palabra:String):Option[Array[String]]
  def getSugerencias(palabra:String):Array[String]
}

class DiccionarioCargadoDesdeFichero (val idioma: String, private val palabras:Map[String, Array[String]]) extends Diccionario {
  override def existe(palabra: String): Boolean = palabras.contains(DiccionarioUtils.normalizarPalabra(palabra))
  override def getSignificados(palabra: String): Option[Array[String]] = palabras.get(DiccionarioUtils.normalizarPalabra(palabra))
  override def getSugerencias(palabra: String): Array[String] =
    DiccionarioUtils.extraerPalabrasSimilares(palabra, palabras.keys.toList)
}

trait SuministradorDeDiccionarios {
  def tienesDiccionariosDe(idioma:String):Boolean
  def getDiccionario(idioma:String):Option[Diccionario]
}

object SuministradorDeDiccionarios extends SuministradorDeDiccionarios {
  private val diccionarios:mutable.WeakHashMap[String, Diccionario] = new mutable.WeakHashMap() // CACHE
  override def tienesDiccionariosDe(idioma: String): Boolean =
    diccionarios.contains(idioma) || DiccionarioUtils.existeFicheroPara(idioma)

  override def getDiccionario(idioma: String): Option[Diccionario] = {
    if(!diccionarios.contains(idioma) && tienesDiccionariosDe(idioma)){
      val diccionario = new DiccionarioCargadoDesdeFichero(idioma,
        DiccionarioUtils.leerFicheroDeDiccionario(idioma))
      diccionarios.put(idioma, diccionario)
    }
    diccionarios.get(idioma)
  }
}

object DiccionarioUtils{

  private val DISTANCIA_MAXIMA = 2
  private val NUMERO_MAXIMO_DE_SUGERENCIAS = 8
  private val carpeta = "src/main/resources/ficheros"

  def rutaArchivoDiccionario(idioma:String):String = s"$carpeta/$idioma.diccionario.txt"

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
  def existeFicheroPara(idioma:String):Boolean = Files.exists(new File(rutaArchivoDiccionario(idioma)).toPath)
  def leerFicheroDeDiccionario(idioma:String): Map[String, Array[String]] ={
    val nombreDelFichero = rutaArchivoDiccionario(idioma)
    val canalLectura = Source.fromFile(nombreDelFichero)
    val valorADevolver = canalLectura.getLines()
      .map(linea => linea.split("="))
      .map(array => (normalizarPalabra(array(0)), array(1).split("\\|")))
      .toMap
    canalLectura.close()
    valorADevolver
  }
  def extraerPalabrasSimilares(palabra:String,
                               posiblesSimilares:List[String],
                               distanciaMaxima:Int = DISTANCIA_MAXIMA,
                               numeroMaximoDeSugerencias:Int = NUMERO_MAXIMO_DE_SUGERENCIAS
                              ): Array[String] = {
    val palabraObjetivo = normalizarPalabra(palabra)
    posiblesSimilares                                                                          // Para cada potencial palabra
      .filter(potencialPalabraSimilar => Math.abs(potencialPalabraSimilar.length - palabraObjetivo.length)<= distanciaMaxima)  // Me quedo con ella si tiene un tamao similar a la objetivo
      .map(potencialPalabraSimilar => (potencialPalabraSimilar, distance(potencialPalabraSimilar, palabraObjetivo)))                           // Le calculo su distancia a la palabra objetivo
      .filter(tupla => tupla._2 <= distanciaMaxima)                                            // Me quedo solo con las similares (distancia menor o igual a la maxima)
      .sortBy(tupla => tupla._2)                                                               // Ordeno, primero las más similares
      .take(numeroMaximoDeSugerencias)                                                                                 // Me quedo con las N primeras
      .map(tupla => tupla._1)                                                                  // Ya descarto las puntuaciones... me quedo solo con las palabras
      .toArray                                                                                 // Lo devuelvo como un array
  }

}










