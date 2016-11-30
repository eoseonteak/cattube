package controller.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String token = (String) request.getAttribute("access_token");;// 네이버 로그인 접근 토큰;
		String token = (String) request.getSession().getAttribute("access_token");
		
		String clientId = "HLClh2N5NgHvfAq8lDOI";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "WhNtIn5ggC";//애플리케이션 클라이언트 시크릿값";

	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&access_token=" + token;
	    apiURL += "&service_provider=NAVER";
	    
	    System.out.println("apiURL : " + apiURL);
	    
//	    request.setAttribute("logout", apiURL);
//	    
//	    request.getSession().setMaxInactiveInterval(0);
//	    request.getSession().invalidate();
//	    request.getRequestDispatcher("/board/logout.jsp").forward(request, response);
	    
	    try {
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			BufferedReader br;
			System.out.println("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			conn.disconnect();

			if (responseCode == 200) {
				System.out.println(res.toString());
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher("/board/logout.jsp").forward(request, response);
				
			}
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    

	}

}
