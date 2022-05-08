package com.udemy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost/test_db";
	private final static String USERNAME = "balazs";
	private final static String PASSWORD = "balazs";

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();

			String sql = "INSERT INTO STUDENT(id,first_name,last_name,email,age) VALUES(1,'Kevin','Malon','malon@gmail.com',45)"; 			
			
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
