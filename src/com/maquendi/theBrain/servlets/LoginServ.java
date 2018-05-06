package com.maquendi.theBrain.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maquendi.webservices.MyFirsWS;
import com.maquendi.webservices.MyFirsWS_Service;
import com.maquendi.webservices.ObjectFactory;
import com.maquendi.webservices.User;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet(description = "this servlet handles user signin in", urlPatterns = { "/LoginServ" })
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MyFirsWS_Service service = new MyFirsWS_Service();
        MyFirsWS ws = service.getMyFirsWSPort();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = ws.validateUser(username, password);
		
		
		if(user != null){
	           HttpSession session = request.getSession();
	           session.setAttribute("loggedUser",user);
	           response.sendRedirect("home.jsp");
	           
	       }else{
	           response.sendRedirect("index.jsp");
	       }

	}

}
