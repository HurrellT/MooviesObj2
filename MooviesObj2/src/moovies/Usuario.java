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
		private ArrayList<Interger> amigos;
		
		//peliculas vistas con el puntaje dado por el usuario actual
		//Si no fue puntuado, el valor es 0 (El puntaje valido va de 1 a 5)
		private Map<Interger,Interger> pelisVistas;
		
		//id
		private int id;


		
		public ArrayList<Interger> getAmigos() {
			return amigos;
		}

		public Map<Interger, Interger> getPelis() {
			return Pelis;
		}

		public void calificarPelicula(Interger,int){

		}

		
		public void agregarAmigo(Interger){
		
		}


		public void eliminarAmigo(Interger){

		}

}
