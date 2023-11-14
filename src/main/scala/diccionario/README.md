# Librería del diccionario

## Estructuras de datos

### Persistencia de las palabras y sus significados

En un fichero que llamaré `<idioma>.palabras.txt`.

```txt
manzana=Fruto del manzano
melón=Fruto del melonero|Persona con pocas luces
```

### En qué estructura de datos cargo eso en memoria RAM

#### Los diccionarios

Un mapa de `Diccionario` donde cada `Diccionario` tiene una clave que es el nombre del idioma.
Para éste mapa es para el que me interesa utilizar un WeakMap

#### Las palabras de un idioma

Vamos a guardar los datos en un diccionario de listas.
Donde cada lista de significados tiene una clave que es la palabra.
En este caso utilizaremos un mapa normal.

# Qué otras cosas necesitamos a la hora de montar esta librería

## Funciones 

### La función Distancia de Levenshtein

Que mide el número de cambios (añadidos, eliminados o reemplazados) que es es encesario hacer 
en una palabra para llegar a otra

```scala
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
```

## Para calcular las sugerencias de una palabra: "manana", que he de hacer?

ALGORITMO!

MAPA con las palabras del diccionario

mañana:
    Adverbio de tiempo
    Sustantivo femenino
    Adjetivo
manzana: 
    Fruto del manzano
melón:
    Fruto del melonero
    Persona con pocas luces

Sugerencias de "manana"
    - mañana
    - manzana











