package CSVFileReaderTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import CSVFileReaders.CSVFileReader;
import CSVFileReaders.PeliculaFileReader;
import fileReaderManager.PeliculaData;

import java.util.*;

public class PeliculaFileReaderTest {

	private CSVFileReader<PeliculaData> reader;
	
	@Before
    public void setUp(){
        // Inicializamos la clase con la ubicacion del archivo
        reader = new PeliculaFileReader("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.item.new2.csv"); //el parametro de UsuarioFileReader es el string con la ubicacion del archivo
    }
	
	@Test
    public void test001_UnaPeliculaFileReaderCreaUnaListaDePeliculaDataAlLeerUnArchivo() {
        int expectedSize = 15;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<PeliculaData> peliculas = reader.readFile();

        assertEquals(expectedSize, peliculas.size());
    }


}