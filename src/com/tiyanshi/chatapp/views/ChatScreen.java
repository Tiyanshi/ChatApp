package com.tiyanshi.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tiyanshi.chatapp.networking.Client;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class ChatScreen extends JFrame {

	private JPanel contentPane;
	
	private Client client;
	private JTextArea textArea;
	private JTextField textField;
	
	public static void main(String arg[]) throws UnknownHostException, IOException {
		ChatScreen frame = new ChatScreen();
	}

	public void sendMessage(){
		String message = textField.getText();
		try {
			client.sendMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public ChatScreen() throws UnknownHostException, IOException{
		textArea = new JTextArea();
		client = new Client(textArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 794, 376);
		contentPane.add(scrollPane);
				
		textArea.setBounds(0, 0, 794, 376);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 405, 655, 63);
		contentPane.add(textField);
				
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setBounds(695, 412, 89, 44);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
}
