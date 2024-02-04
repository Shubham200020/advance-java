

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataVerify.verifyPerson;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.print("<br><b>Hello</b>");;
		int id;
		String password,conpassword;
		id=Integer.parseInt(request.getParameter("id"));
		
		password=request.getParameter("pass");
		conpassword=request.getParameter("conpass");
		pw.print(id+"  "+password+" "+conpassword);
		verifyPerson vp;
		if(password.equals(conpassword))
		{
			vp=new 	verifyPerson(conpassword,id);
			pw.print("<br><b>Update Password </b><br>");
		}
		else {
			pw.print("<br><b>Password ond conform Password </b><br>");
		}
		
	}

}
