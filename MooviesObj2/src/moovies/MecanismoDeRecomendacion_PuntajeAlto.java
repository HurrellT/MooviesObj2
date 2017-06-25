package moovies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeAlto implements MecanismoDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPeliculaPara(Usuario user,Moovies moovies) {
		int condicionMinimaDeAmigos = user.getAmigos().size() / 2;
		
		//Obtengo las peliculas y filtro segun las condiciones para recomendar con puntaje alto.
		Stream<Pelicula> peliculasPorAmigos = moovies.getPeliculas().stream();
		
		return peliculasPorAmigos	.filter(p -> p.esRecomendacionPara(user, 4, condicionMinimaDeAmigos))
									.collect(Collectors.toList());

//		peliculasPorAmigos	.filter(m -> m.esRecomendacionPara(user, 4, condicionMinimaDeAmigos));
//		return peliculasPorAmigos.collect(Collectors.toList());
		//Ese retorno no sirve porque ya se cerro el stream. 
		//Por eso guardo en una variable nueva las peliculas resultantes del filtro.
	}

}