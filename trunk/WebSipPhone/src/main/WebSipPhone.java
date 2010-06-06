package main;

import com.vaadin.Application;

import view.MainWindow;

public class WebSipPhone extends Application {
    @Override
    public void init() {
        setMainWindow(new MainWindow());
    }
}
