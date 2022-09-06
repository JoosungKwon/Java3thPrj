package com.newlecture.ch3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	public static void main(String[] args) {
		String serverIp = "192.168.0.116";
		int serverPort = 8080;

		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("서버에 연결하였습니다.");
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);

			sender.start();
			receiver.start();

		} catch (UnknownHostException ue) {
			ue.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class ClientSender extends Thread {
	
	Socket socket;

	ClientSender(Socket socket) {
		this.socket = socket;

	}
	
	@Override
	public void run() {
		
		try {
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				if(data.equals("exit")) {
					System.out.println("연결이 끊어졌습니다.");
					break;
				} else {
					output.println(data);
					output.flush();
				}

			}
			output.close();
			input.close();
			socket.close();
			
		}catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

class ClientReceiver extends Thread {
	Socket socket;

	ClientReceiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				System.out.println("서버:" + data);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
