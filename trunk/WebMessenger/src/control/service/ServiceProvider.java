package control.base.signal;

import model.structural.Contact;

import control.base.signal.PresenceManager;
import control.base.signal.ChatHandler;

public interface ServiceProvider {
    /**
    *   Inits Service provider.
    *   @param server is the url of the server.
    *   @param port is the port of the server.
    *
    *   Precondition:
    *       The aplication is disconnected from server.
    *   Postcondition:
    *       The application is connected to the server.
    *       An user may log-in the server.
    */
    public void init(String server, int port) throws Exception;

    /**
    *   Logs an user in the server.
    *   @param username is the id of the user in the server.
    *   @param password is the secret of the user in the server.
    *   @return A PresenceManager object wich has the list of his contacts,
    *       theirs status and also can set user own status.
    *
    *   Precondition:
    *       The application is connected to the server.
    *   Postcondition:
    *       The application is connected to the server.
    *       The user is logged-in the server.
    *       The user may set his own status.
    *       The user may retrieve his contacts and its status.
    */
    public PresenceManager login(String username, String password) throws Exception;
    
    /**
    *   Starts an chat with contact.
    *   @param contact is a valid contact obtained from a PresenceManager
    *       object.
    *   @return A ChatHandler object capable of sending outcomming messages,
    *       redirecting incomming messages to an registered listener and adding
    *       new contacts to the same chat.
    *   
    *   Precondition:
    *       The application is connected to the server.
    *   Postcondition:
    *       The user is in a chat.
    *       The user may add contacts to the chat.
    *       The user may send messages to a set of contacts.
    *       The set of contacts may send messages to the user.
    *       The user may leave the chat.
    */
    public ChatHandler startChat(Contact contact) throws Exception;

    /**
    *   Logs an user out the server.
    *   Precondition:
    *       The application is connected to the server.
    *   Postcondition:
    *       The application is not connected to the server.
    *       The PresenceManager created in the session may stay on disconnected
    *       status.
    */
    public void logout();
}
