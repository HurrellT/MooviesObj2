# MooviesObj2
Trabajo general de la materia Programacion con Objetos 2 UNQ
-----------------------------------------------------------------------------------------------------------------------------------
  Este trabajo consistió en implementar un sistema de informacion de peliculas, donde se pueden suscribir usuarios, agregar peliculas, e importar informacion sobre ellas de Imdb, mediante archivos CSV.
  
-----------------------------------------------------------------------------------------------------------------------------------

TOMAS 16-6: Diego Torres me dijo que hay que hacer los ultimos 2 puntos (Suscripciones a géneros y subgéneros, Recomendaciones)

BRIAN 20-6: Ya arreglé el MooviesTest. Lo unico, el test que ya estaba (que creaba peliculas y usuarios a partir de los archivos de prueba) lo deje comentado, no se si seria necesario. Ademas hice un nuevo branch (generos) donde esta la clase Genero (incompleta) y lo que se puede del PeliculaTest.

Lo que falta:
- Arreglar el error de PeliculaFileReader que no puede transformar el String en LocalDate.
- En la clase Usuario, ver que hacemos con la variable de instancia generoFavorito. (Ver que hacer)
- En la clase PeliculaFileReader, ver como carajo leer los generos del archivo para pasarselo al PeliculaData.
- Agregar la busqueda de pelicula en calificarPelicula (si la pelicula esta, cambiar el puntaje)

TOMAS 29-6:
Para completar la covertura queda.
- En Moovies:
  - actualizarInfo() (hay que revisar el FileReaderManager)
- El FileReaderManager
- CSVFileReader
