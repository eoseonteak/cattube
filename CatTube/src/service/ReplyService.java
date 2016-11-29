package service;

import dao.ReplyDAO;
import vo.ReplyVO;

public class ReplyService{
	private static ReplyService instance = new ReplyService();
	public static ReplyService getInstance(){
		return instance;
	}
	
	public void insertBoardReply(ReplyVO rvo){
		ReplyDAO dao = ReplyDAO.getInstance();
		
		if(rvo.getReNo()==null||"".equals(rvo.getReNo())){
			dao.insertBoardReply(rvo);
		}
	}
}
