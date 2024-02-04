package dataVerify;
import java.sql.*;
public class conn {
	public static Connection conne()
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","shubham","shubham");
			} catch (SQLException e) {
				con=null;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
