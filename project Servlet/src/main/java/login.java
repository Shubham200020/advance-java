

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataVerify.verifyPerson;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		pw.print("Login");
		String password,user;
		user=request.getParameter("nam");
		password=request.getParameter("pass");
		pw.print(user+" "+password);
		verifyPerson vr;
	
		vr=new verifyPerson(user,password);
		
		pw.print("<br>"+vr.getRoll());
		if(vr.getRoll()==1)
		{
			RequestDispatcher r = request.getRequestDispatcher("adminVerify.html");
			r.forward(request, response);
			
		}
		else if(vr.getRoll()==0)
		{
			pw.print("<br><b>Enter Valid Data</b>");
		}
		else {
			pw.print("<form action='userLogin' method='post' align='center'>");
			pw.print("<input type='hidden' value='"+vr.getRoll()+"' name='id' >");
			pw.print("<input type='submit' value='conform Login'>");
			pw.print("</form>");
			
		}
		
	
	}

}
