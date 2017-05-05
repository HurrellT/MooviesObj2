package adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import CSVFileReaders.PeliculaFileReader;
import CSVFileReaders.RatingsFileReader;
import CSVFileReaders.UsuarioFileReader;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;
import CSVFileReaders.AmigosFileReader;

public class Adapter {

	/*
	 *	Colaboradores Internos 
	 */
	
	private List<UsuarioData> userData;
	
	private List<PeliculaData> movieData;
	
	private List<RatingData> ratingData;
	
	private List<AmigosData> friendsData;

	/*
	 * Getters
	 */
	
	public List<UsuarioData> getUserData() {
		
		return userData;
	}
	
	public List<PeliculaData> getMovieData() {
		
		return movieData;
	}

	public List<RatingData> getRatingData() {
		
		return ratingData;
	}
	
	public List<AmigosData> getFriendsData() {
		
		return friendsData;
	}
	
	/*
	 * Getters complejos (devuelven los datos finales)
	 */
	
	private Collection<Pelicula> getPeliculas() {
		Collection<Pelicula> nuevasPeliculas = new ArrayList<Pelicula>();
		int index = 0;
		for(int i = 0; i < movieData.size(); i++){
			nuevasPeliculas.add(movieData.get(index).getMovie());
			index++;
		}
		return nuevasPeliculas;
	}
	
	private Collection<Usuario> getUsuarios() {
		Collection<Usuario> nuevosUsuarios = new ArrayList<Usuario>();
		int index = 0;
		for(int i = 0; i < userData.size(); i++){
			nuevosUsuarios.add(userData.get(index).getUser());
			index++;
		}
		return nuevosUsuarios;
	}
	
	/*
	 * Setters (extraen la informacion de los archivos y la
	 * guardan en los colaboradores internos)
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
	
	/*
	 * Otros metodos
	 */
	
	public void registrarRatings() {
	//Precondicion: Ya se cargaron los datos.
		int index = 0;
		for (int i = 0; i < ratingData.size(); i++) {			
			//Guardar info
			int userId 	= ratingData.get(index).getUserId();
			int movieId = ratingData.get(index).getMovieId();
			int score 	= ratingData.get(index).getRating();
			//Buscar usuario
			int indexU = 0;
			UsuarioData user = userData.get(indexU);
			while (! (user.getId() == userId)) {
				indexU++;
				user = userData.get(indexU);
			}
			//Buscar pelicula
			PeliculaData movie = this.findPeliculaData(movieData, movieId);
			//Registrar la calificacion del usuario
			user.getUser().calificarPelicula(score, movie.getMovie());
		}
		
	}
	
	private PeliculaData findPeliculaData(List<PeliculaData> movieData, int movieId){
		int indexP = 0;
		PeliculaData movie = movieData.get(indexP);
		while (! (movie.getId() == movieId)) {
			indexP++;
			movie = movieData.get(indexP);
		}
		return movie;
	}

	public void registrarAmigos() {
		// FALTA IMPLEMENTAR!!!

	}
	
	public void integrarEnMoovies(Moovies mov) {
		Collection<Pelicula> pelis = this.getPeliculas();
		Collection<Usuario> users = this.getUsuarios();
		mov.getPeliculas().addAll(pelis);
		mov.getUsuarios().addAll(users);
	}
	
}
