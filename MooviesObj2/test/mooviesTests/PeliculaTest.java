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

import static org.mockito.Mockito.*;


public class PeliculaTest {

	Pelicula peli1, peli2, peli3, peli4;
	
	Genero genero1, genero2, genero3;
	
	List<Genero> generosA, generosB;
	
	Calificacion calif1, calif2, calif3;
	
	@Before
	public void setUp() {
		genero1 = mock(Genero.class);
		genero2 = mock(Genero.class);
		genero3 = mock(Genero.class);
		
		generosA = new ArrayList<Genero>();
		generosB = new ArrayList<Genero>();
		generosA.add(genero1);
		generosA.add(genero2);
		generosB.add(genero3);
		
		calif1 = mock(Calificacion.class);
		calif2 = mock(Calificacion.class);
		calif3 = mock(Calificacion.class);
		
		LocalDate fecha1 = LocalDate.of(1997, 9, 17);
		LocalDate fecha2 = LocalDate.of(1985, 2, 03);
		
		peli1 = new Pelicula("Alien", fecha1, "15276", generosA);
		peli2 = new Pelicula("Star Wars", fecha2, "27655", generosB);
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
		int generosA = 2;
		int generosB = 1;
		assertEquals(generosA, peli1.getGeneros().size()); 
		assertEquals(generosB, peli2.getGeneros().size());
	} 
	
	@Test
	public void test005UnaPeliculaTieneVariasCalificaciones() {
		peli1.addRating(calif1); 
		peli1.addRating(calif2);
		peli1.addRating(calif3);
		
		assertEquals(3, peli1.getCalificaciones().size());
	} 
	
	@Test
	public void test006UnaPeliculaTieneUnPuntajePromedioAPartirDeSusCalificaciones() {
		peli1.addRating(calif1);
		peli1.addRating(calif2);
		peli1.addRating(calif3);
		
		when(calif1.getPuntaje()).thenReturn(6);
		when(calif2.getPuntaje()).thenReturn(7);
		when(calif3.getPuntaje()).thenReturn(8);
		
		int promedio = 7;
		assertEquals(promedio, peli1.promedio());
	} 

}
