package CSVFileReaders;

import adapter.RatingData;

public class RatingsFileReader extends CSVFileReader<RatingData> {

    /**
     * @param filePath the absolute path of the file to be read.
     */
    public RatingsFileReader(String filePath) {
        super(filePath);
    }

    @Override
    protected RatingData parseLine(String[] line) {
        //user id | movie id | rating
    	int userId 	= Integer.parseInt(line[0]);
        int movieId = Integer.parseInt(line[2]);
        int rating	= Integer.parseInt(line[3]);
    	
        return new RatingData(userId, movieId, rating);
    }

    @Override
    protected String getSeparator() {
        return "\\s+\\|\\s+";
    }
}