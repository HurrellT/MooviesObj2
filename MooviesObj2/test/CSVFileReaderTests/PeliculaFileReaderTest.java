package CSVFileReaderTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import CSVFileReaders.CSVFileReader;
import CSVFileReaders.PeliculaFileReader;
import fileReaderManager.FileReaderManager;
import fileReaderManager.PeliculaData;
import moovies.Genero;
import moovies.Moovies;
import static org.mockito.Mockito.*;

import java.util.*;

public class PeliculaFileReaderTest {

	private CSVFileReader<PeliculaData> reader;
	
	Moovies moovies;
	
	Genero 	gen1, gen2, gen3, gen4, gen5, gen6, gen7, gen8, gen9, gen10,
	gen11, gen12, gen13, gen14, gen15, gen16, gen17, gen18, gen19;
	
	@Before
    public void setUp(){
		FileReaderManager frMan = mock(FileReaderManager.class);
		moovies = new Moovies(frMan);
		
		// Inicializamos la clase con la ubicacion del archivo
		reader = new PeliculaFileReader("/home/tomas/UNQUI/Objetos 2/Trabajos Obj2/Archivos para FileReader/PeliculaData.csv", moovies); //el parametro de UsuarioFileReader es el string con la ubicacion del archivo
		
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
    }
	
	@Test
    public void test001_UnaPeliculaFileReaderCreaUnaListaDePeliculaDataAlLeerUnArchivo() {
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
		
		int expectedSize = 15;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<PeliculaData> peliculas = reader.readFile();

        assertEquals(expectedSize, peliculas.size());
    }

	@Test
	public void test002ElGeneroComediaEstaAsociadoAlNumero5(){
		String genero = "Comedy";
		
		assertEquals(genero, ((PeliculaFileReader) reader).procesarGeneros(5));
	}

}