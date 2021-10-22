package com.skillstorm.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import com.skillstorm.beans.House;

public class housesDAO {

	private static final String url = "jdbc:mysql://localhost:3306/houses";
	private static final String username = "root";
	private static final String password = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void create(com.skillstorm.beans.House house) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
	
			
			String sql = "Insert into Houses(streetAddress, city, state, country, postalCode, sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, house.getStreetAddress());
			stmt.setString(2, house.getCity());
			stmt.setString(3, house.getState());
			stmt.setString(4, house.getCountry());
			stmt.setString(5, house.getPostalCode());
			stmt.setInt(6, house.getSqft());
			stmt.setLong(7, house.getEstPrice());
			stmt.setInt(8, house.getNumberBedRooms());
			stmt.setInt(9, house.getNumberBathRooms());
			stmt.setBoolean(10, house.isForSale());
			stmt.setString(11, house.getTypeOfProperty());
			stmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

	}

	public Set<House> FindAll() {

		Set<House> allHouses = new HashSet<>();

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

		try {
			
			String sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				int houseID = rs.getInt(1);
				String streetAdd = rs.getString(2);
				String city = rs.getString(3);
				String state = rs.getString(4);
				String country = rs.getString(5);
				String postalCode = rs.getString(6);
				int sqft = rs.getInt(7);
				long estPrice = rs.getLong(8);
				int numberOfRooms = rs.getInt(9);
				int numberOfBaths = rs.getInt(10);
				boolean forSale = rs.getBoolean(11);
				String typeOfProperty = rs.getString(12);
				House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
				allHouses.add(house);
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return allHouses;

	}

	public Set<House> FindAllForSale() {

		Set<House> allHouses = new HashSet<>();
		int counter = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

		try {
			
			String sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where forSale = true";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				int houseID = rs.getInt(1);
				String streetAdd = rs.getString(2);
				String city = rs.getString(3);
				String state = rs.getString(4);
				String country = rs.getString(5);
				String postalCode = rs.getString(6);
				int sqft = rs.getInt(7);
				long estPrice = rs.getLong(8);
				int numberOfRooms = rs.getInt(9);
				int numberOfBaths = rs.getInt(10);
				boolean forSale = rs.getBoolean(11);
				String typeOfProperty = rs.getString(12);
				House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
				allHouses.add(house);
				counter++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("There are : " + counter + " houses for sale");
		return allHouses;

	}
	 
	public Set<House> FindAllWithCondition(String attr, String operator, int value) {

		Set<House> allHouses = new HashSet<>();

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

		try {
			String sql = "" ;
			
			switch(operator) {
			
			case (">"):
				sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? > ?";
			break;
			
			case ("<"):
				sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? < ?";
			break;
			
			case ("="):
				sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? = ?";
			break;
			
			case ("<>"):
				sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? <> ?";
			break;	
			}
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, attr);
			stmt.setInt(2, value);
		//	stmt = conn.prepareStatement(stmt.toString().replaceAll("\'",""));
			String stmt2 = (stmt.toString().replaceAll("\'",""));
			System.out.println(stmt2);
			String[] temp = stmt2.split(":");
			PreparedStatement stmt3 = conn.prepareStatement(temp[1]);
			System.out.println(stmt3.toString());
			ResultSet rs = stmt3.executeQuery();

			while (rs.next()) {
				
				int houseID = rs.getInt(1);
				String streetAdd = rs.getString(2);
				String city = rs.getString(3);
				String state = rs.getString(4);
				String country = rs.getString(5);
				String postalCode = rs.getString(6);
				int sqft = rs.getInt(7);
				long estPrice = rs.getLong(8);
				int numberOfRooms = rs.getInt(9);
				int numberOfBaths = rs.getInt(10);
				boolean forSale = rs.getBoolean(11);
				String typeOfProperty = rs.getString(12);
				House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
				allHouses.add(house);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allHouses;

	}
	

	public Set<House> FindAllWithCondition(String attr, String operator, String value) {

		Set<House> allHouses = new HashSet<>();

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

		try {
			String sql = "" ;
			switch(operator) {
			
			case ("="):
				
			sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? = ?";
			break;
			case ("<>"):
				sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where ? <> ?";
			
			}
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, attr);
			stmt.setString(2, value);
		//	stmt = conn.prepareStatement(stmt.toString().replaceAll("\'",""));
			String stmt2 = (stmt.toString().replaceAll("\'",""));
			System.out.println(stmt2);
			String[] temp = stmt2.split(":");
			PreparedStatement stmt3 = conn.prepareStatement(temp[1]);
			System.out.println(stmt3.toString());
			ResultSet rs = stmt3.executeQuery();
			while (rs.next()) {
				
				int houseID = rs.getInt(1);
				String streetAdd = rs.getString(2);
				String city = rs.getString(3);
				String state = rs.getString(4);
				String country = rs.getString(5);
				String postalCode = rs.getString(6);
				int sqft = rs.getInt(7);
				long estPrice = rs.getLong(8);
				int numberOfRooms = rs.getInt(9);
				int numberOfBaths = rs.getInt(10);
				boolean forSale = rs.getBoolean(11);
				String typeOfProperty = rs.getString(12);
				House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
				allHouses.add(house);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allHouses;

	}
	
	
	
	
	public House findById(int id) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
		try{

			String sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty from houses where houseid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int houseID = rs.getInt(1);
			String streetAdd = rs.getString(2);
			String city = rs.getString(3);
			String state = rs.getString(4);
			String country = rs.getString(5);
			String postalCode = rs.getString(6);
			int sqft = rs.getInt(7);
			long estPrice = rs.getLong(8);
			int numberOfRooms = rs.getInt(9);
			int numberOfBaths = rs.getInt(10);
			boolean forSale = rs.getBoolean(11);
			String typeOfProperty = rs.getString(12);
			House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
			return house;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
}
	
	

	public House findByStreetAddress(String add) {

		

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "select houseid, streetAddress, city, state, country, postalCode , sqft, estPrice, numberBedRooms, numberBathRooms, forSale, typeOfProperty  from houses where streetAddress = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, add);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int houseID = rs.getInt(1);
			String streetAdd = rs.getString(2);
			String city = rs.getString(3);
			String state = rs.getString(4);
			String country = rs.getString(5);
			String postalCode = rs.getString(6);
			int sqft = rs.getInt(7);
			long estPrice = rs.getLong(8);
			int numberOfRooms = rs.getInt(9);
			int numberOfBaths = rs.getInt(10);
			boolean forSale = rs.getBoolean(11);
			String typeOfProperty = rs.getString(12);
			House house = new House(houseID, streetAdd, city,state, country, postalCode, sqft, estPrice, numberOfRooms, numberOfBaths,forSale, typeOfProperty);
			return house;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	
	
	public void update(House house) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
		
			//this check should be in controller to choose which should be choosed, update or create
			if(checkIfHouseExists(house)) {
			String sql = "Update houses Set streetAddress = ?, city = ?, state = ?, country = ?, postalCode = ?, sqft = ?, estPrice = ?, numberBedRooms = ?, numberBathRooms = ?, forSale = ?, typeOfProperty = ? where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, house.getStreetAddress());
			stmt.setString(2, house.getCity());
			stmt.setString(3, house.getState());
			stmt.setString(4, house.getPostalCode());
			stmt.setInt(5, house.getSqft());
			stmt.setLong(6, house.getEstPrice());
			stmt.setInt(7, house.getNumberBedRooms());
			stmt.setInt(8, house.getNumberBathRooms());
			stmt.setBoolean(9, house.isForSale());
			stmt.setString(10, house.getTypeOfProperty());
			stmt.setInt(11, house.getHouseid());

			stmt.executeUpdate();
			}else{
				create(house);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	

	public boolean checkIfHouseExists(House house) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String checkSQL = "Select houseid from houses where houseid = ?";
			PreparedStatement temp = conn.prepareStatement(checkSQL);
			temp.setInt(1, house.getHouseid());
			ResultSet rs = temp.executeQuery();
			if(!rs.next()) 
				return false;
			
				
	} catch (SQLException e) {

		e.printStackTrace();
	}
		return true;
	}		

	public void delete(House house) {
//check if house exists first
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "Delete from houses where houseid = (?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, house.getHouseid());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

//	/*
//	 * TRANSACTIONS IN JDBC transactions need to be ACID transactions A - Atomic :
//	 * either everything in the transactions executes or nothing does C - Consistent
//	 * : state needs to be consistent before and after the transaction I - Isolated
//	 * : if multiple transactions are at the same time, they shouldn't affect each
//	 * other D - Durable : transactions are persistent in the database, even if the
//	 * system fails afterwards rollback the database if anything goes wrong in jdbc
//	 * : connection object manages your transactions
//	 */
//
//	public List<Movie> batchCreate(List<Movie> movies) throws SQLException{
//		boolean isCommitable = true;
//		List<Movie> newMovies = new LinkedList<>();
//	Connection conn = DriverManager.getConnection(url, username, password);
//	try {
//		conn.setAutoCommit(false);//begin our transaction
//		for(Movie m : movies) {
//			String sql = "insert into movies(title, rating) VALUES(?,?)";
//			PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//			stmt.setString(1, m.getTitle());
//			stmt.setInt(2, m.getRating());
//			stmt.executeUpdate();
//			ResultSet keys = stmt.getGeneratedKeys();
//			keys.next();
//			int movieID = keys.getInt(1);
//			m.setId(movieID);
//			newMovies.add(m);
//		
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		isCommitable = false;
//		conn.rollback();
//		e.printStackTrace();
//	}
//	finally {
//	if(isCommitable) {
//		conn.commit();
//	}
//		conn.close();
//	}
//		
//	return movies;
//}
//	
}
//concat(streetAddress, ' ', city, ' ', state, ' ', country, ' ', postalCode) as Full Address