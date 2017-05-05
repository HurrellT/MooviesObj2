package moovies;

import java.time.LocalDate;
import java.util.List;
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
	private String idmb;
	
	// generos
	private List<String> generos;
	
	// puntajes
	private List<Calificacion> calificaciones;
	
	
	/*
 	* 
 	* Constructor de Pelicula
 	*  
 	*/
	
	public Pelicula(String name,
					LocalDate year,
					String string, 
					List<String> genres) {
		this.nombre = name;
		this.anioDeEstreno = year;
		this.idmb = string;
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
	
	public String getIdmb() {
		return idmb;
	}
	
	public List<String> getGeneros() {
		return generos;
	}
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	
	/*
	*
	* Otros metodos
	*
	*/
	
	public void addRating(Calificacion calif){
		calificaciones.add(calif);	
	}
	
	public int promedio(){
		int total = 0;
		int cant = calificaciones.size();
		for (int i = 0; i < cant; i++) {
		    total = total + calificaciones.get(i).getPuntaje();
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
