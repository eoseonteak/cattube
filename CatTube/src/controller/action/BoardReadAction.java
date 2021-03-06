package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.ReplyDAO;
import service.CatTubeService;
import vo.BoardVO;
import vo.ReplyVO;

public class BoardReadAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/read.jsp";
		
		CatTubeService service = CatTubeService.getInstance();
		ReplyDAO rdao = ReplyDAO.getInstance();
		BoardDAO bdao = BoardDAO.getInstance();
		
		String articleNumStr = request.getParameter("num");
		int articleNum = 0;
		
		if(articleNumStr!=null && articleNumStr.length()>0){
            articleNum = Integer.parseInt(articleNumStr);
        }
		
		BoardVO bvo = service.read(articleNum);
		List<ReplyVO> replyList = rdao.selectBoardReply();
		
		request.setAttribute("bvo", bvo);
		request.setAttribute("replyList", replyList);
		
		List<BoardVO> boardList = bdao.selectAll();
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
