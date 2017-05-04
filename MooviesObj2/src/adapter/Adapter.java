package adapter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import CSVFileReaders.PeliculaFileReader;
import CSVFileReaders.RatingsFileReader;
import CSVFileReaders.UsuarioFileReader;

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
	
	/*
	 * Setters
	 */
	
	public void procesarUsuario(String filePath) {
		//Crear un RatingFileReader
		UsuarioFileReader usuarioReader = new UsuarioFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.userData = usuarioReader.readFile();
	}
	
	public void procesarPelicula(String filePath) {
		//Crear un RatingFileReader
		PeliculaFileReader peliculaReader = new PeliculaFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.movieData = peliculaReader.readFile();
	}
	
	public void procesarRatings(String filePath) {
		//Crear un RatingFileReader
		RatingsFileReader ratingReader = new RatingsFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.ratingData = ratingReader.readFile();
	}
	
	public void procesarAmigos(String filePath) {
		//Crear un RatingFileReader
		AmigosFileReader amigosReader = new AmigosFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.friendsData = amigosReader.readFile();
	}
	
	//Precondicion: Ya se cargaron los datos.
	//
	public void registrarRatings() {
		
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

	public List<RatingData> getRatingData() {
		
		return ratingData;
	}
}
