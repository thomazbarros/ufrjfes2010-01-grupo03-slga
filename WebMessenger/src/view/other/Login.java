package com.example.asd;

import com.vaadin.Application;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

import com.vaadin.ui.LoginForm;
//import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.LoginForm.LoginEvent;

//import java.util.Scanner;

public class Login extends Window{

	Window subwindow;
	public Login() {

		// Create the window...
		subwindow = new Window("Login");
		// ...and make it modal
		subwindow.setModal(true);
		subwindow.setWidth("800");
		subwindow.setHeight("600");

		// Configure the windows layout; by default a VerticalLayout
		VerticalLayout layout = (VerticalLayout) subwindow.getContent();
		layout.setMargin(true);
		layout.setSpacing(true);

		// Add some content; a label and a close-button
		Label message = new Label("Bem-vindo ao WebMessenger.");
		subwindow.addComponent(message);

		//subwindow.addComponent(new Label("Usuário:"));

		LoginForm login = new LoginForm();
		login.setWidth("100%");
		login.setHeight("300px");
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
		subwindow.addComponent(login);

		getWindow().addWindow(subwindow);
		//addComponent(open);

	}

}