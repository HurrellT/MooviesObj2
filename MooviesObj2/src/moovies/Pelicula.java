package moovies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/*
 * Clase que define una Pelicula.
 * 		La misma tiene nombre, año de estreno, un id, sus generos,
 * 		y los puntajes que usuarios le dan. 
 * @author TLH
 */

public class Pelicula {
	
	// nombre de la pelicula
	private String nombre;
	
	// año de estreno
	private Integer añoDeEstreno;
	
	// ID
	private Integer id;
	
	// generos
	private ArrayList<String> generos;
	
	// puntajes
	private Map<Integer,Integer> puntajes;
	
	
	// Constructor de Pelicula
	public Pelicula(String name,
			Integer year,
			Integer idNum, 
			ArrayList<String> genres,
			Map<Integer, Integer> score) {
		
		name 	= nombre;
		year 	= añoDeEstreno;
		idNum 	= id;
		genres	= generos;
		score	= puntajes;
	}
	
	//Getters
	
	public String getNombre(){
		return nombre;
	}
	
	public Integer getAñoDeEstreno() {
		return añoDeEstreno;
	}
	
	public Integer getId() {
		return id;
	}
	
	public ArrayList<String> getGeneros() {
		return generos;
	}
	
	public Map<Integer, Integer> getPuntajes() {
		return puntajes;
	}
	
}
