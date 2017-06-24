package moovies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeAlto implements MecanismoDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPeliculaPara(Usuario user,Moovies moovies) {
		int condicionMinimaDeAmigos = 2;
		
		//Obtengo las peliculas y filtro segun las condiciones para recomendar con puntaje alto.
		List<Pelicula> res = new ArrayList<>();

		Stream<Pelicula> peliculasPorAmigos = moovies.getPeliculas().stream();
		peliculasPorAmigos	.filter(p -> p.esRecomendacionPara(user, 4, condicionMinimaDeAmigos))
							.map(p -> res.add(p));
		
		return res;		
//		peliculasPorAmigos	.filter(m -> m.esRecomendacionPara(user, 4, condicionMinimaDeAmigos));
//		return peliculasPorAmigos.collect(Collectors.toList());
		//No sirve porque se cierra el stream. 
		//Por eso guardo en una variable nueva las peliculas resultantes del filtro.
	}

}