package com.example.asd;

import com.vaadin.ui.Button;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.TabSheet.Tab;

public class MessageWindow extends Window {
	
	private TabSheet sheet = new TabSheet();
	
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
		
		TextField output = new TextField();
		output.setWidth("100%");
		output.setHeight("100%");
		layout.addComponent(output);
		layout.setExpandRatio(output, 5f);
		
		RichTextArea input = new RichTextArea();
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
}
