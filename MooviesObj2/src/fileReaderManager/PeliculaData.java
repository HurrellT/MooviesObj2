package fileReaderManager;

import moovies.Pelicula;

public class PeliculaData {

	/*
	 * Colaboradores internos
	 */
	
	private int id;
	
	private Pelicula pelicula;
	
	/*
	 * Constructor de PeliculaData
	 */
	
	public PeliculaData(int id, Pelicula pelicula) {
		
		this.id = id;
		this.pelicula = pelicula;
	}
	
	/*
	 * Getters
	 */
	
	public int getId(){
		
		return id;
	}
	public Pelicula getMovie(){
		
		return pelicula;
	}

}
