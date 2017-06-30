package moovies;

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
		this.setChanged();
		this.notifyObservers(pelicula);
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
