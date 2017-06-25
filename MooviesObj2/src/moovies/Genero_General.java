package moovies;

import java.util.ArrayList;
import java.util.List;

public class Genero_General extends Genero {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Genero_General
 	*  
 	*/
	
	//Lista de los subgeneros posibles
	private List<Genero> subgeneros;
	
	/*
 	* 
 	* Constructor de Genero_General
 	*  
 	*/
	
	public Genero_General(String nombre){
		this.nombre = nombre;
		this.peliculas = new ArrayList<Pelicula>();
		this.subgeneros = new ArrayList<Genero>();
	}

	
	/*
 	* 
 	* Getters de Genero_General
 	*  
 	*/
	
	public List<Genero> getSubgeneros(){
		return this.subgeneros;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	public void agregarSubgenero(Genero genero){
		subgeneros.add(genero);
		//Y el supergenero?
	}
	
	public void quitarSubgenero(Genero genero){
		subgeneros.remove(genero);
		//Y el supergenero?
	}
		
	
	

}
