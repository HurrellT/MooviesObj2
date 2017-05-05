# MooviesObj2
Trabajo gral de la materia de Programacion con Objetos 2 UNQ

BRIAN: en el branch Adapter, implemente los mensajes mejoresPeliculas y usuariosMasActivos en Moovies. 
Hice algunas correcciones en los tests e implemente los getters que faltaban en UsuarioData, RatingData, 
AmigosData, etc. Ademas cree la clase MooviesTest. 

Lo que falta:
- Arreglar el error de PeliculaFileReader que no puede transformar el String en LocalDate.
- En la clase Usuario, ver que hacemos con la variable de instancia generoFavorito. (Ver que hacer)
- En la clase PeliculaFileReader, ver como carajo leer los generos del archivo para pasarselo al PeliculaData.
- Agregar la busqueda de pelicula en calificarPelicula (si la pelicula esta, cambiar el puntaje)

IMPORTANTE: habria que aclarar que nosotros asumimos que toda pelicula vista por un usuario es calificada.
Lo que habiamos supuesto al inicio (que si el usuario ve la pelicula pero no la califica esta lleva un score
de cero) novale, porque no tenemos metodo que permita ver la pelicula sin calificarla. Revisar la nota en el 
metodo promedio de la clase Pelicula.

