package com.maquendi.theBrain.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Service;

import com.maquendi.webservices.MyFirsWS;
import com.maquendi.webservices.MyFirsWS_Service;
import com.maquendi.webservices.Register;
import com.maquendi.webservices.Registrar;
import com.maquendi.webservices.User;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet(description = "this servlet handles user registrations", urlPatterns = { "/RegisterServ" })
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
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
		User user = new User();
		
		
		
		XMLGregorianCalendar XMLCalendar;
		Calendar cal = getDate(formatDate(request.getParameter("nacimiento")));
		if(cal != null){
			XMLCalendar = getXMLCalendar(cal);
			
			if(XMLCalendar != null){
				
				   user.setNombre(request.getParameter("nombre"));
		           user.setApellido(request.getParameter("apellido"));
		           user.setFNacimiento(XMLCalendar);
		           user.setSexo(request.getParameter("sexo"));
		           user.setUserName(request.getParameter("username"));
		           user.setPassword(request.getParameter("password"));
		           user.setTipo(request.getParameter("user_type").charAt(0));
		           String message = ws.registrar(user);
		           
		           System.out.println(message);
		           request.setAttribute("message",message);
		           
		           request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				System.out.println("Error al construir el objeto XMLCalendar");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			   
		}else{
			System.out.println("Error al construir el objeto Calendario ");
			request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	   
		
	    
	}
	
	
	
	public Date getSQLDate(String date){
		
		Calendar cal = this.getDate(formatDate(date));
		
		if(cal != null)
		 return new Date(cal.getTimeInMillis());
		else
		return null;
	}
	
	
	
	private XMLGregorianCalendar getXMLCalendar(Calendar cal){
		XMLGregorianCalendar xmlCalendar = null;
		try {
			DatatypeFactory typefactory = DatatypeFactory.newInstance();
			
			
			
			
			xmlCalendar = typefactory.newXMLGregorianCalendar(new GregorianCalendar(
		    				cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)-1,cal.get(Calendar.DAY_OF_MONTH)));
			
			
			
			
			
			
		} catch (DatatypeConfigurationException e) {
			System.out.println("Metodo : getXMLCalendar: " + e.getMessage());
			e.printStackTrace();
		}
		
		return xmlCalendar;
	}
	
	
	
	
	 private HashMap<String, String> formatDate(String date){
	        
	        HashMap<String,String> map = new HashMap<>(); 
	        if(date.contains("-")){
	        String[] datos = date.split("-");
	          
	          map.put("year", datos[0]);
	          map.put("month",datos[1]);
	          map.put("day",datos[2]);
	          
	        }
	        
	       

	        return map;
	    }
	
	
	 private Calendar getDate(HashMap<String,String> map){
	        Calendar cal = null;
	        if(!map.isEmpty()){
	            cal = Calendar.getInstance();
	            int year = Integer.parseInt((String)map.get("year"));
	            int month = Integer.parseInt((String)map.get("month"));
	            int day = Integer.parseInt((String)map.get("day"));
	            cal.set(year, month, day);
	        }
	        
	        
	        
	        
	        return cal;
	    }
	

}
