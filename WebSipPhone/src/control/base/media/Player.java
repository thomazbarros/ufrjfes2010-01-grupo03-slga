package control.base.media;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class Player{
	
	private Player player = null;
	
	public Player(URL url) throws IOException, NoPlayerException,
	CannotRealizeException{
		player = Manager.createRealizedPlayer(url);
	}
	
	public Player(File file) throws IOException, NoPlayerException,
	CannotRealizeException{
		this(file.toURL());
	}
	
	public void play(){
		player.start()
	}
	
	public void stop(){
		player.stop();
		player.close();
	}
}