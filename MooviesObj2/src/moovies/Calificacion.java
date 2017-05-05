package moovies;

public class Calificacion {

	/*							@author TLH
	 * Colaboradores internos
	 */
	
	private Usuario usuario;
	
	private Pelicula peli;
	
	private int puntaje;
	
	/*
	 * Constructor
	 */
	
	public Calificacion(Usuario user, Pelicula movie, int score) {
		
		this.usuario = user;
		this.peli = movie;
		this.puntaje = score;
		
	}
	
	/*
	 * Getters
	 */
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Pelicula getPeli() {
		return peli;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
}
