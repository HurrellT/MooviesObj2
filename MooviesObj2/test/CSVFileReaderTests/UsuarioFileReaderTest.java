package CSVFileReaderTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import CSVFileReaders.CSVFileReader;
import CSVFileReaders.UsuarioFileReader;
import moovies.Usuario;
import java.util.*;

public class UsuarioFileReaderTest {

	private CSVFileReader<Usuario> reader;
	
	@Before
    public void setUp(){
        // Inicializamos la clase con la ubicacion del archivo
        reader = new UsuarioFileReader("/home/usuario/usuarios.csv");
    }
	
	@Test
    public void readFileUsuariosReturnsAListWithTenObjects() {
        int expectedSize        = 10;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<Usuario> usuarios  = reader.readFile();

        assertEquals(expectedSize, usuarios.size());
    }

}


 
