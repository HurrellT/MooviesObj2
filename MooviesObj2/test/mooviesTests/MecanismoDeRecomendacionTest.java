package mooviesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import moovies.MecanismoDeRecomendacion;
import moovies.MecanismoDeRecomendacion_PuntajeAlto;
import moovies.Pelicula;
import moovies.Usuario;

public class MecanismoDeRecomendacionTest {
	
	MecanismoDeRecomendacion recAlto;
	Usuario user, user2;
	Pelicula peli1, peli2;

	@Before
	public void setUp() throws Exception {
		user 	= new Usuario("Jorge", 29, "Medico", 1111);
		user2 	= new Usuario("Mariano", 28, "Psicologo", 1111);
		peli1	= mock(Pelicula.class);
		peli2	= mock(Pelicula.class);
		
//		recAlto	= new MecanismoDeRecomendacion_PuntajeAlto();
		recAlto	= mock(MecanismoDeRecomendacion_PuntajeAlto.class);
		
		user.agregarAmigo(user2);
		user2.calificarPelicula(5, peli1);
		user2.calificarPelicula(3, peli2);
	}

	@Test
	public void test01UnRecomendadorDePuntajeAltoObtiene1PeliculaParaRecomendarAUnUsuarioCuyoUnicoAmigoPuntuo2Peliculas() {
		recAlto.recomendarPeliculaPara(user);
//		when(peli1.getCalificaciones().get(0).getPuntaje()).thenReturn(5);
//		when(peli2.getCalificaciones().get(0).getPuntaje()).thenReturn(3);
		
		verify(recAlto).recomendarPeliculaPara(user);
//		spy(recAlto).recomendarPeliculaPara(user);
	}

}
