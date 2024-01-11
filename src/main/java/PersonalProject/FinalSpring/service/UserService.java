package PersonalProject.FinalSpring.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PersonalProject.FinalSpring.model.Users;

public class UserService {
	public static JSONArray listUsers() {
			
			JSONArray users = new JSONArray();
			
			Users user = new Users();
			users = user.listUsers();
			
			return users;
		}
	
	
	public static JSONObject updateUser(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			int userID = inputParms.getInt("userID");
			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String username = inputParms.getString("username");
			String password = inputParms.getString("password");
			int active = inputParms.getInt("active");
			
			Users user = new Users();
			user.setUserID(userID);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			user.setActive(active);
			
			
			message = user.updateUser();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static JSONObject getUser(int id) {
		JSONObject userJO = new JSONObject();
		
		Users user = new Users();
		user.setUserID(id);
		
		userJO = user.getUser();
		
		return userJO;
	}
	public static JSONObject addUser(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {

			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String username = inputParms.getString("username");
			String password = inputParms.getString("password");
			int active = inputParms.getInt("active");
			
			Users user = new Users();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			user.setActive(active);
			
			message = user.addUser();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}

