# MooviesObj2
Trabajo gral de la materia de Programacion con Objetos 2 UNQ

BRIAN: en el branch Adapter, implemente los mensajes mejoresPeliculas y usuariosMasActivos en Moovies. 
Hice algunas correcciones en los tests e implemente los getters que faltaban en UsuarioData, RatingData, 
AmigosData, etc. Ademas cree la clase MooviesTest. 

Lo que falta:
1) Hacer un Merge de Master con Adapter. Ya no hace falta hacer el Merge con la otra rama (Eliminar-id).
2) Implementar registrarAmigos() en Adapter. HECHO
3) Arreglar el texto de los test para UsuarioFileReader y RatingFileReader (quedo como en el ejemplo del campus).
4) Crear test para PeliculaFileReader y AmigoFileReader (son casi identicos al de UsuarioFileReader).
5) Arreglar el error de PeliculaFileReader que no puede transformar el String en LocalDate.
6) En la clase Usuario, ver que hacemos con la variable de instancia generoFavorito.
7) En la clase PeliculaFileReader, ver como carajo leer los generos del archivo para pasarselo al PeliculaData.
8) Volver a corregir el diagrama!!!
9) Revisar en CSVFileReader la Resource Leak


IMPORTANTE: habria que aclarar que nosotros asumimos que toda pelicula vista por un usuario es calificada.
Lo que habiamos supuesto al inicio (que si el usuario ve la pelicula pero no la califica esta lleva un score
de cero) novale, porque no tenemos metodo que permita ver la pelicula sin calificarla. Revisar la nota en el 
metodo promedio de la clase Pelicula.

