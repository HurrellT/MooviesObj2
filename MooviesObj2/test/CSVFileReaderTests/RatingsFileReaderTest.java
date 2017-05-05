package CSVFileReaderTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CSVFileReaders.CSVFileReader;
import CSVFileReaders.RatingsFileReader;
import adapter.RatingData;

public class RatingsFileReaderTest {
    private CSVFileReader<RatingData> reader;

    @Before
    public void setUp(){
        // Inicializamos la clase con la ubicacion del archivo
        reader = new RatingsFileReader("C:\\Users\\mega_\\UNQUI\\Objetos 2\\Trabajos Obj2\\Archivos para FileReader\\u.data.new.csv");
    }

    @Test
    public void test001_UnRatingFileReaderCreaUnaListaDeRatingDataAlLeerUnArchivo() {
        int expectedSize        = 100000;
        
       // Leemos el archivo y obtenemos la lista de objetos.
        List<RatingData> ratings  = reader.readFile();

        assertEquals(expectedSize, ratings.size());
    }
    
}