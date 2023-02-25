package com.icsfs.training.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyJDBCConnection {

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "admin";
		String password = "admin123";

		return DriverManager.getConnection(url, user, password);
	}

	
}