package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReplyService;
import vo.ReplyVO;

public class BoardReplyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleNum = request.getParameter("articleNum");
		String writer = request.getParameter("writer");
		String memo = request.getParameter("rememo");
		
		String url = "CatTubeServlet?command=board_read&num="+articleNum;
		
		ReplyVO rvo = new ReplyVO();
		rvo.setArticleNum(articleNum);
		rvo.setReWriter(writer);
		rvo.setReMemo(memo);
		
		ReplyService service = ReplyService.getInstance();
		service.insertBoardReply(rvo);
	
		//new BoardReadAction().execute(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
