package adapter;

public class RatingData {

	/*
	 * Colaboradores internos
	 */
	
	private int userId;
	
	private int movieId;
	
	private int rating;
	
	/*
	 * Constructor de RatingData
	 */
	
	public RatingData(int uId, int mId, int score) {
		
		this.userId 	= uId;
		this.movieId 	= mId;
		this.rating		= score;
		
	}
	
	/*
	 * Getters
	 */
	
	public int getUserId() {
		return userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public int getRating() {
		return rating;
	}
	
}
