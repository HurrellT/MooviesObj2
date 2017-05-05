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
		

	// nombre y apellido
	private String nyap;
		
	// edad
	private int edad;
		
	// ocupacion
	private String ocupacion;
		
	// codigo postal
	private int codPos;
		
	// genero favorito
	//private String generoFavorito;
		
	//amigos del usuarios
	private ArrayList<Usuario> amigos;
		
	//peliculas vistas con el puntaje dado por el usuario actual
	//si no fue puntuado, el valor es 0 (el puntaje valido va de 1 a 5)
	private Map<Pelicula,Integer> pelisVistas;
	
	/*
 	* 
 	* Constructor de Usuario
 	*  
 	*/
	
	public Usuario(String nyap,
		       int edad,
		       String ocupacion, 
		       int codPos) {
		this.nyap = nyap;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.codPos = codPos;
	}
		
	/*
	*
	* Getters de la clase Usuario. 
	*
	*/
		
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
	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	//retorna la lista de pares (Pelicula, puntaje)
	public Map<Pelicula, Integer> getPelis() {
		return pelisVistas;
	}

	/*
	*
	* Otros metodos
	*
	*/
		
	//agrega la id de un usuario a la lista de amigos
	public void agregarAmigo(Usuario user){
		this.amigos.add(user);
		user.addAmigo(this);
	}
	
	public void addAmigo(Usuario user){
		this.amigos.add(user);
	}

	//elimina la id de un usuario de la lista de amigos
	public void eliminarAmigo(Usuario user){
		this.amigos.remove(user);
		user.removeAmigo(this);
	}
	
	public void removeAmigo(Usuario user){
		this.amigos.remove(user);
	}
			
	public void calificarPelicula(int puntaje, Pelicula pelicula){
		this.pelisVistas.put(pelicula, puntaje);
		pelicula.addRating(this, puntaje); //double dispatching			
	}
	
	public int pelisClasificadas(){
		int total = 0;
		for (Map.Entry<Pelicula, Integer> entry : pelisVistas.entrySet())
		{
			//Si asumimos que no hay voto 0, este if no iria
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
