package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;

public class MemberLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "login_result.jsp";
		
		MemberService service = MemberService.getInstance();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(service.login(id, password)==true){
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
