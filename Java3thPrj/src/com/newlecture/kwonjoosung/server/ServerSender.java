package com.newlecture.kwonjoosung.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Sender extends Thread {
	Socket socket;

	Sender(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			PrintWriter output = new PrintWriter(socket.getOutputStream());
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				output.println(data);
				output.flush();
				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}