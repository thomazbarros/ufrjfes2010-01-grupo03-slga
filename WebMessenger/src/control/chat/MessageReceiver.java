package control.chat;

public interface MessageReceiver {
    /**
    *   Receives a message.
    *   
    *   Precondition:
    *       The user is in a chat.
    */
    public void receive(String message);
}
