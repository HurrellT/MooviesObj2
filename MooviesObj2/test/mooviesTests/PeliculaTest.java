package mooviesTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import moovies.Pelicula;
//import java.lang.reflect.Array;

public class PeliculaTest {

	Pelicula peli1;
	ArrayList<String> generos;
	
	@Before
	public void setUp() throws Exception {
		generos = new ArrayList<String>();
		generos.add("Drama");
		generos.add("Suspenso");
		peli1 = new Pelicula("El dia despues de maniana", 2010, 15276, generos);
	}
	
	@Test
	public void test001UnaPeliculaRecienCreadaTieneUnNombre() {
		String nombreDePeli = "El dia despues de maniana";
		assertEquals(peli1.getNombre(), nombreDePeli);
	}
	
	@Test
	public void test002UnaPeliculaRecienCreadaTieneUnAnioDeEstreno() {
		int anioDeEstreno = 2010;
		assertEquals(peli1.getAnioDeEstreno().intValue(), anioDeEstreno);
	}
	
	@Test
	public void test003UnaPeliculaRecienCreadaTieneUnaIdDeIDMB() {
		int id = 15276;
		assertEquals(peli1.getId().intValue(), id);
	}
	
	@Test
	public void test004UnaPeliculaRecienCreadaTieneVariosGeneros() {
		String genero1 = "Drama";
		String genero2 = "Suspenso";
		assert(peli1.getGeneros().contains(genero1));
		assert(peli1.getGeneros().contains(genero2));
	}

}
