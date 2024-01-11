package PersonalProject.FinalSpring.model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("DBUtil")
@PropertySource("application.properties")
public class DBUtil {
	
    private java.sql.Connection con = null;
    
    @Value("${mariadb.driver}")
    private String driver;
    @Value("${mariadb.url}")
    private String url;
    @Value("${mariadb.serverName}")
    private String serverName;
    @Value("${mariadb.portNumber}")
    private String portNumber;
    @Value("${mariadb.userName}")
    private String userName;
    @Value("${mariadb.password}")
    private String password;
    @Value("${mariadb.database}")
    String database;
    
    public DBUtil() {
    	
    }
    
    public Connection getConnection(){
    	try{
    		String connectionURL = url + serverName+ ":" + portNumber + "/" +database;
	        	
    		Class.forName(driver); 
    		con = java.sql.DriverManager.getConnection(connectionURL,userName,password);
	
	        }catch(Exception e){
	        	e.printStackTrace();
	        	System.out.println("Error Trace in getConnection() : " + e.getMessage());
	       }
	        return con;
	    }

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

    
}

