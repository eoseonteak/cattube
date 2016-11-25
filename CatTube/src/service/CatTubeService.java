package service;

import dao.BoardDAO;
import vo.BoardVO;

public class CatTubeService {
	private CatTubeService() {}
	private static CatTubeService instance = new CatTubeService();
	public static CatTubeService getInstance(){ return instance; }
	
	BoardDAO dao = BoardDAO.getInstance();
	
	public BoardVO read(int articleId){
    	BoardVO result = null;
    	if(dao.updateReadCount(articleId)>0){
    		// 글번호가 유효한지 확인하는 조건문
    		result = dao.selectNum(articleId);
    	}
    	return result;
    }
}
