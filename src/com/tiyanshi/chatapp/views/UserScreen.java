package com.tiyanshi.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.SQLException;
import com.tiyanshi.chatapp.db.UserDAO;
import com.tiyanshi.chatapp.dto.UserDTO;

public class UserScreen extends JFrame{
	private JPasswordField password_field;
	private JTextField user_id;

	public UserScreen() {
		setTitle("Chat Application Window");
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBackground(SystemColor.info);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Chat Application Welcomes You!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(180, 28, 339, 57);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Enter User Id:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(136, 132, 153, 41);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Enter Password:\r\n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(136, 227, 184, 41);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setForeground(SystemColor.info);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(103, 358, 153, 57);
		getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegister.setForeground(SystemColor.info);
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnRegister.setBackground(new Color(0, 255, 0));
		btnRegister.setBounds(453, 358, 153, 57);
		getContentPane().add(btnRegister);
		
		password_field = new JPasswordField();
		password_field.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password_field.setBackground(new Color(255, 255, 225));
		password_field.setBounds(333, 227, 230, 43);
		getContentPane().add(password_field);
		
		user_id = new JTextField();
		user_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user_id.setForeground(Color.BLACK);
		user_id.setBackground(SystemColor.info);
		user_id.setHorizontalAlignment(SwingConstants.CENTER);
		user_id.setBounds(333, 132, 230, 41);
		getContentPane().add(user_id);
		user_id.setColumns(10);
		setBounds(100, 100, 723, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	UserDAO userDAO = new UserDAO();
	public void register(){
		String userid = user_id.getText();
//		String password = password_field.getText();
		char[] password = password_field.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);
		try{
			int res = userDAO.register(userDTO);
			if(res >0) {
				JOptionPane.showMessageDialog(this, "Registration Successful");
//				System.out.println("Registration successful");	
			}else {
				JOptionPane.showMessageDialog(this, "Registration unSuccessful");
//				System.out.println("Registration unsuccessful");	
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println("UserID: "+ userid + "Password:"+password.toString);
	}
	
	public void login(){
		String userid = user_id.getText();
		char[] password = password_field.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message ="";
			if(userDAO.isLogin(userDTO)) {
				message =  "Welcome: "+userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				Dashboard dashboard = new Dashboard(message);
				dashboard.setVisible(true);
			}
			else {
				message =  "Invalid UserId or Password";
				JOptionPane.showMessageDialog(this, message);;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
	}
}
