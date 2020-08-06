package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersDataInterface {

	//TODO: these need to be changed based on individual connection username and password
	public static final String dbURL = "jdbc:postgresql://localhost:5432/postgres"; //this is the string for postgres
	public static final String username = "postgres"; //admin username when setting up postgres
	public static final String password = "root"; //password for postgres connection
			
	/**
	 * retrieves a connection to the current database
	 * @return the given connection to use for the dao methods, must be closed manually outside of this method.
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connection Made!");
		}
		catch(SQLException ex) {
			System.out.println("Failure! " + ex.getMessage());
		}
		return conn;
	}
	
	// CRUD pattern methods
	public Order get(String orderId);
	List<Order> getAll();
	void save(Order order);
	void update(String orderId, Order order);
	void delete(Order order);
}

