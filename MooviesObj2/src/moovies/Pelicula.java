package moovies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/*
* Clase que define una Pelicula.
* La misma tiene una id, un nombre, un anio de estreno, 
* un codigo  de idmb, una lista de generos, y una
* lista de los puntajes que los usuarios le dan. 
* @author TLH
*/

public class Pelicula {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Pelicula
 	*  
 	*/
	
	//id de la pelicula
	//¿esta variable de instancia es necesaria?
	//lo mismo con la id del usuario
	private int id;
	
	// nombre de la pelicula
	private String nombre;
	
	// anio de estreno
	private int anioDeEstreno;
	
	// IDMb
	private int idmb;
	
	// generos
	private ArrayList<String> generos;
	
	// puntajes
	private Map<Integer,Integer> puntajes;
	
	
	/*
 	* 
 	* Constructor de Pelicula
 	*  
 	*/
	
	public Pelicula(int id,
			String name,
			int year,
			int idmbNum, 
			ArrayList<String> genres) {
		//Map<Integer, Integer> score
		//la pelicula no deberia recibir los puntajes al ser creada
		//estos los agregan los usuarios a medida que califican la pelicula
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
	
	public int getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getAnioDeEstreno() {
		return anioDeEstreno;
	}
	
	public int getIdmb() {
		return idmb;
	}
	
	public ArrayList<String> getGeneros() {
		return generos;
	}
	
	public Map<Integer, Integer> getPuntajes() {
		return puntajes;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	public void addRating(int puntaje, int id){
		Integer rating = new Integer(puntaje);
		Integer idUsuario = new Integer(id); 
		//hay que hacer esto porque puntajes requiere dos Integer
		this.puntajes.put(idUsuario, rating);	
	}
	
}
