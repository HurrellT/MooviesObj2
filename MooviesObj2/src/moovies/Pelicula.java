package moovies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/*
* Clase que define una Pelicula.
* La misma tiene un nombre, un anio de estreno, 
* un codigo  de idmb, una lista de generos, y una
* lista de los puntajes que los usuarios le dan. 
*/

public class Pelicula {
	
	/*
 	* 
 	* Colaboradores internos (variables de instancia) de la clase Pelicula
 	*  
 	*/
	
	// nombre de la pelicula
	private String nombre;
	
	// anio de estreno
	private LocalDate anioDeEstreno;
	
	// IDMb
	private int idmb;
	
	// generos
	private ArrayList<String> generos;
	
	// puntajes
	private Map<Usuario, Integer> puntajes;
	
	
	/*
 	* 
 	* Constructor de Pelicula
 	*  
 	*/
	
	public Pelicula(String name,
					LocalDate year,
					int idmbNum, 
					ArrayList<String> genres) {
		this.nombre = name;
		this.anioDeEstreno = year;
		this.idmb = idmbNum;
		this.generos = genres;
	}
	
	/*
 	* 
 	* Getters de Pelicula
 	*  
 	*/
	
	public String getNombre(){
		return nombre;
	}
	
	public LocalDate getFechaDeEstreno() {
		return anioDeEstreno;
	}
	
	public int getIdmb() {
		return idmb;
	}
	
	public ArrayList<String> getGeneros() {
		return generos;
	}
	
	public Map<Usuario, Integer> getPuntajes() {
		return puntajes;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	public void addRating(Usuario user, int puntaje){
		Integer score = new Integer(puntaje);
		this.puntajes.put(user, score);	
	}
	
	public int promedio(){
		int total = 0;
		int cant = 0;
		for (Map.Entry<Usuario, Integer> entry : puntajes.entrySet())
		{
			//Si asumimos que no hay puntuacion 0, este if se puede ir
		    if(entry.getValue().intValue() > 0){
		    	total = total + entry.getValue().intValue();
		    	cant++;
		    };
		}
		return (total / cant); 
	}
	
	public int compareTo(Pelicula movie){
		int res = 0;
		if(this.promedio() == movie.promedio()){
			res = 0;
		}
		if(this.promedio() < movie.promedio()){
			res = -1;
		}
		if(this.promedio() > movie.promedio()){
			res = 1;
		}
		return res;
	}
	
}
