package PersonalProject.FinalSpring.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import PersonalProject.FinalSpring.service.UserService;

public class UsersController {
	@GetMapping
	public String listUsers() {
		
		JSONArray users = UserService.listUsers();
		
		return users.toString();
	}
	
	@GetMapping(path = "/{id}")
	public String getUser(@PathVariable("id") int id) {
		JSONObject user = UserService.getUser(id);
		
		return user.toString();
		
	}
	
	@PutMapping
	public String updateUser(@RequestBody String inputParms) {
		try {
			JSONObject result = UserService.updateUser(new JSONObject(inputParms));
			return result.toString();
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "updateUser API failed";
	}
	
	
	@PostMapping
	public String addUser(@RequestBody String inputParms) {
		try {
			JSONObject result = UserService.addUser(new JSONObject(inputParms));
			return result.toString();
			
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "addUser API failed";
	}
}
