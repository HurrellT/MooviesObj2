package moovies;

import java.util.ArrayList;
import java.util.Map;

/*
* Clase que define un Usuario.
* El mismo tiene una id, un nombre y apellido, una edad,
* una ocupacion, un codigo postal, una lista de generos favoritos,
* una lista de amigos y una lista de peliculas vistas. 
*/

public class Usuario {
	/*
	*
	* Colaboradores internos (variables de instancia) de la clase Usuario
	*
	*/
		
	//id del usuario
	//¿esta variable de instancia es necesaria?
	//porque el UsuarioFileReader tira la id y no la mira
	private int id;
		
	// nombre y apellido
	private String nyap;
		
	// edad
	private int edad;
		
	// ocupacion
	private String ocupacion;
		
	// codigo postal
	private int codPos;
		
	// genero favorito
	private String generoFavorito;
		
	//amigos del usuarios
	private ArrayList<Integer> amigos;
		
	//peliculas vistas con el puntaje dado por el usuario actual
	//si no fue puntuado, el valor es 0 (el puntaje valido va de 1 a 5)
	private Map<Integer,Integer> pelisVistas;
	
	/*
 	* 
 	* Constructor de Usuario
 	*  
 	*/
	
	public Usuario(int id,
				   String nyap,
				   int edad,
				   String ocupacion, 
				   int codPos) {
		this.id = id;
		this.nyap = nyap;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.codPos = codPos;
		//this.puntajes = score;
	}
		
	/*
	*
	* Getters de la clase Usuario. Â¿No son necesarios los demas getters?
	*
	*/
		
	//retorna la lista de amigos
	public ArrayList<Integer> getAmigos() {
		return amigos;
	}

	//retorna la lista de pares (id de pelicula, puntaje)
	public Map<Integer, Integer> getPelis() {
		return pelisVistas;
	}

	/*
	*
	* Otros metodos
	*
	*/
		
	//agrega la id de un usuario a la lista de amigos
	public void agregarAmigo(Integer idAmigo){
		this.amigos.add(idAmigo);
	}

	//elimina la id de un usuario de la lista de amigos
	//la id del usuario debe estar incluida en la lista de amigos
	public void eliminarAmigo(Integer idAmigo){
		this.amigos.remove(idAmigo);
	}
		
	//agrega el par (id de la pelicula, puntaje) a la lista de pelisVistas del usuario
	//agrega el par (id del usuario, puntaje) a la lista de puntajes de la pelicula
	public void calificarPelicula(Integer puntaje, Pelicula pelicula){
		Integer i = pelicula.getId(); //hay que hacer esto porque pelisVistas requiere un Integer
		this.pelisVistas.put(i, puntaje);
		pelicula.addRating(puntaje, this.id); //double dispatching			
	}

}
