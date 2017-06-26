package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import fileReaderManager.FileReaderManager;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Filer;

import moovies.Calificacion;
import moovies.Genero;
import moovies.MecanismoDeRecomendacion;
import moovies.MecanismoDeRecomendacion_PuntajeAlto;
import moovies.MecanismoDeRecomendacion_PuntajeBajo;
import moovies.MecanismoDeRecomendacion_PuntajeMedio;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;

public class MecanismoDeRecomendacionTest {
	
	FileReaderManager frMan;
	Moovies moovies;
	Usuario user, user2, user3, user4, user5;
	Pelicula peli1, peli2, peli3;
	MecanismoDeRecomendacion recAlto, recMedio, recBajo;
	Genero genero1;
	Genero genero2;
	List<Genero> generos;

	@Before
	public void setUp() throws Exception {
		frMan	= mock(FileReaderManager.class);
		moovies = new Moovies(frMan);
		
		user	= new Usuario("A", 1, "A", 1);
		user2	= new Usuario("B", 2, "B", 1);
		user3	= new Usuario("C", 3, "C", 1);
		user4	= new Usuario("D", 4, "D", 1);
		user5	= new Usuario("E", 5, "E", 1);
		
		genero1 = mock(Genero.class);
		genero2 = mock(Genero.class);
		generos = new ArrayList<Genero>();
		
		LocalDate date = LocalDate.of(1997, 9, 17);
		
		peli1	= new Pelicula("A", date, "1", generos);
		peli2	= new Pelicula("B", date, "2", generos);
		peli3	= new Pelicula("C", date, "3", generos);
		
		recAlto		= new MecanismoDeRecomendacion_PuntajeAlto();
		recMedio 	= new MecanismoDeRecomendacion_PuntajeMedio();
		recBajo		= new MecanismoDeRecomendacion_PuntajeBajo();
	}

	@Test
	public void test01UnRecomendadorDePuntajeAltoObtiene1PeliculaParaRecomendarAUnUsuario() {
		moovies.addPelicula(peli1);	moovies.addPelicula(peli2);
		
		moovies.addUsuario(user);	moovies.addUsuario(user2);
		moovies.addUsuario(user3);	moovies.addUsuario(user4);
		moovies.addUsuario(user5);
		
		user.agregarAmigo(user2);	user.agregarAmigo(user3);
		user.agregarAmigo(user4);	user.agregarAmigo(user5);
		
		user2.calificarPelicula(5, peli1);	user3.calificarPelicula(4, peli1);
		user4.calificarPelicula(5, peli1);	user5.calificarPelicula(5, peli1);
		
		user2.calificarPelicula(3, peli2);	user3.calificarPelicula(2, peli2);
		user4.calificarPelicula(1, peli2);
		
		assertEquals(1, recAlto.recomendarPeliculaPara(user, moovies).size());
	}
	
	@Test
	public void test02UnRecomendadorDePuntajeMedioObtiene1PeliculasParaRecomendarAUnUsuario() {
		moovies.addPelicula(peli1); moovies.addPelicula(peli2);
		
		moovies.addUsuario(user);	moovies.addUsuario(user2);	moovies.addUsuario(user3);
		moovies.addUsuario(user4);	moovies.addUsuario(user5);
		
		user.agregarAmigo(user2);	user.agregarAmigo(user3);	
		user.agregarAmigo(user4);	user.agregarAmigo(user5);
		
		user2.calificarPelicula(5, peli1);	user3.calificarPelicula(4, peli1);
		user4.calificarPelicula(2, peli1);	user5.calificarPelicula(3, peli1);
		
		user2.calificarPelicula(3, peli2);	user3.calificarPelicula(2, peli2);
		user4.calificarPelicula(1, peli2);
		
		assertEquals(1, recMedio.recomendarPeliculaPara(user, moovies).size());
		assertEquals(peli1, recMedio.recomendarPeliculaPara(user, moovies).get(0));
	}
	
	@Test
	public void test03UnRecomendadorDePuntajeMedioObtiene3PeliculasParaRecomendarAUnUsuario() {
		moovies.addPelicula(peli1); moovies.addPelicula(peli2); moovies.addPelicula(peli3);
		
		moovies.addUsuario(user);	moovies.addUsuario(user2);	moovies.addUsuario(user3);
		moovies.addUsuario(user4);	moovies.addUsuario(user5);
		
		user.agregarAmigo(user2);	user.agregarAmigo(user3);	
		user.agregarAmigo(user4);	user.agregarAmigo(user5);
		
		user2.calificarPelicula(5, peli1);	user3.calificarPelicula(5, peli1);
		user4.calificarPelicula(2, peli1);	user5.calificarPelicula(5, peli1);
		
		user2.calificarPelicula(3, peli2);	user3.calificarPelicula(4, peli2);
		user4.calificarPelicula(4, peli2);
		
		user2.calificarPelicula(4, peli3); user3.calificarPelicula(5, peli3);
		user4.calificarPelicula(4, peli3);
		
		assertEquals(3, recMedio.recomendarPeliculaPara(user, moovies).size());
		assertEquals(peli3, recMedio.recomendarPeliculaPara(user, moovies).get(0));
		assertEquals(peli2, recMedio.recomendarPeliculaPara(user, moovies).get(1));
		assertEquals(peli1, recMedio.recomendarPeliculaPara(user, moovies).get(2));
	}
	
	@Test
	public void test04UnRecomendadorDePuntajeBajoObtiene2PeliculasParaRecomendarAUnUsuario() {
		moovies.addPelicula(peli1);	moovies.addPelicula(peli2);
		
		moovies.addUsuario(user);	moovies.addUsuario(user2);	moovies.addUsuario(user3);
		moovies.addUsuario(user4);	moovies.addUsuario(user5);
		
		user.agregarAmigo(user2);	user.agregarAmigo(user3);	
		user.agregarAmigo(user4);	user.agregarAmigo(user5);
		
		user2.calificarPelicula(5, peli1);	user3.calificarPelicula(4, peli1);
		user4.calificarPelicula(5, peli1);	user5.calificarPelicula(5, peli1);
		
		user2.calificarPelicula(3, peli2);	user3.calificarPelicula(2, peli2);
		user4.calificarPelicula(1, peli2);
		
		assertEquals(2, recBajo.recomendarPeliculaPara(user, moovies).size());
	}
}
