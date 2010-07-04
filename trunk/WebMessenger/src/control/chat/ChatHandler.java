package control.chat;

import model.structural.Contact;

import control.chat.MessageReceiver;

public interface ChatHandler {
    /**
    *   Adds a contact to the chat.
    *   @param contact is a contact to be added in the chat.
    *   
    *   Precondition:
    *       The user is in a chat.
    *   Postcondition:
    *       The contact is added to the chat.
    *       The user may send messages to all contacts in the chat including the
    *       newbie contact.
    *       The newbie contact may send messages to the user and to all other
    *       contacts.
    */
    public void add(Contact contact) throws Exception;

    /**
    *   Sets the receiver object.
    *   @param receiver is a object capable of receiving messages.
    *   
    *   Precondition:
    *       The user is in a chat.
    *   Postcondition:
    *       The user may receive contacts messages.
    */
    public void setReceiver(MessageReceiver receiver);

    /**
    *   Sends a message.
    *   @param message is a message to be sent.
    *   
    *   Precondition:
    *       The user is in a chat.
    *   Postcondition:
    *       The set of contacts in the chat may receive the message.
    */
    public void send(String message) throws Exception;

    /**
    *   Leaves the chat.
    *   
    *   Precondition:
    *       The user is in a chat.
    *   Postcondition:
    *       The user is not in a chat.
    *       The user may not send messages to the set of contacts.
    *       The user may not receive messages from the set of contacts.
    */
    public void leave();
}
