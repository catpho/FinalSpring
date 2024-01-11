package PersonalProject.FinalSpring.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PersonalProject.FinalSpring.service.BookNavigationService;

@RestController
@RequestMapping("/navigations")

public class BookNavigationsController {
	@GetMapping(path= "/listvisible")
	public String listVisibleNavigations() {
		
		JSONArray navigations = BookNavigationService.listVisibleNavigations();
		
		return navigations.toString();
	}
	
	@GetMapping
	public String listNavigations() {
		
		JSONArray navigations = BookNavigationService.listNavigations();
		
		return navigations.toString();
	}
	
	@GetMapping(path = "/{id}")
	public String getNaviation(@PathVariable("id") int id) {
		JSONObject navigation  = BookNavigationService.getNavigation(id);
		
		return navigation.toString();
		
	}
	
	@PutMapping
	public String updateNavigation(@RequestBody String inputParms) {
		try {
			JSONObject result = BookNavigationService.updateNavigation(new JSONObject(inputParms));
			return result.toString();
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "updateNavigation API failed";
	}
	
	
	@PostMapping
	public String addNavigation(@RequestBody String inputParms) {
		try {
		JSONObject result = BookNavigationService.addNavigation(new JSONObject(inputParms));
		return result.toString();
		
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return "addNavigation API failed";
	}
	
	@DeleteMapping
	public String deleteNavigation(@RequestBody String inputParms) {
		try {
			JSONObject result = BookNavigationService.deleteNavigation(new JSONObject(inputParms));
			return result.toString();
			
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "deleteNavigation API failed";
	}
}