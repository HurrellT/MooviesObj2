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
        //Get rid of the id, line[0]

        //Format of the string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Convert from String to LocalDate
        LocalDate registerDate = LocalDate.parse(line[4], formatter);

        return new Usuario(line[1], line[2], line[3], registerDate, line[5]);
    }

    @Override
    protected String getSeparator() {
        return ",";
    }
}
