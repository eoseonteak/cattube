package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;

public class ReplyDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleNum = request.getParameter("articleNum");
		String reNoStr = request.getParameter("reno");
		int reNo = Integer.parseInt(reNoStr);
		
		String url = "CatTubeServlet?command=board_read&num="+articleNum;
		
		ReplyDAO dao = ReplyDAO.getInstance();
		
		dao.deleteBoardReply(reNo);
		
		//new BoardReadAction().execute(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
