package mooviesTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
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
		assertEquals(peli1.getAnioDeEstreno(), anioDeEstreno);
		//Cuidado con esto: como los Integer son un objeto que guarda un int,
		//en los tests hay que usar intValue() para que devuelva el int que tiene
	}
	
	@Test
	public void test003UnaPeliculaRecienCreadaTieneUnaIdDeIDMB() {
		int idmb = 15276;
		assertEquals(peli1.getIdmb(), idmb);
		//Tomas: getId da el id de pelicula, no el id de IDMB.
		//Corregi el test y cree un test nuevo (test005) para el id normal.
	}
	
	@Test
	public void test004UnaPeliculaRecienCreadaTieneVariosGeneros() {
		String genero1 = "Drama";
		String genero2 = "Suspenso";
		assert(peli1.getGeneros().contains(genero1));
		assert(peli1.getGeneros().contains(genero2));
	}

}
