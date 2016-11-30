package controller.action;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String clientId = "HLClh2N5NgHvfAq8lDOI";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode("http://70.12.109.95:8280/CatTube/login.do?command=callback", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("state", state);
	    
	    String url = "/board/authorize.jsp";
	    
	    System.out.println("apiURL : " + apiURL);
	    request.setAttribute("authorize", apiURL);
	    
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
