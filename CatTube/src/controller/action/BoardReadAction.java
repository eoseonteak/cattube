package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CatTubeService;
import vo.BoardVO;

public class BoardReadAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "read.jsp";
		
		CatTubeService service = CatTubeService.getInstance();
		String articleNumStr = request.getParameter("num");
		int articleNum = 0;
		
		if(articleNumStr!=null && articleNumStr.length()>0){
            articleNum = Integer.parseInt(articleNumStr);
        }
		
		BoardVO bvo = service.read(articleNum);
		
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
