package CSVFileReaders;

import java.time.LocalDate; 
import java.time.format.*;
import moovies.Usuario;

public class UsuarioFileReader extends CSVFileReader<Usuario> {

    /**
     * @param filePath the absolute path of the file to be read.
    */
    public UsuarioFileReader(String filePath) {
        super(filePath);
    }

    @Override
    protected Usuario parseLine(String[] line) {
    	int id = Integer.parseInt(line[0]);
    	String nyap = line[5] + line[6];
    	int edad = Integer.parseInt(line[1]);
    	//El line[2] no se necesita, es el genero
    	String ocupacion = line[3];
    	int codPos = Integer.parseInt(line[4]);

        return new Usuario(id, nyap, edad, ocupacion, codPos);
    }

    @Override
    protected String getSeparator() {
        return "|";
    }
}

