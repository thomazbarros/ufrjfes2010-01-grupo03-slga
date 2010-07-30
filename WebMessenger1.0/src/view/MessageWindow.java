package view;

import org.jivesoftware.smack.MessageListener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class MessageWindow extends Window {
	
	private TabSheet sheet = new TabSheet();
	private RichTextArea input;
	private Label output;
	private Button send;
	
	public void esvaziaInputText(){
		input.setValue("");
	}
	
	public void setListenerButton(ClickListener listener){
		send.addListener(listener);
	}
	
	public void setListenerOutput(MessageListener listener){
		output.addListener((Listener)listener);
	}
	
	public String getInputText(){
		return (String) input.getValue();
	}
	
	public void setOutputText(String message) {
		this.output.setValue(message);
		System.out.println(output.getValue());
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
		output.setImmediate(true);
		layout.addComponent(output);
		layout.setExpandRatio(output, 5f);
		
		input = new RichTextArea();
		input.setWidth("100%");
		input.setHeight("100%");
		layout.addComponent(input);
		layout.setExpandRatio(input, 2f);
		
		send = new Button("Enviar...");
		layout.addComponent(send);
		layout.setExpandRatio(send, 1f);
		
		Tab chat = sheet.addTab(layout, contact, null);
		this.requestRepaintRequests();
		chat.setClosable(true);
	}	
}
