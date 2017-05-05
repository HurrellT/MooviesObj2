package fileReaderManager;

public class AmigosData {

	/*
	 * Colaboradores internos
	 */
	
	private int user1;
	
	private int user2;
	
	/*
	 * Constructor de AmigosData
	 */
	
	public AmigosData(int userA, int userB) {
		
		this.user1 = userA;
		this.user2 = userB;
	}
	
	/*
	 * Getters
	 */
	
	public int getAmigoId1(){
		return user1;
	}
	
	public int getAmigoId2(){
		return user2;
	}

}
