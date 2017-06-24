package moovies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeAlto implements MecanismoDeRecomendacion {

	@Override
	public List<Pelicula> recomendarPeliculaPara(Usuario user,Moovies moovies) {
		int condicionMinimaDeAmigos = user.getAmigos().size() / 2;
		
		Stream<Pelicula> peliculasPorAmigos = moovies.getPeliculas().stream();
		peliculasPorAmigos	.filter(m -> m.esRecomendacionPara(user, 4, condicionMinimaDeAmigos));
		
		return peliculasPorAmigos.collect(Collectors.toList());
		//RETOCAR EL UML
	}

}

//			//Obtengo los usuarios que calificaron
//		List<Usuario> usuariosQueCalificaron = new ArrayList<>();
//		Stream<Calificacion> cal = calificaciones.stream();
//		cal.forEach(c -> usuariosQueCalificaron.add(c.getUsuario()));
//			//Cuento cuantos de mis amigos calificaron peliculas
//		int uQueCalif = 0;
//		for (int i = 0; i < usuariosQueCalificaron.size(); i++) {
//			if (usuariosQueCalificaron.get(i).getAmigos().contains(user)) {
//				uQueCalif++;
//			}
//		}
//			//Filtro las calif que hicieron mis amigos
//			//Filtro comparando los resultados