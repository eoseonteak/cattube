package controller.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import resources.ClientSecrets;
import resources.LocalServer;

public class CallbackAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		System.out.println("code : " + code);
		System.out.println("state : " + state);
		
		String clientId = ClientSecrets.CLIENT_ID;
	    String clientSecret = ClientSecrets.CLIENT_SECRET;

	    String redirectURI = URLEncoder.encode(LocalServer.LOCAL_SERVER + "/CatTube/login.do?command=callback", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL : " + apiURL);
	    
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
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject)jsonParser.parse(res.toString());
				access_token = jsonObject.get("access_token").toString();
				refresh_token = jsonObject.get("refresh_token").toString();
				String token_type = jsonObject.get("token_type").toString();
				String expires_in = jsonObject.get("expires_in").toString();
			    
				System.out.println(access_token);
				System.out.println(refresh_token);
				System.out.println(token_type);
				System.out.println(expires_in);
				
				HttpSession session = request.getSession();
				session.setAttribute("access_token", access_token);
				
				request.getRequestDispatcher("login.do?command=profile").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
