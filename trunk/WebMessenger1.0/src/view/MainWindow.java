package view;


import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Window;


@SuppressWarnings("serial")
public class MainWindow extends Window{
	
	private MessageWindow messageWindow = new MessageWindow();
    private MenuBar menubar = new MenuBar();

	
	public MainWindow(String username) {
		super("WebMessenger");
		final MenuBar.MenuItem logout = menubar.addItem( "Sair" , menuCommand);
		final MenuBar.MenuItem contatos = menubar.addItem("Contatos", null);
               
        contatos.addItem("Adicionar Contato", menuCommand);
        contatos.addItem("Remover Contato", menuCommand);
        contatos.addItem( "Procurar Contato" , menuCommand);
        contatos.addSeparator();


        contatos.addItem("Aqui vai entrar a lista", menuCommand);
        contatos.addSeparator();


        final MenuBar.MenuItem find = menubar.addItem("Busca Google", new Command(){
            public void menuSelected(MenuItem selectedItem) {
                getWindow().open(new ExternalResource("http://www.google.com"));
            }
        });
       
       addComponent(menubar);
		
		messageWindow.center();
		addWindow(messageWindow);
		
		messageWindow.startChat("Leopoldo");
		messageWindow.startChat("Gustavo");
	}
	private Command menuCommand = new Command() {
	        public void menuSelected(MenuItem selectedItem) {
	            getWindow().showNotification("Action " + selectedItem.getText());
	        }
	    };

	
}
