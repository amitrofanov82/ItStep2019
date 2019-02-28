package com.simple.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ConnectionPull {
	public static final String URL = "jdbc:postgresql://localhost/Sample2019DB";
	public static final String USER = "postgres";
	public static final String PASSWORD = "admin";
	private static final int DEF_POOL_SIZE = 10;
	
	private static ConnectionPull instance = new ConnectionPull();
	private List<Connection> availableConnections = new ArrayList<>();
	private List<Connection> usedConnections = new ArrayList<>();
	
	private ConnectionPull() {
		for (int i = 0; i < DEF_POOL_SIZE; i++) {
			availableConnections.add(getConnection());
		}
	}
	
	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connect error");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static synchronized Connection getConnectionFromPull(){
		Connection newConnect = null;
		if (instance.availableConnections.size() == 0) {
			newConnect = instance.getConnection();
		} else {
			newConnect = instance.availableConnections.get(0);
			instance.availableConnections.remove(newConnect);
		}
		instance.usedConnections.add(newConnect);
		return newConnect;
	}
	
	public static synchronized void returnConnectionToPull(Connection connect){
	    if (connect != null) {
	        if (instance.usedConnections.remove(connect)) {
	        	instance.availableConnections.add(connect);
	        } else {
	            throw new NullPointerException("This connection does not exist!");
	        }			
	    }
	}
	

}
