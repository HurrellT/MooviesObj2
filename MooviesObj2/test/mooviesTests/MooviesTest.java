package mooviesTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import fileReaderManager.FileReaderManager;
import moovies.Genero;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;

public class MooviesTest {

	Moovies moovies;
	
	FileReaderManager frMan;
	
	Pelicula peli1, peli2, peli3, peli4, peli5,
			 peli6, peli7, peli8, peli9, peli10,
			 peli11;
	
	Genero 	gen1, gen2, gen3, gen4, gen5, gen6, gen7, gen8, gen9, gen10,
			gen11, gen12, gen13, gen14, gen15, gen16, gen17, gen18, gen19;
	
	Usuario user1, user2, user3, user4, user5,
			user6, user7, user8, user9, user10,
			user11;
	
	@Before
	public void setUp() throws Exception { 
		frMan = new FileReaderManager();
		
		moovies = new Moovies(frMan);
		
		frMan.addMoovies(moovies);
		
		peli1	= mock(Pelicula.class); peli2	= mock(Pelicula.class);
		peli3	= mock(Pelicula.class); peli4	= mock(Pelicula.class);
		peli5	= mock(Pelicula.class); peli6	= mock(Pelicula.class);
		peli7	= mock(Pelicula.class); peli8	= mock(Pelicula.class);
		peli9	= mock(Pelicula.class); peli10	= mock(Pelicula.class);
		peli11	= mock(Pelicula.class);
		
		gen1	= mock(Genero.class); gen2	= mock(Genero.class);
		gen3	= mock(Genero.class); gen4	= mock(Genero.class);
		gen5	= mock(Genero.class); gen6	= mock(Genero.class);
		gen7	= mock(Genero.class); gen8	= mock(Genero.class);
		gen9	= mock(Genero.class); gen10	= mock(Genero.class);
		gen11	= mock(Genero.class); gen12	= mock(Genero.class);
		gen13	= mock(Genero.class); gen14	= mock(Genero.class);
		gen15	= mock(Genero.class); gen16	= mock(Genero.class);
		gen17	= mock(Genero.class); gen18	= mock(Genero.class);
		gen19	= mock(Genero.class);
		
		user1	= mock(Usuario.class); user2	= mock(Usuario.class);
		user3	= mock(Usuario.class); user4	= mock(Usuario.class);
		user5	= mock(Usuario.class); user6	= mock(Usuario.class);
		user7	= mock(Usuario.class); user8	= mock(Usuario.class);
		user9	= mock(Usuario.class); user10	= mock(Usuario.class);
		user11	= mock(Usuario.class);
		
		moovies.addPelicula(peli1); moovies.addPelicula(peli2);
		moovies.addPelicula(peli3); moovies.addPelicula(peli4);
		
		moovies.addUsuario(user1); moovies.addUsuario(user2);
		moovies.addUsuario(user3); moovies.addUsuario(user4);
		
		moovies.agregarGenero(gen1); moovies.agregarGenero(gen2);
		moovies.agregarGenero(gen3); moovies.agregarGenero(gen4);
		moovies.agregarGenero(gen5); moovies.agregarGenero(gen6);
		moovies.agregarGenero(gen7); moovies.agregarGenero(gen8);
		moovies.agregarGenero(gen9); moovies.agregarGenero(gen10);
		moovies.agregarGenero(gen11); moovies.agregarGenero(gen12);
		moovies.agregarGenero(gen13); moovies.agregarGenero(gen14);
		moovies.agregarGenero(gen15); moovies.agregarGenero(gen16);
		moovies.agregarGenero(gen17); moovies.agregarGenero(gen18);
		moovies.agregarGenero(gen19);
		
	}
	
	@Test
	public void test001_UnMooviesTieneUnaCiertaCantidadDePeliculas() {
		int number = 4;
		assertEquals(number, moovies.getPeliculas().size());
	}
	
	@Test
	public void test002_UnMooviesTieneUnaCiertaCantidadDeUsuarios() {
		int number = 4;
		assertEquals(number, moovies.getUsuarios().size()); 
	}
	
	@Test
	public void test003_UnMooviesPuedeIndicarCualesSonLasMejoresPeliculas() {
		moovies.addPelicula(peli5); moovies.addPelicula(peli6); moovies.addPelicula(peli7); 
		moovies.addPelicula(peli8); moovies.addPelicula(peli9); moovies.addPelicula(peli10);
		moovies.addPelicula(peli11);
		
		when(peli1.promedio()).thenReturn(1); when(peli2.promedio()).thenReturn(2);
		when(peli3.promedio()).thenReturn(3); when(peli4.promedio()).thenReturn(4);
		when(peli5.promedio()).thenReturn(5); when(peli6.promedio()).thenReturn(6);
		when(peli7.promedio()).thenReturn(7); when(peli8.promedio()).thenReturn(8);
		when(peli9.promedio()).thenReturn(9); when(peli10.promedio()).thenReturn(10);
		when(peli11.promedio()).thenReturn(7);
		
		int mejores = 10;
		assertEquals(mejores, moovies.mejoresPeliculas().size());

		assertTrue(moovies.mejoresPeliculas().contains(peli3));
		assertFalse(moovies.mejoresPeliculas().contains(peli11));
}
	
