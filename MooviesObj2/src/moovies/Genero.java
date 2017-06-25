package moovies;

import java.util.List;
import java.util.Observable;

public abstract class Genero extends Observable {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Genero
 	*  
 	*/
	
	//Nombre del genero
	protected String nombre;
	
	//Genero al que pertenece este genero
	//private Genero supergenero;
	
	//Peliculas que pertenecen a este genero
	protected List<Pelicula> peliculas;
	
	/*
 	* 
 	* Getters de Genero
 	*  
 	*/
	
	public String getNombre(){
		return this.nombre;
	}
	
	//public String getNombreCompleto(){
	//	String name = this.getNombre();
	//	if(! (supergenero.getNombre() == this.nombre)){
	//		name = name + supergenero.getNombreCompleto();
	//	}
	//	return name;
	//}
	
	//public Genero getSupergenero(){
	//	return this.supergenero;
	//}
	
	public List<Pelicula> getPeliculas(){
		return this.peliculas;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	//public void addSupergenero(Genero genero){
	//	supergenero = genero;
	//}
	
	public void agregarPelicula(Pelicula pelicula){
		peliculas.add(pelicula);
	}
	
	public void quitarPelicula(Pelicula pelicula){
		peliculas.remove(pelicula);
	}

}
