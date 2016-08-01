package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DbcPassword {
	 
		 static Connection connection ;
			static Statement stmt;
			public static String sql;
			public static void driverManager(){
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				}catch(ClassNotFoundException cl){
					System.out.println("Class not found");
				} 
			}
			
			public static  Connection getConnection() throws SQLException{
				driverManager();
				String url = "jdbc:oracle:thin:@//localhost:1521/Techno";
				String user = "scott";
				String pwd = "gagan";
				connection = DriverManager.getConnection(url, user, pwd);
				return connection;
			}
			
			public static Statement getStatement(){
				try {
					stmt = getConnection().createStatement();
					System.out.println(stmt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return stmt;
			}
			public static void closeConnection(){
				try {
					connection.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
					}
	 }



	 

}
