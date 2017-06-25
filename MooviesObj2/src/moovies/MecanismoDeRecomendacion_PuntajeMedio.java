package moovies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeMedio implements MecanismoDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPeliculaPara(Usuario user, Moovies moovies) {
		int condicionMinimaDeAmigos = 1; 	//1 para que la comparacion de amigos en esRecomendacion (que usa >) 
											//cuente a partir del 2 amigo en adelante, para no repetir codigo. 
		//Obtengo las peliculas y filtro segun las condiciones para recomendar con puntaje alto.
		Stream<Pelicula> peliculasPorAmigos = moovies.getPeliculas().stream();
		return peliculasPorAmigos	
				.filter(p -> p.esRecomendacionPara(user, 3, condicionMinimaDeAmigos))
				.sorted((a,b) -> b.getIdmb().compareTo(a.getIdmb()))
				.collect(Collectors.toList());
		
//		sortBy.imdb(ES UN STRING) -- Hay que convertir de alguna manera el string a int
	}

}
