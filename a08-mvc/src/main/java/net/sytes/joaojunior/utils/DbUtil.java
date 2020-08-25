package net.sytes.joaojunior.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}else {
			String url = "jdbc:mysql://localhost:3306/";
			String dbName ="tjw"; 
			String uname = "root";
			String pwd = "112233-Mysql";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url+dbName,uname,pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}
