package moovies;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Genero extends Observable {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Genero
 	*  
 	*/
	
	//Nombre del genero
	protected String nombre;
	
	//Genero al que pertenece este genero
	protected Genero supergenero;
	
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
	
	public void addSupergenero(Genero genero){
		this.supergenero = genero;
	}
	
	public void removeSupergenero(){
		this.supergenero = this;
	}
	
	public void agregarPelicula(Pelicula pelicula){
		peliculas.add(pelicula);
		this.setChanged();
		this.notifyObservers(pelicula);
	}
	
	public void quitarPelicula(Pelicula pelicula){
		peliculas.remove(pelicula);
	}
	
	public abstract void suscribirse(Observer obj);
	
	public abstract void desuscribirse(Observer obj);
	
	public String generoCompleto(){
		String name = this.nombre;
		if(this.supergenero.nombre != this.nombre){
			name = name + " - " + supergenero.generoCompleto();
		}
		return name;
	}
	


}
