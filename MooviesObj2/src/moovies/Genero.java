package moovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Genero extends Observable{
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Genero
 	*  
 	*/
	
	//Nombre del genero
	private String nombre;
	
	//Lista de los subgeneros posibles
	private List<Genero> subgeneros;
	
	//Genero al que pertenece este genero
	private Genero supergenero;
	
	//Peliculas que pertenecen a este genero
	private List<Pelicula> peliculas;
	
	/*
 	* 
 	* Constructor de Genero
 	*  
 	*/
	
	public Genero(String nombre){
		this.nombre = nombre;
		subgeneros = new ArrayList<Genero>();
		this.supergenero = this;
		peliculas = new ArrayList<Pelicula>();
	}
	
	/*
 	* 
 	* Getters de Genero
 	*  
 	*/
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getNombreCompleto(){
		String name = this.getNombre();
		if(! (supergenero.getNombre() == this.nombre)){
			name = name + supergenero.getNombreCompleto();
		}
		return name;
	}
	
	public List<Genero> getSubgeneros(){
		return this.subgeneros;
	}
	
	public Genero getSupergenero(){
		return this.supergenero;
	}
	
	public List<Pelicula> getPeliculas(){
		return this.peliculas;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	public void addSubgenero(Genero genero){
		subgeneros.add(genero);
		genero.addSupergenero(this);
	}
	
	public void addSupergenero(Genero genero){
		supergenero = genero;
	}
	
	public void addPelicula(Pelicula pelicula){
		peliculas.add(pelicula);
	}

}
