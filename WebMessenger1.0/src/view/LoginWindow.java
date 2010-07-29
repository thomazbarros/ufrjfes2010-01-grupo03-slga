package view;

import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//import java.util.Scanner;

public class LoginWindow extends Window{

	public LoginWindow() {
		super("Autenticação");
		// Create the window...
		
		setModal(true);
		setWidth("800");
		setHeight("600");

		// Configure the windows layout; by default a VerticalLayout
		VerticalLayout layout = (VerticalLayout) getContent();
		layout.setMargin(true);
		layout.setSpacing(true);

		// Add some content; a label and a close-button
		Label message = new Label("Bem-vindo ao WebMessenger.");
		addComponent(message);

		//subwindow.addComponent(new Label("Usuário:"));

		LoginForm login = new LoginForm();
		setWidth("200px");
		setHeight("100px");
		
		login.addListener(new LoginForm.LoginListener() {
			//System.out.println("Qual o numero?") ; 
			//System.out.println("");
			public void onLogin(LoginEvent event) {
				getWindow().showNotification(
						"New Login",
						"Username: " + event.getLoginParameter("username")
						+ ", Senha: "
						+ event.getLoginParameter("senha"));
			}
		});
		
		addComponent(login);
	}

}