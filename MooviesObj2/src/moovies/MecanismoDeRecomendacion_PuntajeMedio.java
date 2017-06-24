package moovies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeMedio implements MecanismoDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPeliculaPara(Usuario user, Moovies moovies) {
		int condicionMinimaDeAmigos = 1; 	//1 para que la comparacion de amigos en esRecomendacion (que usa >) 
											//cuente a partir del 2 amigo en adelante, para no repetir codigo. 
		//Obtengo las peliculas y filtro segun las condiciones para recomendar con puntaje alto.
		List<Pelicula> pelis = new ArrayList<>();

		Stream<Pelicula> peliculasPorAmigos = moovies.getPeliculas().stream();
		peliculasPorAmigos	.filter(p -> p.esRecomendacionPara(user, 3, condicionMinimaDeAmigos))
							.map(p -> pelis.add(p));
		
//		sortBy.imdb(ES UN STRING) -- Hay que convertir de alguna manera el string a int
			
		}
		
		return res;
	}

}
