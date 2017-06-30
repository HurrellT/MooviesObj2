package moovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;

/*
* Clase que define un Usuario.
* El mismo tiene una id, un nombre y apellido, una edad,
* una ocupacion, un codigo postal, una lista de generos favoritos,
* una lista de amigos y una lista de peliculas vistas. 
*/

public class Usuario implements Observer {
	
  // Colaboradores internos (variables de instancia) de la clase Usuario
		
	// nombre y apellido
	private String nyap;
		
	// edad
	private int edad;
		
	// ocupacion
	private String ocupacion;
		
	// codigo postal
	private int codPos;
		
	//amigos del usuarios
	private List<Usuario> amigos;
		
	//lista de calificaciones dadas a las peliculas
	private List<Calificacion> calificaciones;
	
	//nuevas peliculas de generos suscriptos
	private List<Pelicula> nuevasRecomendaciones;
	
	//Un mecanismo de recomendacion
	private MecanismoDeRecomendacion recomendador;
	
	//moovies
	private Moovies moovies;
	
  
	//Constructor de Usuario
	public Usuario(String nyap, int edad, String ocupacion, int codPos) {
		this.nyap 			       = nyap;
		this.edad 			       = edad;
		this.ocupacion 		       = ocupacion;
		this.codPos 		       = codPos;
		this.amigos			       = new ArrayList<Usuario>();
		this.calificaciones	       = new ArrayList<Calificacion>();
		this.nuevasRecomendaciones = new ArrayList<Pelicula>();
		this.recomendador		   = new MecanismoDeRecomendacion_PuntajeBajo();
	}
		
  
	//Getters de la clase Usuario.
		
	//retorna el nombre y apellido
	public String getNombre() {
		return nyap;
	}
	
	//retorna la edad
	public int getEdad() {
		return edad;
	}
	
	//retorna la ocupacion
	public String getOcupacion() {
		return ocupacion;
	}
	
	//retorna el codigo postal
	public int getCodPos() {
		return codPos;
	}
	
	//retorna la lista de amigos
	public List<Usuario> getAmigos() {
		return amigos;
	}

	//retorna la lista de calificaciones
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	
	//retorna la lista de nuevas recomendaciones
	public List<Pelicula> nuevasRecomendaciones(){
		return nuevasRecomendaciones;
	}
	
  
	// Otros metodos
		
	//agrega la id de un usuario a la lista de amigos
	public void agregarAmigo(Usuario user){
		this.amigos.add(user);
		user.agregarmeComoAmigo(this);
	}
	
	private void agregarmeComoAmigo(Usuario user){
		this.amigos.add(user);
	}

	//elimina la id de un usuario de la lista de amigos
	public void eliminarAmigo(Usuario user){
		this.amigos.remove(user);
		user.eliminarmeComoAmigo(this);
	}
	
	private void eliminarmeComoAmigo(Usuario user){
		this.amigos.remove(user);
	}
			
	public void calificarPelicula(int puntaje, Pelicula pelicula){
		Calificacion calif = new Calificacion(this, pelicula, puntaje);
		calificaciones.add(calif);
		pelicula.addRating(calif);
	}
	
	public int pelisClasificadas(){
		return calificaciones.size(); 
	}
	
	public int compareTo(Usuario user){
		int res = 0;
		if(this.pelisClasificadas() == user.pelisClasificadas()){
			res = 0;
		}
		if(this.pelisClasificadas() < user.pelisClasificadas()){
			res = -1;
		}
		if(this.pelisClasificadas() > user.pelisClasificadas()){
			res = 1;
		}
		return res; 
	}

	@Override
	public void update(Observable genero, Object pelicula) {
		this.nuevasRecomendaciones.add((Pelicula) pelicula);
	} 
  
	public boolean evaluoLaPelicula(Pelicula pelicula) {
		Stream<Calificacion> cal = calificaciones.stream();
		return cal	.anyMatch(c -> c.getPeli().equals(pelicula));
	}

	public Calificacion buscarCalificacion(Pelicula pelicula) {
		Stream<Calificacion> cal = calificaciones.stream();
		return cal	.filter(c -> c.getPeli().equals(pelicula))
					.findFirst()
					.get();
	}
	
	public List<Pelicula> recomendar() {
		return this.recomendador.recomendarPeliculaPara(this, moovies);
	}


	public void setMoovies(Moovies moovies) {
		this.moovies = moovies;		
	}
	
	public void cambiarRecomendador(MecanismoDeRecomendacion recomendador) {
		this.recomendador = recomendador;
	}
	
	

}
