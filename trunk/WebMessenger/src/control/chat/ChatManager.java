package control.base;

public interface ChatManager {
	public void send(String message);
	
	public void setChatListener(ChatListener listener);
}
