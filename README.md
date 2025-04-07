# GestorFutbol.java - Refactorización

Este proyecto consiste en refactorizar el archivo GestorFutbol.java corrigiendo todas las issues detectadas por SonarQube.

## Correcciones realizadas

- Se eliminó un import no utilizado (`BigDecimal`) para mejorar la limpieza del código.
- Se aplicó LOGGER.isLoggable(Level.INFO) antes de imprimir logs para evitar construir Strings innecesarios.
- Se combinaron ifs anidados para mejorar la legibilidad del código (Mergeable if statements).
- Se separó la lógica del método procesarTemporada en métodos auxiliares para reducir la complejidad.

Tras estas mejoras, SonarQube no detecta ninguna issue en el archivo.

---