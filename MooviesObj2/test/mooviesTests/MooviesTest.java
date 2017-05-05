package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adapter.Adapter;
import moovies.Moovies;

public class MooviesTest {

	Moovies moovie;
	Adapter adapter;
	
	@Before
	public void setUp() throws Exception {
		adapter = new Adapter();
		moovie = new Moovies(adapter);
		adapter.procesarUsuario("c:\\Users\\brian\\Desktop\\Usuarios.csv");
		adapter.procesarPelicula("c:\\Users\\brian\\Desktop\\Pelicula.csv");
		adapter.procesarRatings("c:\\Users\\brian\\Desktop\\Rating.csv");
		adapter.procesarAmigos("c:\\Users\\brian\\Desktop\\Amigo.csv");
	}
	
	@Test
	public void test001_CuandoUnMooviesActualizaSuInfoTieneNuevosUsuariosYPeliculas() {
		assertEquals(moovie.getUsuarios().size(), 0);
		assertEquals(moovie.getPeliculas().size(), 0);
		moovie.actualizarInfo();
		assertEquals(moovie.getUsuarios().size(), 30);
		assertEquals(moovie.getPeliculas().size(), 30);
		
	}

}
