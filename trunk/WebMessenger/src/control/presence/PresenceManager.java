package control.presence;

import java.util.Map;

import model.structural.Contact;

public interface PresenceManager {
    /**
    *   Gets user own status.
    *   @return A String object with the user status.
    */
    public String getStatus();

    /**
    *   Sets user own status.
    *   @param status is the new status of the user.
    *
    *   Postcondition:
    *       The user has an new status.
    *       User contacts may see this new status.
    */
    public void setStatus(String status);

    /**
    *   Gets user contacts.
    *   @return A Map object with the user contacts mapped into its status.
    */
    public Map<String, Contact> getContacts();
    
    /**
    *   Gets user contacts filtered by name.
    *   @param str is part of a contact name.
    *   @return A Map object with the user contacts mapped into its status wich
    *       theirs email contains str.
    */
    public Map<String, Contact> getContacts(String str);
}
