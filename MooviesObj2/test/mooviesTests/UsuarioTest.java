package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moovies.Calificacion;
import moovies.Genero;
import moovies.Genero_Especifico;
import moovies.Pelicula;
import moovies.Usuario;

import static org.mockito.Mockito.*;

public class UsuarioTest {

	Usuario user, luca, esteban;
	
	Pelicula peli, peli2;
	
	Calificacion cal, cal2;
	
	Genero gen1;
		
	@Before
	public void setUp() {
		user 	= mock(Usuario.class);
		luca	= new Usuario("Luca Hazuca", 18, "Programador", 1878);
		esteban	= new Usuario("Esteban Bedecarats", 21, "Programador", 1878);

		luca.agregarAmigo(esteban);
		
		peli	= mock(Pelicula.class);
		peli2	= mock(Pelicula.class);
		
		cal		= mock(Calificacion.class);
		cal2		= mock(Calificacion.class);
		
		gen1 = new Genero_Especifico("Vampiros");
	}
	
	@Test
	public void test01UnUsuarioLlamadoLucaHazucaTiene18AñosEsProgramadorYTieneElCodigoPostal1878() {
		String 	name	= "Luca Hazuca";
		int		edad	= 18;
		String	ocup	= "Programador";
		int		codPos	= 1878;
		
		//Mock
		//No sirve para cubrir los constructores.
		when(user.getNombre()).thenReturn(name);
		assertEquals(name, user.getNombre());
		
		//Normal
		assertEquals(name, luca.getNombre());
		assertEquals(edad, luca.getEdad());
		assertEquals(ocup, luca.getOcupacion());
		assertEquals(codPos, luca.getCodPos());
	}
	
	@Test
	public void test02LucaTieneUnSoloAmigoYSeLlamaEstebanBedecarats() {
		String amigo	= "Esteban Bedecarats";
		
		assertEquals(1, luca.getAmigos().size());
		assertEquals(amigo, luca.getAmigos().get(0).getNombre());
	}
	
	@Test
	public void test03LucaTiene2CalificacionesHechasAPeliculas() {
		luca.calificarPelicula(4, peli);
		luca.calificarPelicula(2, peli2);
		
		when(cal.getPuntaje()).thenReturn(4);
		when(cal2.getPuntaje()).thenReturn(2);
		
		assertEquals(2, luca.getCalificaciones().size());
		assertEquals(4, luca.getCalificaciones().get(0).getPuntaje());
		assertEquals(2, luca.getCalificaciones().get(1).getPuntaje());
		
		assertEquals(2, luca.pelisClasificadas());
	}
	
	@Test
	public void test04LucaEliminaASuUnicoAmigoYPasaATener0Amigos() {
		luca.eliminarAmigo(esteban);
		
		assertEquals(0, luca.getAmigos().size());
	}
	
	@Test
	public void test05LucaTieneUnaListaDeNuevasPeliculasDeLosGenerosALOsQueSeSuscribio() {
		gen1.suscribirse(luca);
		gen1.agregarPelicula(peli);
		
		assert(luca.nuevasRecomendaciones().contains(peli));
		
	}
	
	//CompareTo debe cubrirse dentro de los Test de Moovies, al probar Mejores Peliculas

}
