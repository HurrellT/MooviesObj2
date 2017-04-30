# MooviesObj2
Trabajo gral de la materia de Programacion con Objetos 2 UNQ

BRIAN: Pense en usar el README para que cada uno deje comentarios. Estuve mirando lo que hicimos el viernes,
y ya nos quedaba diferente lo que implementamos de lo que hay en el diagrama. A mi me parece que seria mejor
que las variables de instancia de Pelicula y Usuario que no son colecciones (id, codPostal, idmb, edad) sean Int,
lo que es mucho más facil de manejar. Tambien es mejor que los mensajes reciban Int (las id de los usuarios y de
las peliculas), y que en la implementacion lo transforme en un Integer y lo agrege a la coleccion correspondiente.
Aunque, se que el Map necesita Integer si o si, pero ¿es necesario que los ArrayList usen Integer? ¿No funcionarían
igual con Int?

BRIAN: Además cree las clases CSVFileReader y una de las subclases (UsuarioFileReader), que vamos a necesitar para 
leer los archivos. Las adapte pero todavía no funcionan (también cree el test para UsuarioFileReader). Habria que crear 
subclases de CSVFileReader para peliculas, ratings y amigos (ya que los archivos que hay que leer son de esa informacion).

BRIAN: Mirando de nuevo el codigo de UsuarioFileReader me surgio una duda: ¿la id del usuario y de la pelicula deben ser
variables de instancia que se usan, o son datos que vienen en los archivos a leer y no importan, y por lo tanto no debe haber variable de instancia id para ninguno de los dos?
