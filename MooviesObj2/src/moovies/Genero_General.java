package moovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

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
		this.subgeneros = new ArrayList<Genero>();
		this.supergenero = this;
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
		this.subgeneros.add(genero);
		genero.addSupergenero(this);
	}
	
	public void quitarSubgenero(Genero genero){
		this.subgeneros.remove(genero);
		genero.removeSupergenero();
	}
		
	public void suscribirse(Observer obj){
		this.addObserver(obj);
		for(Genero genero : subgeneros){
			genero.suscribirse(obj);
		}
	}
	
	public void desuscribirse(Observer obj){
		this.deleteObserver(obj);
		for(Genero genero : subgeneros){
			genero.desuscribirse(obj);
		}
	}	

}
