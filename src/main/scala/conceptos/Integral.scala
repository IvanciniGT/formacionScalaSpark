package com.curso
package conceptos

object Integral {
  def main(args:Array[String]) : Unit ={
    val y = (x:Double) => x*x
    print(s"La integral entre 0 y 5 de $y, vale: ${integra(y,0,5)}")
    //125/3
    //25
  }

  def integra(y:(Double) => Double, x1:Double, x2:Double, tolerancia: Double = 0.0000000001):Double = {
    val areaTrapezoideGrande = areaTrapezoide(x1,x2,y(x1),y(x2))
    val xm = (x2+x1)/2
    val areaTrapezoidePequenoDeLaIzquierda = areaTrapezoide(x1,xm,y(x1),y(xm))
    val areaTrapezoidePequenoDeLaDerecha   = areaTrapezoide(xm,x2,y(xm),y(x2))
    val diferenciaDeAreas = Math.abs(areaTrapezoideGrande-areaTrapezoidePequenoDeLaIzquierda-areaTrapezoidePequenoDeLaDerecha)
    if(diferenciaDeAreas > tolerancia)
      integra(y,x1,xm, tolerancia) +
        integra(y,xm,x2, tolerancia)
    else
      areaTrapezoidePequenoDeLaIzquierda + areaTrapezoidePequenoDeLaDerecha
  }

  def areaTrapezoide(x1:Double, x2:Double, y1:Double, y2:Double):Double = (x2-x1)*(y1+y2)/2
}
