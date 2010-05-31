package main;

import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class WebSipPhone extends com.vaadin.Application {

    @Override
    public void init() {
        final Window main = new Window("Web Sip Phone");
        setMainWindow(main);

        main.addComponent(new Label("Hello Web Sip Phone"));
    }
}
