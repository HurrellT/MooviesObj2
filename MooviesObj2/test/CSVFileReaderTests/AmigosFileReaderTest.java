package CSVFileReaderTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import CSVFileReaders.AmigosFileReader;
import CSVFileReaders.CSVFileReader;
import adapter.AmigosData;

import java.util.*;

public class AmigosFileReaderTest {

	private CSVFileReader<AmigosData> reader;
	
	@Before
    public void setUp(){
        // Inicializamos la clase con la ubicacion del archivo
        reader = new AmigosFileReader("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.connection.csv"); //el parametro de UsuarioFileReader es el string con la ubicacion del archivo
    }
	
	@Test
    public void test001_UnAmigosFileReaderCreaUnaListaDeAmigosDataAlLeerUnArchivo() {
        int expectedSize = 5600;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<AmigosData> amigos = reader.readFile();

        assertEquals(expectedSize, amigos.size());
    }


}