package control.top.phone;

import com.vaadin.Application;

import view.phone.PhoneWindow;

public class WebSipPhone extends Application {
    @Override
    public void init() {
        setMainWindow(new PhoneWindow());
    }
}
