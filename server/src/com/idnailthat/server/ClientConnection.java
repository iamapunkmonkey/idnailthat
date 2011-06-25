package com.idnailthat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnection extends Thread implements Runnable {
	
	int 	q_len 	= 6;
	int 	port 	= 2540;
	Socket	sock;
	
	public void setPort(int parseInt) {
		this.port = parseInt;
	}

	public void run(){
		try {
			ServerSocket servSock = new ServerSocket(port, q_len);
			
			while(true){
				sock = servSock.accept();
				
				new Worker(sock).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
