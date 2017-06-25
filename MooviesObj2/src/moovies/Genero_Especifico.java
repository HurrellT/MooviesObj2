package moovies;

import java.util.ArrayList;

public class Genero_Especifico extends Genero {
	
	/*
 	* 
 	* Constructor de Genero_Especifico
 	*  
 	*/
	
	public Genero_Especifico(String nombre){
		this.nombre = nombre;
		this.peliculas = new ArrayList<Pelicula>();
	}

}
