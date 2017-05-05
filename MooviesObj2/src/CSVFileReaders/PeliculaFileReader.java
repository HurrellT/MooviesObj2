package CSVFileReaders;

import java.time.LocalDate; 
import java.time.format.*;
import java.util.ArrayList;
import java.util.Locale;

import fileReaderManager.PeliculaData;
import moovies.Pelicula;

public class PeliculaFileReader extends CSVFileReader<PeliculaData> {
	
	/**
     * @param filePath the absolute path of the file to be read.
    */
    public PeliculaFileReader(String filePath) {
        super(filePath);
    }
    
    @Override
    protected PeliculaData parseLine(String[] line) {
    	int id = Integer.parseInt(line[0]);
    	String nombre = line[1];
    	//Date year = Date(line[2]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);
        LocalDate registerDate = LocalDate.parse(line[2], formatter);
    	String idmb = line[3];
        ArrayList<String> generos = new ArrayList<String>();
        
       //hay que poner todos los generos en el ArrayList
        Pelicula pelicula = new Pelicula(nombre, registerDate, idmb, generos);
        //HAY QUE HACER UN MAP CON ID y PELICULA (EL OBJETO)
        return new PeliculaData(id, pelicula);
    }
    
    @Override
    protected String getSeparator() {
        return "\\s+\\|\\s+";
    }

   

}

