package model.percistence;

import java.util.Date;

public class ChatMessage {
	Date data;
	String usuario;
	String conteudo;
	
	ChatMessage(Date data, String usuario, String conteudo){
		this.data = data;
		this.usuario = usuario;
		this.conteudo = conteudo;
	}
}
