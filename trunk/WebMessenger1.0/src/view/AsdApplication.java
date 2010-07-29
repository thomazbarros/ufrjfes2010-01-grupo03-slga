package view;
import com.vaadin.Application;

public class AsdApplication extends Application {
	@Override
	public void init() {
		setMainWindow(new MainWindow("WebMessage"));
	}

}
