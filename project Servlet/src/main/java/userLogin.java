

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataVerify.loginInfo;

/**
 * Servlet implementation class userLogin
 */
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter pw;
		pw=response.getWriter();
		pw.print("<b>User Login</b><br>");
		String rl;
		 
		rl=request.getParameter("id");
	
		pw.print("<form action='userLogin' method='post'>");
		pw.print("<select name='option'>"+
				"<option value='update'>Update Password</option>"
				
				+ "	<option value='display'>Display</option>"
				+ "	</select><br>");
		pw.print("<input type='hidden' value='"+rl+"' name='id' >");
		pw.print("<input type='submit' >");
		pw.print("</form>");
		response.setContentType("text/html");
		String choice;
		choice=request.getParameter("option");
		pw.print("<br><b>"+choice+"</b><br>");
		switch(choice)
		{
		case "update":
			
			pw.print("<form action=\"update\" method=\"post\" align=\"center\">");
			pw.print("<input type='hidden' value='"+rl+"' name='id' >");
			pw.print("<label for='pass'>Enter Password</label>");
			pw.print("<input type='text' id='pass' name='pass' placeholder='Enter Password'><br>");
			pw.print("<label >Conform Password</label>");
			pw.print("<input type='password' id=\"conpass\" name='conpass' placeholder=\"Conform Password\">");
			pw.print("<input type=\"submit\" value=\"Update User\">");
			
			pw.print("</form>");
			
			break;
		case "display":
			ResultSet rs;
			loginInfo li=new loginInfo();
			int id;
			id=Integer.parseInt(rl);
			li.setRoll(id);
			rs=dataVerify.databaseAction.search(li);
			pw.print("<table border='1px' align='center'>");
			try {
				pw.print("<tr><th>Id</th>");
				pw.print("<th>Username</th>");
				pw.print("<th>Password</th>");
				pw.print("</tr>");
				while(rs.next()) {
				pw.print("<tr><td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("</tr>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.print("</table>");
			break;
		}
	}

}
