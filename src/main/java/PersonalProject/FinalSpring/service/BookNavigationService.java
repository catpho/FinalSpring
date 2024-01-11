package PersonalProject.FinalSpring.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PersonalProject.FinalSpring.model.BookCategories;
import PersonalProject.FinalSpring.model.BookNavigations;

public class BookNavigationService {
		
		public static JSONArray listVisibleNavigations() {
			
			JSONArray navigations = new JSONArray();
			JSONArray categories = new JSONArray();
			
			BookNavigations navigation = new BookNavigations();
			navigations = navigation.listVisibleNavigations();
			
			for (int i =0 ; i < navigations.length(); i++) {
				BookCategories category = new BookCategories();
				
				try {
				category.setNavigationID(navigations.getJSONObject(i).getInt("navigationID"));	
				categories = category.listCatbyNav();
				
				if(!categories.isNull(0)) {
					navigations.getJSONObject(i).put("categories", categories);
				}
				
				
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			return navigations;
		}
		
	
		public static JSONArray listNavigations() {
			
			JSONArray results = new JSONArray();
			
			BookNavigations navigation = new BookNavigations();
			results = navigation.listNavigations();
			
			return results;
		}
		
		public static JSONObject updateNavigation(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
				int navigationID = inputParms.getInt("navigationID");
				String navigationName = inputParms.getString("navigationName");
				String navigationURL = inputParms.getString("navigationURL");
				int navigationVisible = inputParms.getInt("navigationVisible");
				int navigationOrder = inputParms.getInt("navigationOrder");
				
				BookNavigations navigation = new BookNavigations();
				navigation.setNavigationID(navigationID);
				navigation.setNavigationName(navigationName);
				navigation.setNavigationURL(navigationURL);
				navigation.setNavigationVisible(navigationVisible);
				navigation.setNavigationOrder(navigationOrder);
				
				
				
				message = navigation.updateNavigation();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		public static JSONObject getNavigation(int id) {
			JSONObject JO = new JSONObject();
			
			BookNavigations navigation = new BookNavigations();
			navigation.setNavigationID(id);
			
			JO = navigation.getNavigation();
			
			return JO;
		}
		public static JSONObject addNavigation(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
				String navigationName = inputParms.getString("navigationName");
				String navigationURL = inputParms.getString("navigationURL");
				int navigationVisible = inputParms.getInt("navigationVisible");
				int navigationOrder = inputParms.getInt("navigationOrder");
				
				BookNavigations navigation = new BookNavigations();
				navigation.setNavigationName(navigationName);
				navigation.setNavigationURL(navigationURL);
				navigation.setNavigationVisible(navigationVisible);
				navigation.setNavigationOrder(navigationOrder);
				
				
				
				message = navigation.addNavigation();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		
		public static JSONObject deleteNavigation(JSONObject inputParms) {
			String message = "";
			
			JSONObject result = new JSONObject();
			
			try {
			
				int navigationID = inputParms.getInt("navigationID");
				
				BookNavigations navigation = new BookNavigations();
				navigation.setNavigationID(navigationID);

				message = navigation.deleteNavigation();
			
			
				result.put("message", message);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
}

