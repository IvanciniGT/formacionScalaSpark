#language:es
  Característica: Suministardor de diccionarios

    Escenario: Preguntar por un idioma existente
      Dado     Un suministrador de diccionarios
      Y        el suministrador tiene diccionario de "español"
      Cuando   le pregunto al suministrador si tiene un diccionario del idioma "español"
      Entonces el suministrador debe contestar que si.

    Escenario: Preguntar por un idioma no existente
      Dado     Un suministrador de diccionarios
      Y        el suministrador no tiene diccionario de "elfico"
      Cuando   le pregunto al suministrador si tiene un diccionario del idioma "elfico"
      Entonces el suministrador debe contestar que no.

    Escenario: Solicitar un diccionarios de un idioma existente
      Dado     Un suministrador de diccionarios
      # val misuministrador:SuministradorDeDiccionario <---- Un valor
      Y        el suministrador tiene diccionario de "español"
      Cuando   le le pido al suministrador un diccionario del idioma "español"
      # val diccionario = miSuministrador.getDiccionario("idioma")
      Entonces el suministrador devuelve un diccionario
      # Asegurarme que el option que me devuelven contiene un objeto Diccionario
      Y        el diccionario devuelto es de "español"
      # Asegurarme que el diccionario es del idioma "español"

    Esquema del escenario: Solicitar un diccionarios de un idioma no existente
      Dado     Un suministrador de diccionarios
      # val misuministrador:SuministradorDeDiccionario <---- Un valor
      Y        el suministrador no tiene diccionario de "<idioma>"
      Cuando   le le pido al suministrador un diccionario del idioma "<idioma>"
      # val diccionario = miSuministrador.getDiccionario("idioma")
      Entonces el suministrador no me devuelve nada

      Ejemplos:
      | idioma          |
      | elfico          |
      | egipcio antiguo |







