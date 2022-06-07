package com.tiyanshi.chatapp.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.tiyanshi.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serversocket;
		ArrayList<ServerWorker> workers = new ArrayList<ServerWorker>();
	
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serversocket = new ServerSocket(PORT);	
		System.out.println("Server started and waiting for client");
		handleClientReq();
	}
	
	public void handleClientReq()throws IOException {
		while(true) {
		Socket socket = serversocket.accept();
//		Per client, a thread
		ServerWorker serverworker = new ServerWorker(socket,this);
		workers.add(serverworker);
		serverworker.start();
		}	
	}
//	public Server() throws IOException{
//		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
//		serversocket = new ServerSocket(PORT);	
//		System.out.println("Server started and waiting for client");
//		Socket socket = serversocket.accept();
//		System.out.println("Client joined");
//		InputStream in = socket.getInputStream();
//		byte arr[] = in.readAllBytes();
//		String str = new String(arr);
//		System.out.println("Message Recieved from client: "+str);
//		
//		in.close();
//	}
	public static void main(String[] args) throws IOException {
		Server server = new Server();
}
}