	 @Test
	 public void test004_UnMooviesIndicaCualesSonLasMejoresPeliculasCon4Peliculas() {

	 int mejores = 4;
	 int total = 4;
	 assertEquals(mejores, moovies.mejoresPeliculas().size());
	 assertEquals(total, moovies.getPeliculas().size());

	 assertEquals(peli1, moovies.mejoresPeliculas().get(0));
	 }
	
	@Test
	public void test005_UnMooviesPuedeIndicarCualesSonLosUsuariosMasActivos() {
		moovies.addUsuario(user5); moovies.addUsuario(user6); moovies.addUsuario(user7);
		moovies.addUsuario(user8); moovies.addUsuario(user9); moovies.addUsuario(user10);
		moovies.addUsuario(user11);
		
		when(user1.pelisClasificadas()).thenReturn(1); when(user2.pelisClasificadas()).thenReturn(2);
		when(user3.pelisClasificadas()).thenReturn(3); when(user4.pelisClasificadas()).thenReturn(4);
		when(user5.pelisClasificadas()).thenReturn(5); when(user6.pelisClasificadas()).thenReturn(6);
		when(user7.pelisClasificadas()).thenReturn(7); when(user8.pelisClasificadas()).thenReturn(8);
		when(user9.pelisClasificadas()).thenReturn(9); when(user10.pelisClasificadas()).thenReturn(10);
		when(user11.pelisClasificadas()).thenReturn(11);
		
		int activos = 10;
		assertEquals(activos, moovies.usuariosMasActivos().size());
		assertFalse(moovies.usuariosMasActivos().contains(user10));
	}
	
	@Test
	public void test006_CuandoUnMooviesActualizaSuInfoTieneNuevosUsuariosYPeliculas() {
		
		when(gen1.getNombre()).thenReturn("unknown");
		when(gen2.getNombre()).thenReturn("Action");
		when(gen3.getNombre()).thenReturn("Adventure");
		when(gen4.getNombre()).thenReturn("Animation");
		when(gen5.getNombre()).thenReturn("Childrens");
		when(gen6.getNombre()).thenReturn("Comedy");
		when(gen7.getNombre()).thenReturn("Crime");
		when(gen8.getNombre()).thenReturn("Documentary");
		when(gen9.getNombre()).thenReturn("Drama");
		when(gen10.getNombre()).thenReturn("Fantasy");
		when(gen11.getNombre()).thenReturn("Film-Noir");
		when(gen12.getNombre()).thenReturn("Horror");
		when(gen13.getNombre()).thenReturn("Musical");
		when(gen14.getNombre()).thenReturn("Mistery");
		when(gen15.getNombre()).thenReturn("Romance");
		when(gen16.getNombre()).thenReturn("Sci-Fi");
		when(gen17.getNombre()).thenReturn("Thriller");
		when(gen18.getNombre()).thenReturn("War");
		when(gen19.getNombre()).thenReturn("Western");
		
		frMan.procesarUsuario("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/UsuariosData.csv");
		frMan.procesarPelicula("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/PeliculaData.csv");
		frMan.procesarRatings("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/CalificacionesData.csv");
		frMan.procesarAmigos("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/AmigosData.csv");
		
		assertEquals(moovies.getUsuarios().size(), 4);
		assertEquals(moovies.getPeliculas().size(), 4);
		
		moovies.actualizarInfo();
		
		assertEquals(moovies.getUsuarios().size(), 55);
		assertEquals(moovies.getPeliculas().size(), 19);
	}
	
	@Test
	public void test007_UnMooviesPuedeQuitarUnGeneroDeSuListaDeGeneros(){
		assertEquals(19, moovies.getGeneros().size());
		assertTrue(moovies.getGeneros().contains(gen15));
		
		moovies.quitarGenero(gen15);
		
		assertEquals(18, moovies.getGeneros().size());
		assertFalse(moovies.getGeneros().contains(gen15));
	}
	
	@Test
	public void test008_UnMooviesPuedeBuscarUnGenero(){
		when(gen3.getNombre()).thenReturn("Adventure");
		
		assertEquals(gen3, moovies.buscarGenero("Adventure"));
	}

	

}