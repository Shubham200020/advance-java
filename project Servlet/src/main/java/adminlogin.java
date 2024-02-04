

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		
		
		String choice;
		choice=request.getParameter("option");
		switch(choice) {
		case "display":
			ResultSet rs;
			rs=dataVerify.databaseAction.display();
			if(rs==null)
				pw.print("Null");
			try {
				
				pw.print("<table>");
				while(rs.next())
				{
					pw.print("<tr><td>");
					pw.print(rs.getString(1));
					pw.print("</td><td>");
					pw.print(rs.getString(2));
					pw.print("</td><td>");
					pw.print(rs.getString(3));
					pw.print("</td></tr>");
					
				}
				pw.print("</table>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "insert":
			RequestDispatcher i = request.getRequestDispatcher("insert.html");
			i.forward(request, response);
			break;
		case "update":
			RequestDispatcher r = request.getRequestDispatcher("update.html");
			r.forward(request, response);
			break;
		}
		pw.print(choice);
		
		
		
	}

}
