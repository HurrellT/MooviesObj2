package CSVFileReaders;

import java.time.LocalDate; 
import java.time.format.*;
import java.util.ArrayList;

import moovies.Pelicula;

public class PeliculaFileReader extends CSVFileReader<Pelicula> {
	
	/**
     * @param filePath the absolute path of the file to be read.
     */
    public PeliculaFileReader(String filePath) {
        super(filePath);
    }
    
    @Override
    protected Pelicula parseLine(String[] line) {
    	int id = Integer.parseInt(line[0]);
    	String nombre = line[1];
    	int year = Integer.parseInt(line[2]);
    	int idmb = Integer.parseInt(line[3]);
        ArrayList<String> generos = new ArrayList<String>();
        
       //hay que poner todos los generos en el ArrayList

        return new Pelicula(id, nombre, year, idmb, generos);
    }
    
    @Override
    protected String getSeparator() {
        return ",";
    }

   

}



