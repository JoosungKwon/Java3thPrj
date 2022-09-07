package com.newlecture.ch3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Receiver extends Thread {
	Socket socket;

	Receiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				if(data==null)
					break;
				 
				System.out.println("사용자: " + data);
				
			}
		} catch (IOException e) {
			System.out.println("사용자가 나갔습니다.");
		}
	}
}
