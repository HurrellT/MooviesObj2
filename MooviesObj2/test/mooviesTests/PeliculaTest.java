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
	public void test() {
		fail("Not yet implemented");
	}

}
