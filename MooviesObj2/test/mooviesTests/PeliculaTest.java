package mooviesTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;
import java.util.ArrayList;
import moovies.Pelicula;


public class PeliculaTest {

	Pelicula peli1;
	ArrayList<String> generos;
	
	@Before
	public void setUp() throws Exception {
		generos = new ArrayList<String>();
		generos.add("Drama");
		generos.add("Suspenso");
		LocalDate date = LocalDate.now();
		peli1 = new Pelicula("El dia despues de maniana", date, "tt15276", generos);
	}
	
	@Test
	public void test001UnaPeliculaRecienCreadaTieneUnNombre() {
		String nombreDePeli = "El dia despues de maniana";
		assertEquals(peli1.getNombre(), nombreDePeli);
	}
	
	@Test
	public void test002UnaPeliculaRecienCreadaTieneUnaFechaDeEstreno() {
		LocalDate date = LocalDate.now();
		assertEquals(peli1.getFechaDeEstreno(), date);
	}
	
	@Test
	public void test003UnaPeliculaRecienCreadaTieneUnaIdDeIDMB() {
		int idmb = 15276;
		assertEquals(peli1.getIdmb(), idmb);
	}
	
	@Test
	public void test004UnaPeliculaRecienCreadaTieneVariosGeneros() {
		String genero1 = "Drama";
		String genero2 = "Suspenso";
		assert(peli1.getGeneros().contains(genero1));
		assert(peli1.getGeneros().contains(genero2));
	}

}
