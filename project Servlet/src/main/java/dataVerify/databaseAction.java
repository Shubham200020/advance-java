package dataVerify;
import java.sql.*;
public class databaseAction extends loginInfo {
	
	public static ResultSet display() {
		ResultSet rs=null;
		Statement st;
		Connection con;
		loginInfo li = null;
		con=dataVerify.conn.conne();
		try {
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select ROLL_NO,USERNAME, PASSWORD from login");
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet search(loginInfo l)
	{
		ResultSet rs=null;
		PreparedStatement ps;
		Connection conn;
		conn=dataVerify.conn.conne();
		try {
			ps=conn.prepareStatement("select * from login where ROLL_NO = ?");
			ps.setInt(1, l.getRoll());
			rs=ps.executeQuery();
		} catch (SQLException e) {
			rs=null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void insert(loginInfo l)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		conn=dataVerify.conn.conne();
		try {
			ps=conn.prepareStatement("insert into login(ROLL_NO,USERNAME,PASSWORD) values(?,?,?)");
			ps.setInt(1, l.getRoll());
			ps.setString(2,l.getUsername());
			ps.setString(3,l.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			ps=null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static loginInfo verifyLogin(loginInfo l)
	{
		loginInfo li=null;
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs=null;
		conn=dataVerify.conn.conne();
		try {
			ps=conn.prepareStatement(" select USERNAME,PASSWORD,ROLL_NO from login where USERNAME = ? and PASSWORD= ?");
			ps.setString(1, l.getUsername());
			ps.setString(2,l.getPassword());
			rs=ps.executeQuery();
			while(rs.next())
			{
				li=new loginInfo();
				li.setPassword(rs.getString(2));
				li.setUsername(rs.getString(1));
				li.setRoll(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	public static void update(loginInfo l)
	{
		Connection conn;
		PreparedStatement ps;
		conn=dataVerify.conn.conne();
		try {
			ps=conn.prepareStatement("UPDATE login set PASSWORD = ? where  ROLL_NO = ?");
			ps.setString(1,l.getPassword());
			ps.setInt(2, l.getRoll());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
