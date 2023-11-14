package com.curso
package conceptos

import scala.collection.mutable.ListBuffer

trait FiguraGeometrica { // El equivalente a una interfaz en JAVA
  def area:Double
  def perimetro:Double
}

class Circunferencia(val radio: Double) extends FiguraGeometrica{
  override def area: Double = Math.PI*radio*radio

  override def perimetro: Double = 2*Math.PI*radio
}
class Paralelogramo (val base:Double,val lado:Double, angulo: Double, radianes:Boolean = false)
  extends FiguraGeometrica {
  val anguloEnRadianes = if (radianes) angulo else Math.toRadians(angulo)
  val anguloEnGrados = if (!radianes) angulo else Math.toDegrees(angulo)
  val altura = lado*Math.sin(anguloEnRadianes)
  override def area:Double = base*altura
  def perimetro:Double = 2*lado+ 2*base
}
class Rectangulo (base:Double,altura:Double) extends Paralelogramo(base,altura, 90)
class Cuadrado (lado:Double) extends Rectangulo(lado, lado)

object FigurasGeometricas {
  def main(args: Array[String]): Unit = {
    var c1 = new Cuadrado(10);
    println(c1.lado)
    println(c1.base)
    println(c1.altura)
    println(c1.area)
    println(c1.perimetro)
    //c1.lado = 20;
    //println(c1.lado)
    //println(c1.base)
    //println(c1.altura)

    val r1 = new Rectangulo(10,20)
    println(r1.area)
    println(r1.perimetro)
    val circulo1 = new Circunferencia(10)
    val figuras = new ListBuffer[FiguraGeometrica]();
    figuras += c1
    figuras += r1
    figuras += circulo1
    for(figura <- figuras){
      println(figura.area)
      println(figura.perimetro)
    }

  }

}







