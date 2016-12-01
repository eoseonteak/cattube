package controller.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("access_token");
		
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer result = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                result.append(inputLine);
            }
            br.close();
            con.disconnect();
            
			if (responseCode == 200) {
				System.out.println(result.toString());

				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = null;
				try {
					jsonObject = (JSONObject) jsonParser.parse(result.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				JSONObject tokenObj = (JSONObject) jsonObject.get("response");
				String email = (String) tokenObj.get("email");
				String nickname = (String) tokenObj.get("nickname");
				String profile_image = (String) tokenObj.get("profile_image");
				String age = (String) tokenObj.get("age");
				String gender = (String) tokenObj.get("gender");
				String id = (String) tokenObj.get("id");
				String name = (String) tokenObj.get("name");
				String birthday = (String) tokenObj.get("birthday");

				System.out.println(email);
				System.out.println(nickname);
				System.out.println(profile_image);
				System.out.println(age);
				System.out.println(gender);
				System.out.println(id);
				System.out.println(name);
				System.out.println(birthday);
				
				request.getSession().setAttribute("nickname", nickname);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
            
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
