package PersonalProject.FinalSpring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Books {
	
	int bookID;
	String bookISBN;
	String bookTitle;
	String bookAuthor;
	String bookDescription;
	int bookVisible;
	int categoryID;
	String bookImage;
	
	public Books() {
		
	}
	public JSONArray listBooks() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".books " ;

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}
	public JSONArray listbyCategory() {

		//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
		String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".books " +
					"WHERE categoryID=" + categoryID;

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();

	}
	
	 
	public String updateBook() {
			
		String message = "Book Updated!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
			String updateBook = "UPDATE "+dbutil.getDatabase() +".books SET " +
					"bookISBN=IfNull(NullIf(?,''), bookISBN) ,bookTitle=IfNull(NullIf(?,''),bookTitle),"+
					"bookAuthor=IfNull(NullIf(?,''),bookAuthor),bookDescription=IfNull(NullIf(?,''),bookDescription),bookVisible=IfNull(?,bookVisible),categoryID=IfNull(?,categoryID),bookImage=IfNull(NullIf(?,''),bookImage) "+
					"WHERE bookID="+bookID+"";

			PreparedStatement ps = connection.prepareStatement(updateBook);
			
			ps.setString(1, bookISBN);
			ps.setString(2, bookTitle);
			ps.setString(3, bookAuthor);
			ps.setString(4, bookDescription);
			ps.setInt(5, bookVisible);
			ps.setInt(6, categoryID);
			ps.setString(7, bookImage);
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}
	
	
	public JSONObject getBook() {
	

			//Connection connection = DBUtil.getConnection();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("PersonalProject.FinalSpring");
		context.refresh();
		DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			String sqlString = "SELECT * " +
					"FROM "+ dbutil.getDatabase()+ ".books  " +
					"WHERE bookID = "+bookID+"";
			SQLQuery sqlQuery = new SQLQuery();
			sqlQuery.setSqlString(sqlString);
			
			return sqlQuery.getQuery();

	}

	
	public String addBook() {
		
		String message = "Book Added!";
		
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("PersonalProject.FinalSpring");
			context.refresh();
			DBUtil dbutil = context.getBean("DBUtil", DBUtil.class);
			Connection connection = dbutil.getConnection();
	
			String addBook = "INSERT "+dbutil.getDatabase() +".books " +
					"(bookISBN, bookTitle, bookAuthor, bookDescription, bookVisible, categoryID, bookImage) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(addBook);
			
			
			ps.setString(1,bookISBN);
			ps.setString(2, bookTitle);
			ps.setString(3, bookAuthor);
			ps.setString(4, bookDescription);
			ps.setInt(5, bookVisible);
			ps.setInt(6, categoryID);
			ps.setString(7, bookImage);
			ps.executeUpdate();
			
			try {if (ps!=null) ps.close();} catch (Exception e) {};
			try {if (connection !=null) connection.close();} catch (Exception e) {};
			
			
	}catch (Exception e ) {
		System.out.println(e.getMessage());
	}
			return message;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookVisible() {
		return bookVisible;
	}

	public void setBookVisible(int bookVisible) {
		this.bookVisible = bookVisible;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
}
