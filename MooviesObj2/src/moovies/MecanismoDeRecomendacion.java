package moovies;

import java.util.List;

public interface MecanismoDeRecomendacion {
	
	public List<Pelicula> recomendarPeliculaPara(Usuario user, Moovies moovies);

}
