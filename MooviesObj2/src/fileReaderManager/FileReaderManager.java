package fileReaderManager;

import java.util.ArrayList;
import java.util.List;

import CSVFileReaders.PeliculaFileReader;
import CSVFileReaders.RatingsFileReader;
import CSVFileReaders.UsuarioFileReader;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;
import CSVFileReaders.AmigosFileReader;

public class FileReaderManager {

	/*
	 *	Colaboradores Internos 
	 */
	
	private List<UsuarioData> userData;
	
	private List<PeliculaData> movieData;
	
	private List<RatingData> ratingData;
	
	private List<AmigosData> friendsData;
	
	private Moovies moovies;

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
	
	public List<Pelicula> getPeliculas() {
		List<Pelicula> nuevasPeliculas = new ArrayList<Pelicula>();
		int index = 0;
		for(int i = 0; i < movieData.size(); i++){
			nuevasPeliculas.add(movieData.get(index).getMovie());
			index++;
		}
		return nuevasPeliculas;
	}
	
	public List<Usuario> getUsuarios() {
		List<Usuario> nuevosUsuarios = new ArrayList<Usuario>();
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
		UsuarioFileReader usuarioReader = new UsuarioFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.userData = usuarioReader.readFile();
	}
	
	public void procesarPelicula(String filePath) {
		PeliculaFileReader peliculaReader = new PeliculaFileReader(filePath, moovies);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.movieData = peliculaReader.readFile();
	}
	
	public void procesarRatings(String filePath) {
		RatingsFileReader ratingReader = new RatingsFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.ratingData = ratingReader.readFile();
	}
	
	public void procesarAmigos(String filePath) {
		AmigosFileReader amigosReader = new AmigosFileReader(filePath);
		
		//Guarda en su variable de instancia el
		//reultado de procesar el archivo.
		this.friendsData = amigosReader.readFile();
	}
	
	/*
	 * Otros metodos
	 */
	
	//Precondicion: Ya se cargaron los datos.
	public void registrarRatings() {
		for (int i = 0; i < ratingData.size(); i++) {			
			//Guardar info
			int userId 	= ratingData.get(i).getUserId();
			int movieId = ratingData.get(i).getMovieId();
			int score 	= ratingData.get(i).getRating();
			//Buscar usuario
			UsuarioData user = findUsuarioData(userId);
			//Buscar pelicula
			PeliculaData movie = this.findPeliculaData(movieId);
			//Registrar la calificacion del usuario
			user.getUser().calificarPelicula(score, movie.getMovie());
		}
		
	}
	
	//Precondicion: La pelicula debe estar
	public PeliculaData findPeliculaData(int id){
		PeliculaData movie = movieData.get(0);
		for (int i = 0; i < movieData.size(); i++) {
			if (movieData.get(i).getId() == id) {
				movie = movieData.get(i);
			}
		}
		return movie;
	}

	//Precondicion: Ya se cargaron los datos.
	public void registrarAmigos() {
		for (int i = 0; i < friendsData.size(); i++) {			
			//Guardar info
			int user1Id = friendsData.get(i).getAmigoId1();
			int user2Id = friendsData.get(i).getAmigoId2();
			//Buscar primer usuario
			UsuarioData user1 = this.findUsuarioData(user1Id);
			//Buscar segundo usuario
			UsuarioData user2 = this.findUsuarioData(user2Id);
			//Hacer amigos a los usuarios
			user1.getUser().agregarAmigo(user2.getUser());
		}

	}
	
	public UsuarioData findUsuarioData(int id){
		UsuarioData user = userData.get(0);
		for (int i = 0; i < userData.size(); i++) {
			if (userData.get(i).getId() == id) {
				user = userData.get(i);
			}
		}
		
		return user;
	}
	
	public void integrarEnMoovies() {
		List<Pelicula> pelis = this.getPeliculas();
		List<Usuario> users = this.getUsuarios();
		for(int i=0; i < pelis.size(); i++){
			this.moovies.addPelicula(pelis.get(i));
		}
		for(int i=0; i < users.size(); i++){
			this.moovies.addUsuario(users.get(i));
		}
		//mov.getPeliculas().addAll(pelis);
		//mov.getUsuarios().addAll(users);
	}

	public void addMoovies(Moovies moovies) {
		this.moovies = moovies;		
	}
	
}
