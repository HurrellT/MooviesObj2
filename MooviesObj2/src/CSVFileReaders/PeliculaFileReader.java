package CSVFileReaders;

import java.time.LocalDate; 
import java.time.format.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import fileReaderManager.PeliculaData;
import moovies.Pelicula;

public class PeliculaFileReader extends CSVFileReader<PeliculaData> {
	
	/**
     * @param filePath the absolute path of the file to be read.
    */
	
	/*
	 * Variable de instancia para los generos
	 */
	
    public PeliculaFileReader(String filePath) {
        super(filePath);
    }
    /*
     * Metodo a corregir por no poder partir bien el array string
     * 
    private List<String> procesarGeneros(String[] copyOfRange) {
		List<String> generos = new ArrayList<String>();
		generos.add(0, "unknown");
		generos.add(1, "Action");
		generos.add(2, "Adventure");
		generos.add(3, "Animation");
		generos.add(4, "Childrens");
		generos.add(5, "Comedy");
		generos.add(6, "Crime");
		generos.add(7, "Documentary");
		generos.add(8, "Drama");
		generos.add(9, "Fantasy");
		generos.add(10, "Film-Noir");
		generos.add(11, "Horror");
		generos.add(12, "Musical");
		generos.add(13, "Mystery");
		generos.add(14, "Romance");
		generos.add(15, "Sci-Fi");
		generos.add(16, "Thriller");
		generos.add(17, "War");
		generos.add(18, "Western");
		
		List<String> generosDePeli = new ArrayList<String>();
		
		for (int i = 0; i < 19; i++) {
			if (copyOfRange[i] == "1") {
				generosDePeli.add(i,generos.get(i));
			}
		}
		
		return generosDePeli;
	}
    */
    @Override
    protected PeliculaData parseLine(String[] line) {
    	int id = Integer.parseInt(line[0]);
    	String nombre = line[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);
        LocalDate registerDate = LocalDate.parse(line[2], formatter);
    	String idmb = line[3];
    	//Se va a implementar en una Clase Genero
        List<String> generos = this.procesarGeneros(line.substring(4, 19));
        											//No pudimos partir bien el array de strings
        Pelicula pelicula = new Pelicula(nombre, registerDate, idmb, generos);
        return new PeliculaData(id, pelicula);
    }
    
	@Override
    protected String getSeparator() {
        return "\\s+\\|\\s+";
    }

   

}

