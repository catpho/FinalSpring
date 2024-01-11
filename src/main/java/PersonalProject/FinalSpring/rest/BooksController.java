package PersonalProject.FinalSpring.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PersonalProject.FinalSpring.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@GetMapping
	public String listBooks() {
		
		JSONArray books = BooksService.listBooks();
		
		return books.toString();
	}
	
	@GetMapping(path = "/{id}")
	public String getbook(@PathVariable("id") int id) {
		JSONObject book = BooksService.getBook(id);
		
		return book.toString();
		
	}
	@GetMapping(path = "/listByCategory/{id}")
	public String listbyCategory(@PathVariable("id") int id) {
		JSONArray book = BooksService.listbyCategory(id);
		
		return book.toString();
		
	}
	
	@PutMapping
	public String updateBook(@RequestBody String inputParms) {
		try {
			JSONObject result = BooksService.updateBook(new JSONObject(inputParms));
			return result.toString();
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "updateUser API failed";
	}
	
	
	@PostMapping
	public String addBook(@RequestBody String inputParms) {
		try {
			JSONObject result = BooksService.addBook(new JSONObject(inputParms));
			return result.toString();
			
			}catch(JSONException e) {
				e.printStackTrace();
			}
			return "addUser API failed";
	}
}
