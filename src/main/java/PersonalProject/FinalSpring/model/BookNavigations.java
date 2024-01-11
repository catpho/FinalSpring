package PersonalProject.FinalSpring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookNavigations {
	int navigationID;
	String navigationName;
	String navigationURL;
	int navigationVisible;
	int navigationOrder;
	
	public BookNavigations() {
		
	}
	public JSONArray listNavigations() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".booknavigations " +
					"ORDER BY navigationOrder";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}
	public JSONArray listVisibleNavigations() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".booknavigations " +
					"WHERE navigationVisible = '1' ORDER BY navigationOrder";
				

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}

	public JSONObject getNavigation() {
	

			//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".booknavigations  " +
					"WHERE navigationID = "+navigationID+"";
			SQLQuery sqlQuery = new SQLQuery();
			sqlQuery.setSqlString(sqlString);
			
			return sqlQuery.getQuery();

	}
	public String updateNavigation() {
		
		String message = "Navigation Updated!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
			String update = "UPDATE "+dbutil.getDatabase() +".booknavigations SET " +
					"navigationName=IfNull(NullIf(?,''), navigationName) ,navigationURL=IfNull(NullIf(?,''),navigationURL),"+
					"navigationVisible=IfNull(?,navigationVisible) ,navigationOrder=IfNull(?,navigationOrder)"+
					"WHERE navigationID="+navigationID+"";

			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setString(1, navigationName);
			ps.setString(2, navigationURL);
			ps.setInt(3, navigationVisible);
			ps.setInt(4, navigationOrder);
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	public String addNavigation() {
		
		String message = "Navigation Added!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String add = "INSERT "+dbutil.getDatabase() +".booknavigations " +
					"(navigationName, navigationURL, navigationVisible, navigationOrder) VALUES (?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(add);
			
			ps.setString(1, navigationName);
			ps.setString(2, navigationURL);
			ps.setInt(3, navigationVisible);
			ps.setInt(4,navigationOrder);
	
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	
	public String deleteNavigation() {
		
		String message = "Navigation " +navigationID+ " Deleted!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String delete = "DELETE FROM "+dbutil.getDatabase() +".booknavigations " +
					"WHERE navigationID=" + navigationID;

			PreparedStatement ps = connection.prepareStatement(delete);
	
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	public int getNavigationID() {
		return navigationID;
	}

	public void setNavigationID(int navigationID) {
		this.navigationID = navigationID;
	}

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	public String getNavigationURL() {
		return navigationURL;
	}

	public void setNavigationURL(String navigationURL) {
		this.navigationURL = navigationURL;
	}

	public int getNavigationVisible() {
		return navigationVisible;
	}

	public void setNavigationVisible(int navigationVisible) {
		this.navigationVisible = navigationVisible;
	}

	public int getNavigationOrder() {
		return navigationOrder;
	}

	public void setNavigationOrder(int navigationOrder) {
		this.navigationOrder = navigationOrder;
	}


}
