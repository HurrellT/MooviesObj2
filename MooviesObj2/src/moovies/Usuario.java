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
	private Map<Pelicula,Integer> pelisVistas;
	
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
	}
		
	/*
	*
	* Getters de la clase Usuario. ¿No son necesarios los demas getters?
	*
	*/
	
	//retorna la id del usuario
		public int getId(){
			return id;
	}
		
	//retorna la lista de amigos
	public ArrayList<Integer> getAmigos() {
		return amigos;
	}

	//retorna la lista de pares (id de pelicula, puntaje)
	public Map<Pelicula, Integer> getPelis() {
		return pelisVistas;
	}

	/*
	*
	* Otros metodos
	*
	*/
		
	//agrega la id de un usuario a la lista de amigos
	public void agregarAmigo(int id){
		Integer idAmigo = new Integer(id);
		this.amigos.add(idAmigo);
		//hay que hacer double dispatching
	}

	//elimina la id de un usuario de la lista de amigos
	public void eliminarAmigo(int id){
		Integer idAmigo = new Integer(id);
		this.amigos.remove(idAmigo);
		//hay que hacer double dispatching
	}
			
	public void calificarPelicula(int puntaje, Pelicula pelicula){
		this.pelisVistas.put(pelicula, puntaje);
		pelicula.addRating(this, puntaje); //double dispatching			
	}
	
	public int pelisClasificadas(){
		int total = 0;
		for (Map.Entry<Pelicula, Integer> entry : pelisVistas.entrySet())
		{
		    if(entry.getValue().intValue() > 0){
		    	total++;
		    };
		}
		return total; 
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

}
