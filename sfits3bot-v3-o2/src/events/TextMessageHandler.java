package events;

import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import core.Main;

public class TextMessageHandler {
	TextMessageEvent event;
	String invokerName, invokerId, method, message;
	
	public TextMessageHandler(TextMessageEvent event) {
		this.event = event;
		this.invokerName = event.getInvokerName();
		this.invokerId = event.getInvokerUniqueId();
		this.method = event.getTargetMode().toString().toLowerCase();
		this.message = event.getMessage();
		handleTextMessage();
	}
	
	private void handleTextMessage() {
		if(true) {
			displayTextMessage();
		}
	}
	
	private void displayTextMessage() {
		System.out.println(Main.timeStamp() + " [MESSAGE] " + invokerName + " (" + invokerId 
		+ ") to " + method + ": " + message);
	}
	
	private void logTextMessage() {
		
	}
	
	
}
