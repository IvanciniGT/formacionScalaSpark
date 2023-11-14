#language:es
  Característica: Diccionarios y significados

    Esquema del escenario: Preguntar por palabras de un idioma
      Dado     Un diccionario de idioma "español"
      Y        el diccionario contiene la palabra "manzana"
      Cuando   le pregunto al diccionario si existe la palabra "<palabraBuscada>"
      Entonces el diccionario debe contestar que si.

      Ejemplos:
      | palabraBuscada |
      | manzana        |
      | Manzana        |
      | MANZANA        |

    Escenario: Preguntar por una palabra no existente en el diccionario
      Dado     Un diccionario de idioma "español"
      Y        el diccionario no contiene la palabra "hello"
      Cuando   le pregunto al diccionario si existe la palabra "hello"
      Entonces el diccionario debe contestar que no.

    Escenario: Solicitar a un diccionario los significados de una palabra existente
      Dado     Un diccionario de idioma "español"
      Y        el diccionario contiene la palabra "manzana"
      Cuando   le pregunto al diccionario por los significados de la palabra "manzana"
      Entonces el diccionario debe devolver un listado de significados
      Y        ese listado debe contener 1 significado
      Y        el significado debe ser "Fruto del manzano"

    Escenario: Solicitar a un diccionario los significados de una palabra no existente
        Dado     Un diccionario de idioma "español"
        Y        el diccionario no contiene la palabra "hello"
        Cuando   le pregunto al diccionario por los significados de la palabra "hello"
        Entonces el diccionario debe devolver nada

      Escenario: Solicitar a un diccionario los significados de una palabra existente con varios significados
        Dado     Un diccionario de idioma "español"
        Y        el diccionario contiene la palabra "melón"
        Cuando   le pregunto al diccionario por los significados de la palabra "melón"
        Entonces el diccionario debe devolver un listado de significados
        Y        ese listado debe contener 2 significados
        Y        el significado debe ser "Fruto del melonero"
        Y        el significado debe ser "Persona con pocas luces"

        Escenario: Solicitar sugerencias para un término inexsistente en el diccionario
        Dado     Un diccionario de idioma "español"
        Y           el diccionario contiene la palabra "manzana"
        Y           el diccionario contiene la palabra "mañana"
        Y           el diccionario contiene la palabra "ananá"
        Y           el diccionario contiene la palabra "manzano"
        Y           el diccionario contiewne la palabra "melón"
        Cuando      solicito las sugerencias de la palabra "manana"
        Entonces    el diccionario debe devolver un listado de sugerencias
        Y           ese listado debe contener "mañana"
        Y           ese listado debe contener "manzana"
        Y           ese listado debe contener "manzano"
        Y           ese listado debe contener "ananá"
        Y           ese listado no debe contener "melón"
        Y           la palabra "mañana" se devuelte antes de la palabra "manzano"
        Y           la palabra "mañana" se devuelte antes de la palabra "ananá"

        Escenario: Asegurar que un diccionario de un idioma realmente sea de ese idioma
          Dado      un diccionario supuestamente de idioma "español"
          Y         el diccionario contiene la palabra "manzana"
          Y         el diccionario contiene la palabra "mañana"
          Y         el diccionario contiene la palabra "ananá"
          Y         el diccionario contiene la palabra "manzano"
          Y         el diccionario contiene la palabra "melón"
          Cuando    pregunto al diccionario por su idioma
          Entonces  el diccionario debe contestar que su idioma es "español"


