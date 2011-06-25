package com.idnailthat.server;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
	public static List<ConnectedClient>	clients	= new ArrayList<ConnectedClient>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientConnection cc = new ClientConnection();
		if(args != null && args.length > 0)
			cc.setPort(Integer.parseInt(args[0]));
		
		//Load in data
		
		cc.start();
	}

}
