package mooviesTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import fileReaderManager.FileReaderManager;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;

public class MooviesTest {

	Moovies moovie;
	
	FileReaderManager frMan;
	
	Pelicula peli1, peli2, peli3, peli4;
	
	Usuario user1, user2, user3, user4;
	
	@Before
	public void setUp() throws Exception {
		frMan = new FileReaderManager();
		
		moovie = new Moovies(frMan);
		
		peli1	= mock(Pelicula.class); peli2	= mock(Pelicula.class);
		peli3	= mock(Pelicula.class); peli4	= mock(Pelicula.class);
		
		
		user1	= mock(Usuario.class); user2	= mock(Usuario.class);
		user3	= mock(Usuario.class); user4	= mock(Usuario.class);
		
		moovie.addPelicula(peli1); moovie.addPelicula(peli2);
		moovie.addPelicula(peli3); moovie.addPelicula(peli4);
		
		moovie.addUsuario(user1); moovie.addUsuario(user2);
		moovie.addUsuario(user3); moovie.addUsuario(user4);
		
	}
	
	@Test
	public void test001_UnMooviesTieneUnaCiertaCantidadDePeliculas() {
		int number = 4;
		assertEquals(number, moovie.getPeliculas().size());
	}
	
	@Test
	public void test002_UnMooviesTieneUnaCiertaCantidadDeUsuarios() {
		int number = 4;
		assertEquals(number, moovie.getUsuarios().size());
	}
	
	@Test
	public void test003_UnMooviesPuedeIndicarCualesSonLasMejoresPeliculas() {
		moovie.addPelicula(peli1); moovie.addPelicula(peli2); moovie.addPelicula(peli3); 
		moovie.addPelicula(peli4); moovie.addPelicula(peli1); moovie.addPelicula(peli2);
		moovie.addPelicula(peli3); moovie.addPelicula(peli4);
		
		when(peli1.compareTo(peli2)).thenReturn(1);
		when(peli1.compareTo(peli3)).thenReturn(0);
		when(peli1.compareTo(peli4)).thenReturn(-1);
		
		int mejores = 10;
		int total = 12;
		assertEquals(mejores, moovie.mejoresPeliculas().size());
		assertEquals(total, moovie.getPeliculas().size());
	}
	
	@Test
	public void test004_UnMooviesPuedeIndicarCualesSonLosUsuariosMasActivos() {
		moovie.addUsuario(user1); moovie.addUsuario(user2); moovie.addUsuario(user3);
		moovie.addUsuario(user4); moovie.addUsuario(user1); moovie.addUsuario(user2);
		moovie.addUsuario(user3); moovie.addUsuario(user4);
		
		when(user1.compareTo(user2)).thenReturn(1);
		when(user1.compareTo(user3)).thenReturn(0);
		when(user1.compareTo(user4)).thenReturn(-1);
		
		int activos = 10;
		int total = 12;
		assertEquals(activos, moovie.usuariosMasActivos().size());
		assertEquals(total, moovie.getUsuarios().size());
	}
	
	/*@Test
	public void test005_CuandoUnMooviesActualizaSuInfoTieneNuevosUsuariosYPeliculas() {
		frMan.procesarUsuario("c:\\Users\\brian\\Desktop\\Usuarios.csv");
		frMan.procesarPelicula("c:\\Users\\brian\\Desktop\\Pelicula.csv");
		frMan.procesarRatings("c:\\Users\\brian\\Desktop\\Rating.csv");
		frMan.procesarAmigos("c:\\Users\\brian\\Desktop\\Amigo.csv");
		
		assertEquals(moovie.getUsuarios().size(), 4);
		assertEquals(moovie.getPeliculas().size(), 4);
		
		moovie.actualizarInfo();
		
		assertEquals(moovie.getUsuarios().size(), 34);
		assertEquals(moovie.getPeliculas().size(), 34);
	}*/
}
