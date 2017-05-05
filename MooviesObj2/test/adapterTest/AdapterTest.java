package adapterTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adapter.Adapter;
import adapter.RatingData;

public class AdapterTest {

	Adapter adapter = new Adapter();
	
	@Before
	public void setUp() {
		
		adapter.procesarRatings("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.data.new.csv");
		adapter.procesarUsuario("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.user2.csv");
		adapter.procesarPelicula("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.item.new.csv");
		adapter.procesarAmigos("/home/tomas/Escritorio/Objetos 2/Trabajos Obj2/Archivos para FileReader/u.connection.csv");
	}
	
	@Test
	public void test001_UnUsuarioYUnaPeliculaTieneUnRating() {
		adapter.registrarRatings();
		RatingData esperado = new RatingData(196,242,3);
				
		assert(adapter.getRatingData().contains(esperado));
	}

}
