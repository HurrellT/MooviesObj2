package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fileReaderManager.FileReaderManager;
import moovies.Moovies;

public class MooviesTest {

	Moovies moovie;
	FileReaderManager frMan;
	
	@Before
	public void setUp() throws Exception {
		frMan = new FileReaderManager();
		moovie = new Moovies(frMan);
		frMan.procesarUsuario("c:\\Users\\brian\\Desktop\\Usuarios.csv");
		frMan.procesarPelicula("c:\\Users\\brian\\Desktop\\Pelicula.csv");
		frMan.procesarRatings("c:\\Users\\brian\\Desktop\\Rating.csv");
		frMan.procesarAmigos("c:\\Users\\brian\\Desktop\\Amigo.csv");
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
