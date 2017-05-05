package fileReaderManagerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fileReaderManager.FileReaderManager;
import fileReaderManager.RatingData;

public class FileReaderManagerTest {

	FileReaderManager frMan = new FileReaderManager();
	
	@Before
	public void setUp() {
		
		frMan.procesarRatings("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.data.new.csv");
		frMan.procesarUsuario("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.user2.csv");
		frMan.procesarPelicula("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.item.new.csv");
		frMan.procesarAmigos("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.connection.csv");
	}
	
	@Test
	public void test001_UnUsuarioYUnaPeliculaTieneUnRating() {
		frMan.registrarRatings();
		RatingData esperado = new RatingData(196,242,3);
				
		assert(frMan.getRatingData().contains(esperado));
	}

}
