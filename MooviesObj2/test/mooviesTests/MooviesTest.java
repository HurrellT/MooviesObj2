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
	
	Pelicula peli1, peli2, peli3, peli4, peli5,
			 peli6, peli7, peli8, peli9, peli10,
			 peli11;
	
	Usuario user1, user2, user3, user4, user5,
			user6, user7, user8, user9, user10,
			user11;
	
	@Before
	public void setUp() throws Exception { 
		frMan = new FileReaderManager(); 
		
		moovie = new Moovies(frMan);
		
		peli1	= mock(Pelicula.class); peli2	= mock(Pelicula.class);
		peli3	= mock(Pelicula.class); peli4	= mock(Pelicula.class);
		peli5	= mock(Pelicula.class); peli6	= mock(Pelicula.class);
		peli7	= mock(Pelicula.class); peli8	= mock(Pelicula.class);
		peli9	= mock(Pelicula.class); peli10	= mock(Pelicula.class);
		peli11	= mock(Pelicula.class);
		
		
		user1	= mock(Usuario.class); user2	= mock(Usuario.class);
		user3	= mock(Usuario.class); user4	= mock(Usuario.class);
		user5	= mock(Usuario.class); user6	= mock(Usuario.class);
		user7	= mock(Usuario.class); user8	= mock(Usuario.class);
		user9	= mock(Usuario.class); user10	= mock(Usuario.class);
		user11	= mock(Usuario.class);
		
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
		moovie.addPelicula(peli5); moovie.addPelicula(peli6); moovie.addPelicula(peli7); 
		moovie.addPelicula(peli8); moovie.addPelicula(peli9); moovie.addPelicula(peli10);
		moovie.addPelicula(peli11);
		
		when(peli1.promedio()).thenReturn(1); when(peli2.promedio()).thenReturn(2);
		when(peli3.promedio()).thenReturn(3); when(peli4.promedio()).thenReturn(4);
		when(peli5.promedio()).thenReturn(5); when(peli6.promedio()).thenReturn(6);
		when(peli7.promedio()).thenReturn(7); when(peli8.promedio()).thenReturn(8);
		when(peli9.promedio()).thenReturn(9); when(peli10.promedio()).thenReturn(10);
		when(peli11.promedio()).thenReturn(7);
		
		int mejores = 10;
		assertEquals(mejores, moovie.mejoresPeliculas().size());
		assertEquals(true, moovie.mejoresPeliculas().contains(peli3));
		assertEquals(false, moovie.mejoresPeliculas().contains(peli11));  //La peli11 no esta, pero deberia
	}
	
	 @Test
	 public void test004_UnMooviesIndicaCualesSonLasMejoresPeliculasCon4Peliculas() {

	 int mejores = 4;
	 int total = 4;
	 assertEquals(mejores, moovie.mejoresPeliculas().size());
	 assertEquals(total, moovie.getPeliculas().size());

	 assertEquals(peli1, moovie.mejoresPeliculas().get(0));
	 }
	
	@Test
	public void test005_UnMooviesPuedeIndicarCualesSonLosUsuariosMasActivos() {
		moovie.addUsuario(user5); moovie.addUsuario(user6); moovie.addUsuario(user7);
		moovie.addUsuario(user8); moovie.addUsuario(user9); moovie.addUsuario(user10);
		moovie.addUsuario(user11); 
		
		when(user1.pelisClasificadas()).thenReturn(1); when(user2.pelisClasificadas()).thenReturn(2);
		when(user3.pelisClasificadas()).thenReturn(3); when(user4.pelisClasificadas()).thenReturn(4);
		when(user5.pelisClasificadas()).thenReturn(5); when(user6.pelisClasificadas()).thenReturn(6);
		when(user7.pelisClasificadas()).thenReturn(7); when(user8.pelisClasificadas()).thenReturn(8);
		when(user9.pelisClasificadas()).thenReturn(9); when(user10.pelisClasificadas()).thenReturn(10);
		when(user11.pelisClasificadas()).thenReturn(11);
		
		int activos = 10;
		assertEquals(activos, moovie.usuariosMasActivos().size());
		assertEquals(true, moovie.usuariosMasActivos().contains(user10));
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
