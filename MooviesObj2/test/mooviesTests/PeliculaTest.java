package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeliculaTest {

	Pelicula peli1;
	ArrayList<String> generos;
	
	@Before
	public void setUp throws exception() {
		generos = new ArrayList<String>;
		generos.add("Drama");
		peli1 = new Pelicula("El dia despues de mañana", 2010, 15276, generos);
	}
	
	@Test
	public void test001UnaPeliculaRecienCreadaTieneUnNombre() {
		String nombreDePeli = "El dia despues de mañana";
		selfAssert(peli1.getNombre(), nombreDePeli);
	}
	
	@Test
	public void test002UnaPeliculaRecienCreadaTieneUnAñoDeEstreno() {
		Int añoDeEstreno = 2010;
		selfAssert(peli1.getAñoDeEstreno(), añoDeEstreno);
	}
	
	@Test
	public void test003UnaPeliculaRecienCreadaTieneUnaIdDeIDMB() {
		Int id = 15276;
		selfAssert(peli1.getId(), id);
	}

}
