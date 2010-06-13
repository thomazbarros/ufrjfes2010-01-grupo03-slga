package view.phone;

import com.vaadin.ui.*;

public class PhoneWindow extends Window {

    public PhoneWindow() {
        super("Web Sip Phone");

        Window friends = new Window("Friends");
        VerticalLayout layout = (VerticalLayout)friends.getContent();
        
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeUndefined();

        TextField text = new TextField();
        text.setWidth("300px");
        layout.addComponent(text);
        layout.setComponentAlignment(text, Alignment.MIDDLE_CENTER);

        Table table = new Table();
        table.setWidth("300px");
        layout.addComponent(table);
        layout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
        
        addWindow(friends);
    }
}

