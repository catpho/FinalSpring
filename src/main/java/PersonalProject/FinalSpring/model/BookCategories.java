package PersonalProject.FinalSpring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BookCategories {
	int categoryID;
	int navigationID;
	String categoryName;
	String categoryImage;
	String categoryDescription;
	int categoryOrder;
	int categoryVisible;
	
	public BookCategories() {
		
	}
	public JSONArray listCategories() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".bookcategories " +
					"ORDER BY categoryOrder";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}
	public JSONArray listVisibleCategories() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".bookcategories " +
					"WHERE categoryVisible = '1' ORDER BY categoryOrder";
				

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}

	public JSONObject getCategories() {
	

			//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".bookcategories  " +
					"WHERE categoryID = "+categoryID+"";
			SQLQuery sqlQuery = new SQLQuery();
			sqlQuery.setSqlString(sqlString);
			
			return sqlQuery.getQuery();

	}
	public String updateCategory() {
		
		String message = "Category Updated!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
			String update = "UPDATE "+dbutil.getDatabase() +".bookcategories SET " +
					"navigationID=IfNull(?,navigationID),categoryName=IfNull(NullIf(?,''), categoryName) ,categoryImage=IfNull(NullIf(?,''),categoryImage),"+
					"categoryDescription=IfNull(NullIf(?,''),categoryDescription),"+
					"categoryOrder=IfNull(?,categoryOrder),categoryVisible=IfNull(?,categoryVisible) "+
					"WHERE categoryID="+categoryID+"";

			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setInt(1, navigationID);
			ps.setString(2, categoryName);
			ps.setString(3, categoryImage);
			ps.setString(4, categoryDescription);
			ps.setInt(5, categoryOrder);
			ps.setInt(6,categoryVisible);
	
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	public String addCategory() {
		
		String message = "Category Added!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String add = "INSERT "+dbutil.getDatabase() +".bookcategories " +
					"(navigationID, categoryName, categoryImage, categoryDescription, categoryOrder, categoryVisible) VALUES (?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(add);
			
			ps.setInt(1, navigationID);
			ps.setString(2, categoryName);
			ps.setString(3, categoryImage);
			ps.setString(4, categoryDescription);
			ps.setInt(5, categoryOrder);
			ps.setInt(6,categoryVisible);
	
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	
	public String deleteCategory() {
		
		String message = "Category " +categoryID+ " Deleted!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String delete = "DELETE FROM "+dbutil.getDatabase() +".bookcategories " +
					"WHERE categoryID=" + categoryID;

			PreparedStatement ps = connection.prepareStatement(delete);
	
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	public JSONArray listCatbyNav() {
	
		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
				"FROM "+ dbutil.getDatabase()+ ".bookcategories " +
				"WHERE categoryVisible = '1' AND navigationID = '" + navigationID+ "'ORDER BY categoryOrder";
			

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	
	
	
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getNavigationID() {
		return navigationID;
	}
	public void setNavigationID(int navigationID) {
		this.navigationID = navigationID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public int getCategoryOrder() {
		return categoryOrder;
	}
	public void setCategoryOrder(int categoryOrder) {
		this.categoryOrder = categoryOrder;
	}
	public int getCategoryVisible() {
		return categoryVisible;
	}
	public void setCategoryVisible(int categoryVisible) {
		this.categoryVisible = categoryVisible;
	}
	
}
