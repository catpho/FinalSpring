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

import PersonalProject.FinalSpring.service.BookCategoryService;

@RestController
@RequestMapping("/categories")
public class BookCategoriesController {
	@GetMapping
	public String listCategories() {
		
		JSONArray categories = BookCategoryService.listCategories();
		
		return categories.toString();
	}
	
	@GetMapping(path = "/{id}")
	public String getCategory(@PathVariable("id") int id) {
		JSONObject category  = BookCategoryService.getCategory(id);
		
		return category.toString();
		
	}
	
	@PutMapping
	public String updateCategory(@RequestBody String inputParms) {
		try {
			JSONObject result = BookCategoryService.updateCategories(new JSONObject(inputParms));
			return result.toString();
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "updateCategories API failed";
			
	}
	
	
	@PostMapping
	public String addCategory(@RequestBody String inputParms) {
		try {
			JSONObject result = BookCategoryService.addCategory(new JSONObject(inputParms));
			return result.toString();
			
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "addCategory API failed";
	}
	
	@DeleteMapping
	public String deleteCategory(@RequestBody String inputParms) {
		try {
			JSONObject result = BookCategoryService.deleteCategory(new JSONObject(inputParms));
			return result.toString();
			
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "deleteCategory API failed";
	}
}

