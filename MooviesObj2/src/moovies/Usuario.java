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

		public void calificarPelicula(Integer puntaje,int pelicula){

		}

		
		public void agregarAmigo(Integer idAmigo){
		
		}


		public void eliminarAmigo(Integer idAmigo){

		}

}
