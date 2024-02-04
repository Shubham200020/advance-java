

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataVerify.loginInfo;
import dataVerify.verifyPerson;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
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
		response.setContentType("text/html");
		int id;
		String username,pass,conPass;
		id=Integer.parseInt(request.getParameter("id"));
		username=request.getParameter("name");
		pass=request.getParameter("pass");
		conPass=request.getParameter("conpass");
		if(pass.equals(conPass))
		{
			loginInfo l;
			verifyPerson vl = null;
			
			vl= new verifyPerson(id,username,conPass);
			pw.print("<br>Insert Success fully");
		}
		else {
			pw.print("<br>Password and conform Password Not Match");
		}
		
	}

}
