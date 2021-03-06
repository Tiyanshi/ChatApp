package com.tiyanshi.chatapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.tiyanshi.chatapp.utils.ConfigReader.getValue;

public interface ChatDAO {

	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(getValue("DRIVER"));
		
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID =getValue("USER_ID");
		final String PASSWORD =getValue("PASSWORD");
		Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if(con != null) {
			System.out.println("Connection created..");
			//con.close();
		}
				
		return con;
	}
	
//	public static void main(String args[]) throws ClassNotFoundException, SQLException
//	{
//		ChatDAO dao = new ChatDAO();
//		dao.createConnection();
//	}
}
