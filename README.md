# MooviesObj2
Trabajo gral de la materia de Programacion con Objetos 2 UNQ

BRIAN: Pense en usar el README para que cada uno deje comentarios. Estuve mirando lo que hicimos el viernes,
y ya nos quedaba diferente lo que implementamos de lo que hay en el diagrama. A mi me parece que seria mejor
que las variables de instancia de Pelicula y Usuario que no son colecciones (id, codPostal, idmb, edad) sean Int,
lo que es mucho más facil de manejar. Tambien es mejor que los mensajes reciban Int (las id de los usuarios y de
las peliculas), y que en la implementacion lo transforme en un Integer y lo agrege a la coleccion correspondiente.
Aunque, se que el Map necesita Integer si o si, pero ¿es necesario que los ArrayList usen Integer? ¿No funcionarían
igual con Int?
