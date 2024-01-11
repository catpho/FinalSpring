package PersonalProject.FinalSpring.service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import PersonalProject.FinalSpring.model.Books;
public class BooksService {
	public static JSONArray listBooks() {
		
		JSONArray results = new JSONArray();
		
		Books book = new Books();
		results = book.listBooks();
		
		return results;
	}
	public static JSONArray listbyCategory(int categoryID) {
		
		JSONArray books = new JSONArray();
		
		Books book = new Books();
		book.setCategoryID(categoryID);
		books = book.listbyCategory();
		
		return books;
	}
	public static JSONObject updateBook(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			int bookID = inputParms.getInt("bookID");
			String bookTitle = inputParms.getString("bookTitle");
			String bookAuthor = inputParms.getString("bookAuthor");
			String bookDescription = inputParms.getString("bookDescription");
			int bookVisible = inputParms.getInt("bookVisible");
			int categoryID = inputParms.getInt("categoryID");
			String bookImage = inputParms.getString("bookImage");
			
			Books book = new Books();
			book.setBookID(bookID);
			book.setBookTitle(bookTitle);
			book.setBookAuthor(bookAuthor);
			book.setBookDescription(bookDescription);
			book.setBookVisible(bookVisible);
			book.setCategoryID(categoryID);
			book.setBookImage(bookImage);

			message = book.updateBook();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static JSONObject getBook(int id) {
		JSONObject JO = new JSONObject();
		
		Books book = new Books();
		book.setBookID(id);

		JO = book.getBook();
		
		return JO;
	}
	public static JSONObject addBook(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			String bookISBN = inputParms.getString("bookISBN");
			String bookTitle = inputParms.getString("bookTitle");
			String bookAuthor = inputParms.getString("bookAuthor");
			String bookDescription = inputParms.getString("bookDescription");
			int bookVisible = inputParms.getInt("bookVisible");
			int categoryID = inputParms.getInt("categoryID");
			String bookImage = inputParms.getString("bookImage");
			
			Books book = new Books();
			book.setBookISBN(bookISBN);
			book.setBookTitle(bookTitle);
			book.setBookAuthor(bookAuthor);
			book.setBookDescription(bookDescription);
			book.setBookVisible(bookVisible);
			book.setCategoryID(categoryID);
			book.setBookImage(bookImage);

			message = book.addBook();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}	

}

