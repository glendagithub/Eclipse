package api_tests;

import api.utils.APIUtils;
import api.utils.OAuthUtils;
import api.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2APITest {
	public static void main(String[] args) {
		// 🔹 Get API Base URL from properties

		RestAssured.baseURI = ConfigManager.getProperty("protocol") + "://" + 
				ConfigManager.getProperty("hostname")
				+ ConfigManager.getProperty("basepath");

		
		// 🔹 Get OAuth Token
		String token = OAuthUtils.getOAuthToken();
		System.out.println("🟢 OAuth Token: " + token);
		String requestBody="{\r\n"
				+ "    \"short_description\": \"My laptop problem\"\r\n"
				+ "}";
		
		// 🔹 Create Resource (POST)
		Response postResponse = APIUtils.sendPostWithOAuth("incident", token, requestBody);

		System.out.println("🟢 POST Response: " );
		postResponse.prettyPrint();
		System.out.println("🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢 🟢");

		

	}
}
