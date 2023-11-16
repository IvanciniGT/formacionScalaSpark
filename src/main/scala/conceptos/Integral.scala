package com.curso
package conceptos

object Integral {
  def main(args:Array[String]) : Unit ={
    val y = (x:Double) => x*x + Math.sin(x) * Math.pow(Math.E,x)
    var tin=System.currentTimeMillis()
    println(s"La integral entre 0 y 5 de $y, vale: ${integra(y,0,5)()}")
    var tout=System.currentTimeMillis()
    println(s"Hemos tardado ${(tout-tin)} milisegundos")
    tin=System.currentTimeMillis()
    println(s"La integral entre 0 y 5 de $y, vale: ${integraMapReduce(y,0,5)}")
    tout=System.currentTimeMillis()
    println(s"Hemos tardado ${(tout-tin)} milisegundos")
    //125/3
    //25
    println(calcularNIntervalos(0,10,3))

  }

  def integra(y:(Double) => Double,
              x1:Double,
              x2:Double,
              tolerancia: Double = 0.0000000001)(
              areaTrapezoideGrande:Double = areaTrapezoide(x1,x2,y(x1),y(x2))):Double = {
    //val areaTrapezoideGrande = areaTrapezoide(x1,x2,y(x1),y(x2))
    val xm = (x2+x1)/2
    val areaTrapezoidePequenoDeLaIzquierda = areaTrapezoide(x1,xm,y(x1),y(xm))
    val areaTrapezoidePequenoDeLaDerecha   = areaTrapezoide(xm,x2,y(xm),y(x2))
    val diferenciaDeAreas = Math.abs(areaTrapezoideGrande-areaTrapezoidePequenoDeLaIzquierda-areaTrapezoidePequenoDeLaDerecha)
    if(diferenciaDeAreas > tolerancia)
      integra(y,x1,xm, tolerancia)(areaTrapezoidePequenoDeLaIzquierda ) +
        integra(y,xm,x2, tolerancia)( areaTrapezoidePequenoDeLaDerecha)
    else
      areaTrapezoidePequenoDeLaIzquierda + areaTrapezoidePequenoDeLaDerecha
  }

  def areaTrapezoide(x1:Double, x2:Double, y1:Double, y2:Double):Double = (x2-x1)*(y1+y2)/2

  def calcularNIntervalos(x1:Double, x2:Double, N: Int): List[Tuple2[Double, Double]] = {
    /*val tamanoSubintervalo = (x2-x1)/N
    val intervalos = new ListBuffer[Tuple2[Double, Double]]()
    var x1_intervalo = x1
    var x2_intervalo:Double=x1;
    for(n <- 1 until N){
      x2_intervalo = x1_intervalo+tamanoSubintervalo
      intervalos.addOne(x1_intervalo, x2_intervalo)
      x1_intervalo = x2_intervalo
    }
    intervalos.addOne(x1_intervalo, x2)
    intervalos.toList*/

    val tamanoSubintervalo = (x2-x1)/N
    ( 0 until N)
      .map( numeroDeIntervalo => {
        val x_inicial = x1 + numeroDeIntervalo * tamanoSubintervalo
        val x_final = if (numeroDeIntervalo != N-1) x1 + (numeroDeIntervalo+1) * tamanoSubintervalo else x2
        ( x_inicial, x_final )
      }).toList
}

  def integraMapReduce(y:(Double) => Double, x1:Double, x2:Double, tolerancia: Double = 0.0000000001, N: Int = 10):Double = {
    calcularNIntervalos(x1,x2,N)
      .map( intervalo => integra(y,intervalo._1, intervalo._2, tolerancia)())
      .sum
  }
}






