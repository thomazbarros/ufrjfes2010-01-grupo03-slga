package control.service;

import model.structural.Contact;

public interface PresenceServiceListener {
    /**
    *   Adds a contact to the online contacts.
    *   @param contact is the contact to be add.
    *   
    *   Precondition:
    *       The contact is offline.
    *       The contact can not receive messages.
    *   Postcondition:
    *       The contact is online.
    *       The contact can receive messages.
    */
    public void add(Contact contact);

    /**
    *   Remove a contact from the online contacts.
    *   @param contact is the contact to be removed.
    *   
    *   Precondition:
    *       The contact is online.
    *       The contact can receive messages.
    *   Postcondition:
    *       The contact is offline.
    *       The contact can not receive messages.
    */ 
    public void remove(Contact contact);

    /**
    *   Updates contact status.
    *   @param contact is the contact that has changed status.
    *   
    *   Precondition:
    *       Contact is online.
    *   Postcondition:
    *       Contact has changed his status.
    */
    public void update(Contact contact);
}
