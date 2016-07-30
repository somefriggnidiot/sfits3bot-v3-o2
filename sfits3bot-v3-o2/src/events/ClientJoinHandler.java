package events;

import java.util.Map;

import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;

public class ClientJoinHandler {
	ClientJoinEvent event;
	
	public ClientJoinHandler(ClientJoinEvent event) {
		this.event = event;
		handleConnection();
	}
	
	private void handleConnection() {
		
	}
	
	private void displayConnection() {
		//TODO: Log to console.
	}
	
	private void logConnection() {
		//TODO: Log to file.
	}
	
}
