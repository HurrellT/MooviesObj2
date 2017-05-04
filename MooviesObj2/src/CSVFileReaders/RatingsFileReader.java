package CSVFileReaders;

import adapter.RatingIds;

public class RatingsFileReader extends CSVFileReader<RatingIds> {

    /**
     * @param filePath the absolute path of the file to be read.
     */
    public RatingsFileReader(String filePath) {
        super(filePath);
    }

    @Override
    protected RatingIds parseLine(String[] line) {
        //user id | movie id | rating
    	int userId 	= Integer.parseInt(line[0]);
        int movieId = Integer.parseInt(line[2]);
        int rating	= Integer.parseInt(line[3]);
    	
        return new RatingIds(userId, movieId, rating);
    }

    @Override
    protected String getSeparator() {
        return "\\s+\\|\\s+";
    }
}