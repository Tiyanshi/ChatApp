package com.tiyanshi.chatapp.db;

import java.sql.Statement;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tiyanshi.chatapp.dto.UserDTO;
import com.tiyanshi.chatapp.utils.PasswordEncryption;

public class UserDAO {

	public int register(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, Exception {
		
		Connection conn=null;
		Statement stmt = null;
		
		conn = ChatDAO.createConnection();
		stmt = conn.createStatement();
		
		try {
			String userId = userDTO.getUserid();
			char[] password = userDTO.getPassword();
			String pass = PasswordEncryption.passwordEncrypt(new String(password));
			String query = "Insert into users values('"+userId+"'"+",'"+pass+"'"+",'A')";
			int record = stmt.executeUpdate(query);
			System.out.println("User ID:" + userId);
			System.out.println("Password:" + password);
			return record;
		}
		finally {
			if(stmt !=null) {
				stmt.close();
			}
			if(conn!= null){
				conn.close();
			}
		}

	}
	
	public boolean isLogin(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception{
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "select name from users where name=? and password =?";
		
		try {
			conn = ChatDAO.createConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1,userDTO.getUserid());
			String enPass = PasswordEncryption.passwordEncrypt(new String(userDTO.getPassword()));
			stmt.setString(2,enPass);
			rs = stmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt !=null) {
				stmt.close();
			}
			if(conn!= null){
				conn.close();
			}
		}		
	}
	
}
