package view;

import org.vaadin.artur.icepush.ICEPush;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MessageWindow extends Window { //implements MessageListener, MessageReceiver {
	
	private TabSheet sheet = new TabSheet();
	private RichTextArea input;
	private Label output;
	//private ICEPush pusher;

	
	public void setOutputText(String message) {
		this.output.setValue(message);
		System.out.println("Entrei aqui e modifiquei geral");
		System.out.println(output.getValue());
		//pusher.push();
		/*output.requestRepaint();
		output.setImmediate(true);
		output.requestRepaint();*/
		//this.paint(output);
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
		
		//pusher = new ICEPush();
		//this.addComponent(pusher);
		
		output = new Label();
		output.setWidth("100%");
		output.setHeight("100%");
		output.setContentMode(Label.CONTENT_TEXT);
		output.setValue("AAA");
		output.setImmediate(true);
		//RepaintRequestListener listener = new RepaintRequestListener();
		//output.addListener(listener);
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
		this.requestRepaintRequests();
	}
	

/*	@Override
	public void processMessage(Chat arg0, Message arg1) {
		input.setValue(input.getValue() + "\n" +
				arg1.getFrom() + " said: " + arg1.getBody());
	}
*/
	//@Override
//	public void receive(String from, String message) {
//		input.setValue(input.getValue() + "\n" +
	//			from + " said: " + message);		
	//}
}
