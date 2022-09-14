package com.newlecture.ch3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class OmokClient {
	public static void main(String[] args) {
		String serverIp = "192.168.0.113";
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

class ClientReceiver extends Thread {
	Socket socket;
	BufferedReader server_in;

	ClientReceiver(Socket socket) throws IOException {
		this.socket = socket;
		server_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String receive_message;

			while (true) {
				receive_message = server_in.readLine();
				System.out.println(receive_message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ClientSender extends Thread {

	Socket socket;
	BufferedReader input;
	PrintWriter server_out;

	ClientSender(Socket socket) throws IOException {
		this.socket = socket;
		this.server_out = new PrintWriter(socket.getOutputStream(), true);
		this.input = new BufferedReader(new InputStreamReader(System.in));

	}

	@Override
	public void run() {
		try {
			String send_message;

			while (true) {
				send_message = input.readLine();
				server_out.println(send_message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}