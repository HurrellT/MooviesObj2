package moovies;

import java.util.Observer;

public class Genero_Especifico extends Genero {
	
	/*
 	* 
 	* Constructor de Genero_Especifico
 	*  
 	*/
	
	public Genero_Especifico(String nombre){
		this.nombre = nombre;
		this.supergenero = this;
	}
	
	public void suscribirse(Observer obj){
		this.addObserver(obj);
	}
	
	public void desuscribirse(Observer obj){
		this.deleteObserver(obj);
	}

}
