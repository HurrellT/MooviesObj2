package moovies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MecanismoDeRecomendacion_PuntajeAlto implements MecanismoDeRecomendacion {

	@Override
	public void recomendarPeliculaPara(Usuario user) {
		int condicionMinimaDeAmigos = user.getAmigos().size() / 2;
		
		//Obtengo los amigos del usuario
		Stream<Usuario> amigos = user.getAmigos().stream();
		
		//Obtengo las calificaciones de cada amigo del usuario
		List<Calificacion> calificaciones = new ArrayList<>();
	
		amigos.forEach(a -> calificaciones.addAll(a.getCalificaciones()));

		//Obtengo las peliculas que fueron calificadas
		//por igual o mas cantidad de usuarios que la condicion. 
		Stream<Calificacion> cal 	= calificaciones.stream();
//		cal	.map(c -> c.getPeli())
//			.map(p -> p.getCalificaciones())
//			.forEach(cp -> cp.removeIf(amigos.anyMatch(cp.)));
		
		
		
		
		//Filtro las peliculas no calificadas por el usuario,
		//y luego filtro las peliculas con puntaje igual o mayor a 4.
		
		cal	.filter(c -> c.getUsuario() != (user))
			.filter(c -> c.getPuntaje() >= 4);
		
		//Se agregan las recomendaciones al usuario.
		//Ejemplo, recibe una notificacion con las recomendaciones nuevas.
//		cal.forEach(c -> user.agregarRecomendacion(c.getPeli()));
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