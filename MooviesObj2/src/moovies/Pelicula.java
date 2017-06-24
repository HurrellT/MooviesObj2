package moovies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
	private List<Genero> generos;
	
	// puntajes
	private List<Calificacion> calificaciones;
	
	
	/*
 	* 
 	* Constructor de Pelicula
 	*  
 	*/
	
	public Pelicula(String name,
					LocalDate year,
					String imdbScore, 
					List<Genero> genres) {
		this.nombre 		= name;
		this.anioDeEstreno 	= year;
		this.idmb 			= imdbScore;
		this.generos 		= genres;
		this.calificaciones	= new ArrayList<>();
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
	
	public List<Genero> getGeneros() {
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

	public boolean esRecomendacionPara(Usuario user, int puntaje, int condicionMinimaDeAmigos) {
		
		Stream<Usuario> amigosQueEvaluaron = user.getAmigos().stream();
		
		amigosQueEvaluaron.filter(a -> a.evaluoLaPelicula(this) && a.buscarCalificacion(this).getPuntaje() >= puntaje);
		
		return amigosQueEvaluaron.count() > condicionMinimaDeAmigos;
	}
	
}
