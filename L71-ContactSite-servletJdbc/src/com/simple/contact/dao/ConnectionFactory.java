package com.simple.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.simple.contact.exception.DaoException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:postgresql://localhost/Sample2019DB";
	public static final String USER = "postgres";
	public static final String PASSWORD = "admin";
	public static final String DRIVER_CLASS = "org.postgresql.Driver";

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			System.out.println("!!!!" + e);
		}
	}

	private Connection createConnection() throws DaoException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return connection;
	}

	public static Connection getConnection() throws DaoException {
		return instance.createConnection();
	}

}
