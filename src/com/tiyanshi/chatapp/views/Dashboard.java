package com.tiyanshi.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	public Dashboard(String message) throws UnknownHostException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 528);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("Hi there, WELCOME!!");
		lblNewLabel.setBackground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Brush Script MT", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setBounds(31, 207, 309, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Assets/chat-application.png")));
		lblNewLabel_1.setBounds(331, 0, 469, 491);
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.info);
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBounds(0, 0, 126, 38);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Click to begin!! ");
		menuBar.add(mnNewMenu);
		mnNewMenu.setBackground(SystemColor.info);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.setForeground(new Color(102, 0, 0));
		
		JButton mnNewMenu_1 = new JButton("Start Chat");
		mnNewMenu_1.setForeground(new Color(102, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mnNewMenu_1);
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					chat();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
		public void chat() throws UnknownHostException, IOException {
			setVisible(false);
			ChatScreen client = new ChatScreen();
			client.setVisible(true);
		}

}
