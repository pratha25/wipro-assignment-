package PS_lib;



	
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/BookStore_db";
	    private static final String USER = "root";
	    private static final String PASSWORD = "mysqlpass00";

	    public static Connection getConnection() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}