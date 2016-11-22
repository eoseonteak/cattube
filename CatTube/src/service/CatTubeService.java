package service;

public class CatTubeService {
	private CatTubeService() {}
	private static CatTubeService instance = new CatTubeService();
	public static CatTubeService getInstance(){ return instance; }
	
	
}
