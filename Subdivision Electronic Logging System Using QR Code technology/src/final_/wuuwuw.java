package final_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class wuuwuw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("http://capstonethesis.000webhostapp.com:3306/id18052798_databasethesis1?useTimezone=true&serverTimezone=UTC", "id18052798_databasethesis12", "u4s@=*jV/k8z9(8L");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
