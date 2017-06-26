package moovies;

import java.util.ArrayList;
import java.util.Observer;

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
	
	public void suscribirse(Observer obj){
		this.addObserver(obj);
	}

}
