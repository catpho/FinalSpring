package PersonalProject.FinalSpring.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PersonalProject.FinalSpring.model.BookCategories;

public class BookCategoryService {
		public static JSONArray listCategories() {
			
			JSONArray results = new JSONArray();
			
			BookCategories category = new BookCategories();
			results = category.listCategories();
			
			return results;
		}
		
		public static JSONObject updateCategories(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
				int categoryID = inputParms.getInt("categoryID");
				int navigationID = inputParms.getInt("navigationID");
				String categoryName = inputParms.getString("categoryName");
				String categoryImage = inputParms.getString("categoryImage");
				String categoryDescription = inputParms.getString("categoryDescription");
				int categoryOrder = inputParms.getInt("categoryOrder");
				int categoryVisible = inputParms.getInt("categoryVisible");
				
				BookCategories category = new BookCategories();
				category.setCategoryID(categoryID);
				category.setNavigationID(navigationID);
				category.setCategoryName(categoryName);
				category.setCategoryImage(categoryImage);
				category.setCategoryDescription(categoryDescription);
				category.setCategoryOrder(categoryOrder);
				category.setCategoryVisible(categoryVisible);

				message = category.updateCategory();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		public static JSONObject getCategory(int id) {
			JSONObject JO = new JSONObject();
			
			BookCategories category = new BookCategories();
			category.setCategoryID(id);

			JO = category.getCategories();
			
			return JO;
		}
		public static JSONObject addCategory(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
				int navigationID = inputParms.getInt("navigationID");
				String categoryName = inputParms.getString("categoryName");
				String categoryImage = inputParms.getString("categoryImage");
				String categoryDescription = inputParms.getString("categoryDescription");
				int categoryOrder = inputParms.getInt("categoryOrder");
				int categoryVisible = inputParms.getInt("categoryVisible");
				
				BookCategories category = new BookCategories();
				category.setNavigationID(navigationID);
				category.setCategoryName(categoryName);
				category.setCategoryImage(categoryImage);
				category.setCategoryDescription(categoryDescription);
				category.setCategoryOrder(categoryOrder);
				category.setCategoryVisible(categoryVisible);

				message = category.addCategory();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		
		public static JSONObject deleteCategory(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
			
				int categoryID = inputParms.getInt("categoryID");
				
				BookCategories category = new BookCategories();
				category.setCategoryID(categoryID);

				message = category.deleteCategory();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
}
