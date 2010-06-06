package view;

import com.vaadin.ui.*;

public class MainWindow extends Window {

    public MainWindow() {
        GridLayout layout = new GridLayout(3,3);
        layout.setSpacing(true);

        TextField text = new TextField();
        layout.addComponent(text, 0, 1);
        layout.setComponentAlignment(text, Alignment.MIDDLE_CENTER);

        Table table = new Table();
        layout.addComponent(table, 0, 2);
        layout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        setContent(layout);
    }
}

