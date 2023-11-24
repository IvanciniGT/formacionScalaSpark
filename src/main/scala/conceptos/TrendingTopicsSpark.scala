package com.curso
package conceptos

import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

object TrendingTopicsSpark {

  def main(args:Array[String]) : Unit ={

    val configuracion = new SparkConf()
      .setAppName("TrendingTopics")
      .setMaster("local[*]")

    val conexion = new SparkContext(configuracion)
    val palabrasProhibidas = List("caca", "culo", "pedo", "pis", "mierda")



    val canal = Source.fromFile("src/main/resources/ficheros/tweets.txt")
    val trendingTopics = conexion.parallelize(canal.getLines().toList, 17)
      .map( _.replace("#", " #"))
      .flatMap( _.split("[\\s,.;:+/()=`_-]+"))
      .filter( _.startsWith("#") )
      .repartition(5)
      .map(_.toLowerCase())
      .map(_.substring(1))
      .filter( hashtag =>
        //palabrasProhibidas.filter(palabraProhibida => hashtag.contains(palabraProhibida))
        //                  .length == 0

        //  palabrasProhibidas.count(palabraProhibida => hashtag.contains(palabraProhibida)) == 0
        !palabrasProhibidas.exists(palabraProhibida => hashtag.contains(palabraProhibida))
      )
      .groupBy( hashtag => hashtag)
      .map(tupla => (tupla._1, tupla._2.toList.length))
      .sortBy( tupla => tupla._2, ascending = false)
      .map(tupla => tupla._1)
      .take(10)

    trendingTopics
      .foreach(resultado => println(resultado))

    canal.close()

    //(1 to 5).toList.flatMap(contarHasta _).foreach(println)
  }
/*
  def contarHasta(tamano:Int):List[Int]={
    (1 to tamano).toList
    //listaInicial.map( _ * 2 )
    // listaInicial.map( numero => numero * 2 )
  }*/
}
