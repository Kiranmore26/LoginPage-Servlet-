package Bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 	response.setContentType("text/html");  
	        PrintWriter pw=response.getWriter();  
	        request.getRequestDispatcher("link.html").include(request, response);  	
	        
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");   
	        
	        if(password.equals("admin123"))
	        {  
	            pw.print("Welcome, "+name);  
	            HttpSession session=request.getSession();  
	            session.setAttribute("name",name);  
	        }  
	        else
	        {  
	                pw.print("Sorry, username or password error!");  
	                request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	}

}
