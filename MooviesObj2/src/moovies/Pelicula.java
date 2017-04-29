package moovies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/*
 * Clase que define una Pelicula.
 * La misma tiene nombre, anio de estreno, un id, sus generos,
 * y los puntajes que usuarios le dan. 
 * @author TLH
 */

public class Pelicula {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Pelicula
 	*  
 	*/
	
	//id de la pelicula
	private Integer id;
	
	// nombre de la pelicula
	private String nombre;
	
	// anio de estreno
	private Integer anioDeEstreno;
	
	// IDMb
	private Integer idmb;
	
	// generos
	private ArrayList<String> generos;
	
	// puntajes
	private Map<Integer,Integer> puntajes;
	
	
	/*
 	* 
 	* Constructor de Pelicula
 	*  
 	*/
	
	public Pelicula(Integer id,
			String name,
			Integer year,
			Integer idmbNum, 
			ArrayList<String> genres
			//Map<Integer, Integer> score
			) {
		this.id = id;
		this.nombre = name;
		this.anioDeEstreno = year;
		this.idmb = idmbNum;
		this.generos = genres;
		//this.puntajes = score;
	}
	
	/*
 	* 
 	* Getters de Pelicula
 	*  
 	*/
	
	public Integer getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public Integer getAnioDeEstreno() {
		return anioDeEstreno;
	}
	
	public Integer getIdmb() {
		return idmb;
	}
	
	public ArrayList<String> getGeneros() {
		return generos;
	}
	
	public Map<Integer, Integer> getPuntajes() {
		return puntajes;
	}
	
}
