package mooviesTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import moovies.Genero_Especifico;
import moovies.Genero_General;
import moovies.Pelicula;
import moovies.Usuario;

public class GeneroTest {

	Genero_Especifico genero1, genero2;
	Genero_General genero3, genero4;
	
	Pelicula peli1, peli2, peli3;
	
	Usuario user1, user2, user3;
	
	@Before
	public void setUp() {
		genero1 = new Genero_Especifico("Vampiros");
		genero2 = new Genero_Especifico("Fantasmas");
		genero3 = new Genero_General("Terror");
		genero4 = new Genero_General("Mounstruos");
		
		peli1 = mock(Pelicula.class);
		peli2 = mock(Pelicula.class);
		peli3 = mock(Pelicula.class);
		
		user1 = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
	}
	
	@Test
	public void test001UnGeneroTieneUnNombre() {
		String nombre1 = "Vampiros";
		String nombre2 = "Fantasmas";
		String nombre3 = "Terror";
		assertEquals(nombre1, genero1.getNombre());
		assertEquals(nombre2, genero2.getNombre());
		assertEquals(nombre3, genero3.getNombre());
		
	}
	
	@Test
	public void test002VariasPeliculasPuedenPertenecerAUnGenero() {
		genero1.agregarPelicula(peli1);
		genero1.agregarPelicula(peli2);
		assertEquals(2, genero1.getPeliculas().size());
		assertTrue(genero1.getPeliculas().contains(peli1));
		assertTrue(genero1.getPeliculas().contains(peli2));
		assertFalse(genero1.getPeliculas().contains(peli3));
		
		genero1.quitarPelicula(peli2);
		assertEquals(1, genero1.getPeliculas().size());
		assertFalse(genero1.getPeliculas().contains(peli2));
	}
	
	@Test
	public void test003UnGenero_GeneralPuedeTenerVariosSubgeneros() {
		genero3.agregarSubgenero(genero1);
		genero3.agregarSubgenero(genero2);
		assertEquals(2, genero3.getSubgeneros().size());
		assertTrue(genero3.getSubgeneros().contains(genero1));
		assertTrue(genero3.getSubgeneros().contains(genero2));
		
		genero3.quitarSubgenero(genero2);
		assertEquals(1, genero3.getSubgeneros().size());
		assertFalse(genero3.getSubgeneros().contains(genero2));
	}
	
	@Test
	public void test004UnGeneroEspecificoPuedeTenerVariosUsuariosSuscriptos() {
		genero1.suscribirse(user1);
		genero1.suscribirse(user2);
		genero1.suscribirse(user3);
		assertEquals(3, genero1.countObservers());
		
		genero1.desuscribirse(user3); 
		assertEquals(2, genero1.countObservers());
	}
	
	@Test
	public void test005UnUsuarioSuscriptoAUnGeneroRecibeLasNuevasPeliculasAgregadas() {
		genero1.agregarPelicula(peli1);
		genero1.suscribirse(user1);
		
		genero1.agregarPelicula(peli2);
		verify(user1).update(genero1, peli2);  
		
		genero1.agregarPelicula(peli3);
		verify(user1).update(genero1, peli3); 
	}
	
	@Test
	public void test006UnUsuarioSuscriptoAUnGenero_GeneralTambienEstaSuscriptoASusSubgeneros() {
		genero3.agregarSubgenero(genero1);
		genero3.agregarSubgenero(genero2);
		genero3.suscribirse(user1);
		
		assertEquals(1, genero3.countObservers());
		assertEquals(1, genero1.countObservers());
		assertEquals(1, genero2.countObservers());
	}
	
	@Test
	public void test007UnSubgeneroPuedeTenerUnSupergeneroMasGeneral() {
		genero3.agregarSubgenero(genero1);
		genero3.agregarSubgenero(genero2);
		
		assertEquals(genero3, genero1.getSupergenero());
		assertEquals(genero3, genero2.getSupergenero());
	}
	
	@Test
	public void test008APartirDeUnGeneroPuedeRecuperarseLaInformacionDeTodosSusSupergeneros() {
		genero3.agregarSubgenero(genero4);
		genero4.agregarSubgenero(genero1);
		genero4.agregarSubgenero(genero2);
		
		String generoCompletoA = "Vampiros - Mounstruos - Terror";  //Hay problema con que devuelva un String?
		String generoCompletoB = "Fantasmas - Mounstruos - Terror";  //Hay problema con que devuelva un String?
		
		assertEquals(generoCompletoA, genero1.generoCompleto());
		assertEquals(generoCompletoB, genero2.generoCompleto());
	}
	
	@Test
	public void test009UnGeneroGeneralPuedeTenerVariosUsuariosSuscriptos() {
		genero3.suscribirse(user1);
		genero3.suscribirse(user2);
		genero3.suscribirse(user3);
		genero3.agregarSubgenero(genero1);
		assertEquals(3, genero3.countObservers());
		
		genero3.desuscribirse(user3); 
		assertEquals(2, genero3.countObservers());
	}

}
