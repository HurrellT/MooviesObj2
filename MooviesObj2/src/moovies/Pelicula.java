package moovies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/*
 * Clase que define una Pelicula.
 * 		La misma tiene nombre, anio de estreno, un id, sus generos,
 * 		y los puntajes que usuarios le dan. 
 * @author TLH
 */

public class Pelicula {
	
	// nombre de la pelicula
	private String nombre;
	
	// anio de estreno
	private Integer anioDeEstreno;
	
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
			ArrayList<String> genres
			//Map<Integer, Integer> score
			) {
		
		this.nombre = name;
		this.anioDeEstreno = year;
		this.id = idNum;
		this.generos = genres;
		//this.puntajes = score;
	}
	
	//Getters
	
	public String getNombre(){
		return nombre;
	}
	
	public Integer getAnioDeEstreno() {
		return anioDeEstreno;
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
