package moovies;

import java.util.ArrayList;
import java.util.Map;

	public class Usuario {
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
		//Si no fue puntuado, el valor es 0 (El puntaje valido va de 1 a 5)
		private Map<Integer,Integer> pelisVistas;
		
		//id
		private int id;


		
		public ArrayList<Integer> getAmigos() {
			return amigos;
		}

		public Map<Integer, Integer> getPelis() {
			return pelisVistas;
		}

		//agrega el par (id de la pelicula, puntaje) a la lista de pelisVistas del usuario
		//agrega el par (id del usuario, puntaje) a la lista de puntajes de la pelicula
		public void calificarPelicula(Integer puntaje, Pelicula pelicula){
			Integer i = pelicula.getId(); //hay que hacer esto porque pelisVistas requiere un Integer
			this.pelisVistas.put(i, puntaje);
			pelicula.addRating(puntaje, this.id); //double dispatching			
		}

		//agrega la id de un usuario a la lista de amigos
		public void agregarAmigo(Integer idAmigo){
			this.amigos.add(idAmigo);
		}

		//elimina la id de un usuario de la lista de amigos
		//la id del usuario debe estar incluida en la lista de amigos
		public void eliminarAmigo(Integer idAmigo){
			this.amigos.remove(idAmigo);
		}

}
