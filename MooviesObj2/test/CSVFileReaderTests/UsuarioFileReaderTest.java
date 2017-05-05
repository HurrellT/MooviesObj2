package CSVFileReaderTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import CSVFileReaders.CSVFileReader;
import CSVFileReaders.UsuarioFileReader;
import adapter.UsuarioData;
import moovies.Usuario;
import java.util.*;

public class UsuarioFileReaderTest {

	private CSVFileReader<UsuarioData> reader;
	
	@Before
    public void setUp(){
        // Inicializamos la clase con la ubicacion del archivo
        reader = new UsuarioFileReader("c:\\Users\\mega_\\UNQUI\\Objetos 2\\Trabajos Obj2\\Archivos para FileReader\\u.userB.csv"); //el parametro de UsuarioFileReader es el string con la ubicacion del archivo
    }
	
	@Test
    public void test001_UnUsuarioFileReaderCreaUnaListaDeUsuariosDataAlLeerUnArchivo() {
        int expectedSize = 51;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<UsuarioData> usuarios = reader.readFile();

        assertEquals(expectedSize, usuarios.size());
    }


}


 
