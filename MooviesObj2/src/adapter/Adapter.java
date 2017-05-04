package adapter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Adapter {

	/*
	 *	Colaboradores Internos 
	 */
	
	private List<UsuarioData> userData;
	
	private List<PeliculaData> movieData;
	
	private List<RatingData> ratingData;
	
	private List<AmigosData> friendsData;
	
	/*
	 * 	Metodos
	 */
	
	public void setRating() {
		
		int index = 0;
		
		for (int i = 0; i < ratingData.size(); i++) {			
			
			//Guardar info
			int userId 	= ratingData.get(index).getUserId();
			int movieId = ratingData.get(index).getMovieId();
			int score 	= ratingData.get(index).getScore();
			
			//Buscar usuario
			int indexU = 0;
			
			UsuarioData user = userData.get(indexU);
			while (not (user.getId() == userId)) {
				indexU++;
				user = userData.get(indexU);
			}
			
			//Buscar pelicula
			//REFACTORIZAR EN UNA SUBTAREA
			int indexP = 0;
			
			PeliculaData movie = movieData.get(indexP);
			while (not (movie.getId() == movieId)) {
				indexP++;
				movie = movieData.get(indexP);
			}
			
			//Registrar la calificacion del usuario
			user.getUser().calificarPelicula(score,movie.getMovie());
		}
		
	}
}
