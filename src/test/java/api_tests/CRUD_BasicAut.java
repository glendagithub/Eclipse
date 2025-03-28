package api_tests;

import api.config.ConfigManager;
import api.utils.APIUtils;
import io.restassured.response.Response;

public class CRUD_BasicAut {
	public static void main(String[] args) {

		String username = ConfigManager.getProperty("username");
		String password = ConfigManager.getProperty("password");

		// 🔹 Create a Resource (POST)
		Response postResponse = APIUtils.sendPostWithBasicAuth("incident", username, password,
				"{\r\n" + "    \"short_description\": \"My laptop problem\"\r\n" + "}");
		// Modify the body as needed
		System.out.println("🟢  POST Response: 🟢");
		postResponse.prettyPrint();

		
	}

}
