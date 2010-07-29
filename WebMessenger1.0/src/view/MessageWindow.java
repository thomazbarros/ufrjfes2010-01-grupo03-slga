package view;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import control.top.MessageReceiver;

public class MessageWindow extends Window implements MessageListener, MessageReceiver {
	
	private TabSheet sheet = new TabSheet();
	private RichTextArea input;
	private Label output;
	
	public void setOutputText(String message) {
		this.output.setCaption(message);
	}

	public MessageWindow() {
		super("Messages");
		setWidth("600px");
		setHeight("75%");
		
		sheet.setWidth("100%");
		sheet.setHeight("100%");
		
		addComponent(sheet);
	}
	
	public void startChat(String contact) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		layout.setSizeFull();
		
		output = new Label();
		output.setWidth("100%");
		output.setHeight("100%");
		output.setContentMode(Label.CONTENT_TEXT);
		layout.addComponent(output);
		layout.setExpandRatio(output, 5f);
		
		input = new RichTextArea();
		input.setWidth("100%");
		input.setHeight("100%");
		layout.addComponent(input);
		layout.setExpandRatio(input, 2f);
		
		Button send = new Button("Enviar...");
		layout.addComponent(send);
		layout.setExpandRatio(send, 1f);
		
		Tab chat = sheet.addTab(layout, contact, null);
		chat.setClosable(true);
	}

	@Override
	public void processMessage(Chat arg0, Message arg1) {
		input.setCaption(input.getCaption() + "\n" +
				arg1.getFrom() + " said: " + arg1.getBody());
	}

	@Override
	public void receive(String from, String message) {
		input.setCaption(input.getCaption() + "\n" +
				from + " said: " + message);		
	}
}
