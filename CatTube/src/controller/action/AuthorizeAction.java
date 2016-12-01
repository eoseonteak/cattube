package controller.action;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resources.ClientSecrets;
import resources.LocalServer;

public class AuthorizeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String clientId = ClientSecrets.CLIENT_ID;
	    String redirectURI = URLEncoder.encode(LocalServer.LOCAL_SERVER + "/CatTube/login.do?command=callback", "UTF-8");
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
