package control.presence;

import java.util.Map;
import java.util.TreeMap;

import model.structural.Contact;

public class FesPresenceManager implements PresenceManager {
    private String userStatus;
    private TreeMap<String, Contact> contacts;

    public String getStatus() {
        return userStatus;
    }

    public void setStatus(String status) {
        userStatus = status;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }
    
    public Map<String, Contact> getContacts(String begin) {
        // TODO está errado! pesquisar pelo campo contact.email 
        char last = (char)(begin.toCharArray()[begin.length()-1] + 1);
        String end = begin.substring(begin.length()-1) + last;
        return contacts.subMap(begin, end);
    }
}
