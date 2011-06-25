package com.idnailthat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Worker extends Thread {
	Socket sock;
	
	Worker(Socket s){
		this.sock = s;
	}
	
	public void run(){
		PrintStream out = null;
		BufferedReader in = null;
		
		try {
			out = new PrintStream(sock.getOutputStream());
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			try {
				String name = in.readLine();
				String IP = in.readLine();
				String time = in.readLine();
				ConnectedClient currentClient = null;
				
				if(GameServer.clients.size() > 0){
					for(ConnectedClient c : GameServer.clients.toArray(new ConnectedClient[0])){
						if(c.isClient(IP, time)){
							currentClient = c;
							break;
						}
					}
				}
				
				if(currentClient == null){
					currentClient = new ConnectedClient(IP, time, name, false);
					GameServer.clients.add(currentClient);
				}
				
				
			}
			catch (IOException x) {
				System.out.println("Server read error");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
