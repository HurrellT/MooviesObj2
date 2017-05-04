package adapter;

import moovies.Pelicula;

public class PeliculaData {

	private int id;
	
	private Pelicula pelicula;
	
	public PeliculaData(int id, Pelicula pelicula) {
		
		this.id = id;
		this.pelicula = pelicula;
	}
	
	public int getId(){
		
		return id;
	}
	public Pelicula getMovie(){
		
		return pelicula;
	}

}
