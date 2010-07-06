package control.chat;

import model.structural.Contact;

import control.chat.MessageReceiver;

public class XMPPChatHandler implements ChatHandler {
    private MessageReceiver receiver;
    
    public void add(Contact contact) {

    }

    public void setReceiver(MessageReceiver receiver) {
        this.receiver = receiver;
    }

    public void send(String message) throws Exception {

    }

    public void leave() {

    }
}
