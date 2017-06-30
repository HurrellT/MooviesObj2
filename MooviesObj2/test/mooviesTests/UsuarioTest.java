package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fileReaderManager.FileReaderManager;
import moovies.Calificacion;
import moovies.Genero;
import moovies.Genero_Especifico;
import moovies.MecanismoDeRecomendacion_PuntajeAlto;
import moovies.MecanismoDeRecomendacion_PuntajeBajo;
import moovies.MecanismoDeRecomendacion_PuntajeMedio;
import moovies.Moovies;
import moovies.Pelicula;
import moovies.Usuario;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {

	Usuario user, luca, esteban;
	
	Pelicula peli, peli2, peli3, peli4, peli5, peli6;
	
	Calificacion cal, cal2;
	
	Genero gen1;
	
	MecanismoDeRecomendacion_PuntajeBajo bajo;
	MecanismoDeRecomendacion_PuntajeMedio medio;
	MecanismoDeRecomendacion_PuntajeAlto alto;
	
	Moovies moov;
		
	@Before
	public void setUp() {
		luca	= new Usuario("Luca Hazuca", 18, "Programador", 1878);
		esteban	= new Usuario("Esteban Bedecarats", 21, "Programador", 1878);

		luca.agregarAmigo(esteban);
		
		peli	= mock(Pelicula.class);
		peli2	= mock(Pelicula.class);
		peli3	= mock(Pelicula.class);
		peli4	= mock(Pelicula.class);
		peli5	= mock(Pelicula.class);
		peli6	= mock(Pelicula.class);
		
		cal		= mock(Calificacion.class);
		cal2	= mock(Calificacion.class);
		
		gen1 	= new Genero_Especifico("Vampiros");
		
		bajo = mock(MecanismoDeRecomendacion_PuntajeBajo.class);
		medio = mock(MecanismoDeRecomendacion_PuntajeMedio.class);
		alto = mock(MecanismoDeRecomendacion_PuntajeAlto.class);
		
		moov = mock(Moovies.class);

	}
	
	@Test
	public void test01UnUsuarioLlamadoLucaHazucaTiene18AniosEsProgramadorYTieneElCodigoPostal1878() {
		String 	name	= "Luca Hazuca";
		int		edad	  = 18;
		String	ocup	= "Programador";
		int		codPos	= 1878;
		
		assertEquals(name, luca.getNombre());
		assertEquals(edad, luca.getEdad());
		assertEquals(ocup, luca.getOcupacion());
		assertEquals(codPos, luca.getCodPos());
	}
	
	@Test
	public void test02LucaTieneUnSoloAmigoYSeLlamaEstebanBedecarats() {
		String amigo	= "Esteban Bedecarats";
		
		assertEquals(1, luca.getAmigos().size());
		assertEquals(amigo, luca.getAmigos().get(0).getNombre());
	}
	
	@Test
	public void test03LucaTiene2CalificacionesHechasAPeliculas() {
		luca.calificarPelicula(4, peli);
		luca.calificarPelicula(2, peli2);
		
		assertEquals(2, luca.getCalificaciones().size());
		assertEquals(4, luca.getCalificaciones().get(0).getPuntaje());
		assertEquals(2, luca.getCalificaciones().get(1).getPuntaje());
		
		assertEquals(2, luca.pelisClasificadas());
	}
	
	@Test
	public void test04LucaEliminaASuUnicoAmigoYPasaATener0Amigos() {
		luca.eliminarAmigo(esteban);
		
		assertEquals(0, luca.getAmigos().size());
	}
	
	@Test
	public void test05LucaTieneUnaListaDeNuevasPeliculasDeLosGenerosALOsQueSeSuscribio() {
		gen1.suscribirse(luca);
		gen1.agregarPelicula(peli);
		
		assertTrue(luca.nuevasRecomendaciones().contains(peli));
		
	}

	@Test
	public void test06LucaEvaluoLaPeliculaPeli2ConUnPuntajeDe3() {
		luca.calificarPelicula(3, peli2);
		
		assertEquals(peli2, luca.getCalificaciones().get(0).getPeli());
		assertEquals(true, luca.evaluoLaPelicula(peli2));
	}
	
	@Test
	public void test07LucaTieneAdjudicadaUnaCalificacionPorLaPuntuacionHechaAUnaPelicula() {
		luca.calificarPelicula(3, peli);
		
		Calificacion actualCal = luca.buscarCalificacion(peli);
		
		when(cal.getPeli()).thenReturn(peli);
		when(cal.getPuntaje()).thenReturn(3);
		when(cal.getUsuario()).thenReturn(luca);
		
		assertEquals(cal.getPeli(), actualCal.getPeli());
		assertEquals(cal.getPuntaje(), actualCal.getPuntaje());
		assertEquals(cal.getUsuario(), actualCal.getUsuario());
	}
	
	@Test
	public void test08LucaComparaLaCantidadDePeliculasCalificadasQueTieneConOtroUsuario() {
		int res = luca.compareTo(esteban);
		int igualCant = 0;
		int LucaMayorCant = 1;
		int LucaMenorCant = -1;
		//Igual cantidad de peliculas calificadas
		assertEquals(igualCant, res);
		
		//Menor cantidad de peliculas calificadas por Luca
		esteban.calificarPelicula(2, peli2);
		res = luca.compareTo(esteban);
		assertEquals(LucaMenorCant, res);
		
		//Mayor cantidad de peliculas calificadas por Luca
		luca.calificarPelicula(2, peli2);
		luca.calificarPelicula(3, peli);
		res = luca.compareTo(esteban);
		assertEquals(LucaMayorCant, res);
	}

}
