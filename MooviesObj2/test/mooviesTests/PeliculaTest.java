package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import moovies.Calificacion;
import moovies.Genero;
import moovies.Pelicula;
import moovies.Usuario;

import static org.mockito.Mockito.*;


public class PeliculaTest {

	Pelicula peli1, peli2, peli3, peli4;
	
	Genero genero1, genero2;
	
	Usuario user1, user2;
	Calificacion cal;
	
	List<Genero> generos;
	
	@Before
	public void setUp() {
		genero1 = mock(Genero.class);
		genero2 = mock(Genero.class);
		
		generos = new ArrayList<Genero>();
		generos.add(genero1);
		generos.add(genero2);
		
		LocalDate fecha1 = LocalDate.of(1997, 9, 17);
		LocalDate fecha2 = LocalDate.of(1985, 2, 03);
		
		peli1 = new Pelicula("Alien", fecha1, "15276", generos);
		peli2 = new Pelicula("Star Wars", fecha2, "27655", generos);
		
		user1 = mock(Usuario.class);
		user2 = mock(Usuario.class);
		
		cal = mock(Calificacion.class);
	}
	
	@Test
	public void test001UnaPeliculaRecienCreadaTieneUnNombre() {
		String nombre1 = "Alien";
		String nombre2 = "Star Wars";
		assertEquals(nombre1, peli1.getNombre());
		assertEquals(nombre2, peli2.getNombre());
	}
	
	@Test
	public void test002UnaPeliculaRecienCreadaTieneUnaFechaDeEstreno() {
		LocalDate fecha1 = LocalDate.of(1997, 9, 17);
		LocalDate fecha2 = LocalDate.of(1985, 2, 03);
		assertEquals(fecha1, peli1.getFechaDeEstreno());
		assertEquals(fecha2, peli2.getFechaDeEstreno());
	}
	
	@Test
	public void test003UnaPeliculaRecienCreadaTieneUnaIdDeIDMB() {
		String idmb1 = "15276";
		String idmb2 = "27655";
		assertEquals(idmb1, peli1.getIdmb());
		assertEquals(idmb2, peli2.getIdmb());
	}
	
	@Test
	public void test004UnaPeliculaRecienCreadaTieneVariosGeneros() {
		
	}
	
	//Tests para metodos de recomendaciones
	@Test
	public void test05UnaPeliculaPuedeSerRecomendacionParaUnUsuarioConMasDe1Amigo() {
		List<Usuario> amigosUser1 = new ArrayList<>();
		amigosUser1.add(user2);
		when(user1.getAmigos()).thenReturn(amigosUser1);
		when(user2.evaluoLaPelicula(peli1)).thenReturn(true);
		when(user2.buscarCalificacion(peli1)).thenReturn(cal);
		
		when(cal.getPuntaje()).thenReturn(3);
		
		assertTrue(peli1.esRecomendacionPara(user1, 2, 0));
	}

}
