package fileReaderManagerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fileReaderManager.FileReaderManager;
import fileReaderManager.PeliculaData;
import fileReaderManager.RatingData;
import moovies.Genero;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;

public class FileReaderManagerTest {

	FileReaderManager frMan;
	Moovies moovies;

	Genero 	gen1, gen2, gen3, gen4, gen5, gen6, gen7, gen8, gen9, gen10,
			gen11, gen12, gen13, gen14, gen15, gen16, gen17, gen18, gen19;

	
	@Before
	public void setUp() {
		
frMan = new FileReaderManager();
		
		moovies = new Moovies(frMan);
		
		frMan.addMoovies(moovies);
		
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
		
		
		frMan.procesarUsuario("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/UsuariosData.csv");
		frMan.procesarPelicula("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/PeliculaData.csv");
		frMan.procesarRatings("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/CalificacionesData.csv");
		frMan.procesarAmigos("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/AmigosData.csv");

	}
	
	@Test
	public void test001_UnUsuarioYUnaPeliculaTieneUnRating() {
		moovies.actualizarInfo();
		RatingData esperado = new RatingData(196,242,3);
				
		assert(frMan.getRatingData().contains(esperado));
	}
	
	@Test
	public void test002_LaPeliculaMightyAphroditeEsDeComedia() {
		PeliculaData mighty = frMan.findPeliculaData(13);
				
		assertEquals("Mighty Aphrodite (1995)", mighty.getMovie().getNombre());
	}

}
