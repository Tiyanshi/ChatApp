package com.tiyanshi.chatapp.views;

import java.awt.Font;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter = 0;
		setSize(600,500);
	//	setLocation(400,100);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CHAT APPLICATION");
		setVisible(true);
		
		JLabel title = new JLabel("Chat Appplication Welcomes you!");
		title.setFont(new Font("Arial", Font.BOLD,26));
		title.setBounds(70,20,500,35);
		
		JLabel count = new JLabel("");
		count.setFont(new Font("Arial", Font.BOLD,20));
		count.setBounds(200,80,100,35);
		
		JButton button = new JButton("Click");
		button.setBounds(70,200,100,35);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				counter++;
				count.setText("Count: " +counter);
			}
		});
		
		Container container = this.getContentPane();
		container.setLayout(null);
		container.add(title);
		container.add(button);
		container.add(count);
		
	}
	public static void main(String[] args) 
	{
		UserView userview = new UserView();

	}

}
