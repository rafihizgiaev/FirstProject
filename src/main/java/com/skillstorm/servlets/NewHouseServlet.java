package com.skillstorm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.beans.House;
import com.skillstorm.data.housesDAO;
import com.fasterxml.jackson.databind.ObjectMapper;




@WebServlet(urlPatterns = "/firstServlet")
public class NewHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	housesDAO DAO = new housesDAO();
    
    public NewHouseServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
        Set<House> allHouses = DAO.FindAll();
		
		
		String json = new ObjectMapper().writeValueAsString(allHouses);
		
		
		response.getWriter().print(json);
		response.setContentType("application/json");
	
		request.setAttribute("allHouses", allHouses);
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		boolean forSale;
		System.out.println("Servlet");
		int houseid;
		 String streetAddress = req.getParameter("streetAddress");
		 String city = req.getParameter("city");
		 String state = req.getParameter("state");
		 String country = req.getParameter("country");
		 String postalCode = req.getParameter("postalCode");
		 int sqft = Integer.parseInt(req.getParameter("sqft"));
		 Long estPrice = (long)Integer.parseInt(req.getParameter("estPrice"));
		 int numberBedRooms = Integer.parseInt(req.getParameter("numberBedRooms"));
		 int numberBathRooms = Integer.parseInt(req.getParameter("numberBathRooms"));
		  if(req.getParameter("forSale").equals("false")){
			   forSale = false;
		  }else {
			   forSale = true;
		  }
		  
		 String typeOfProperty = req.getParameter("typeOfProperty");
	   	
		 House house = new House(streetAddress,city, state, country, postalCode, sqft,estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty);
	
		 DAO.update(house);
		 /*Send to service class the house, the service class deals with the DAO and the House Object
	   	 if(DAO.findByStreetAddress(house.getStreetAddress()) == null){ //need to check city, state, country, and postal
	   		 DAO.create(house);
	   	 }else{
	   	 houseid = DAO.findByStreetAddress(house.getStreetAddress()).getHouseid();
	   	 house.setHouseID(houseid);
	   	 DAO.update(house);//can do just this because it already checks
	   	 }
	
	
		
	*/	
		
		
		
		
		
//		
//		System.out.println(house);
//		PrintWriter writer = response.getWriter();
//        
//        
//        String htmlResponse = "<html>";
//        htmlResponse += "<h2>Your house is: " + house.toString() + "<br/>";          
//        htmlResponse += "</html>";
//         
//    
//        writer.println(htmlResponse);
	}

}
