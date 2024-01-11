package PersonalProject.FinalSpring.model;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Users {

	int userID;
	String firstName;
	String lastName;
	String email;
	String username;
	String password;
	int active;
	Date userCreateDate;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public Users() {
		
	}
	public JSONArray listUsers() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".users " ;

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}
 
	public String updateUser() {
			
		String message = "User updated!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
			String updateUser = "UPDATE "+dbutil.getDatabase() +".users SET " +
					"firstName=IfNull(NullIf(?,''), firstName), lastName=IfNull(NullIf(?,''), lastName), email=IfNull(NullIf(?,''),email),"+
					"username=IfNull(NullIf(?,''),username),password=IfNull(NullIf(?,''),password),active=IfNull(?,active) "+
					"WHERE userID="+userID+"";

			PreparedStatement ps = connection.prepareStatement(updateUser);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, active);
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	
	
	public JSONObject getUser() {
	

			//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".users  " +
					"WHERE userID = "+userID+"";
			SQLQuery sqlQuery = new SQLQuery();
			sqlQuery.setSqlString(sqlString);
			
			return sqlQuery.getQuery();

	}

	
	public String addUser() {
		
		String message = "User Added!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String addArticle = "INSERT "+dbutil.getDatabase() +".users " +
					"(firstName, lastName, email, username, password, active, userCreateDate) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(addArticle);
			
			Date date = new Date();
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, active);
			ps.setTimestamp(7,new java.sql.Timestamp(date.getTime()));
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	



	
	
}
