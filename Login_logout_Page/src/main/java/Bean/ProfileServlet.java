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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	response.setContentType("text/html");  
	        PrintWriter pw=response.getWriter();  
	        request.getRequestDispatcher("link.html").include(request, response);  
	        
	        HttpSession session=request.getSession(false);  
	        if(session!=null)
	        {  
	        String name=(String)session.getAttribute("name");  
	          
	        pw.print("Hello, "+name+" Welcome to Profile");  
	        }  
	        else
	        {  
	            pw.print("Please login first");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	
	
	}

}
