package mooviesTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import moovies.Genero;
import moovies.Genero_Especifico;
import moovies.Genero_General;
import moovies.Pelicula;

public class GeneroTest {

	Genero_Especifico genero1, genero2;
	Genero_General genero3;
	
	Pelicula peli1, peli2, peli3;
	
	@Before
	public void setUp() {
		genero1 = new Genero_Especifico("Vampiros");
		genero2 = new Genero_Especifico("Fantasmas");
		genero3 = new Genero_General("Terror");
		
		peli1 = mock(Pelicula.class);
		peli2 = mock(Pelicula.class);
		peli3 = mock(Pelicula.class);
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
		assert(genero1.getPeliculas().contains(peli1));
		assert(genero1.getPeliculas().contains(peli2));
		assert(!genero1.getPeliculas().contains(peli3));
		
		genero1.quitarPelicula(peli2);
		assertEquals(1, genero1.getPeliculas().size());
		assert(!genero1.getPeliculas().contains(peli2));
	}
	
	@Test
	public void test003UnGenero_GeneralPuedeTenerVariosSubgeneros() {
		genero3.agregarSubgenero(genero1);
		genero3.agregarSubgenero(genero2);
		assertEquals(2, genero3.getSubgeneros().size());
		assert(genero3.getSubgeneros().contains(genero1));
		assert(genero3.getSubgeneros().contains(genero2));
		
		genero3.quitarSubgenero(genero2);
		assertEquals(1, genero3.getSubgeneros().size());
		assert(!genero3.getSubgeneros().contains(genero2));
	}
	
	

}
