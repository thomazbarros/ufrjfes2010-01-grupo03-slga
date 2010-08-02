package model.structural;

import java.util.Date;

public class ChatMessage implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Date data;
	private String usuario;
	private String conteudo;
	
	public ChatMessage(){
		
	}
	
	public ChatMessage(Date data, String usuario, String conteudo){
		this.data = data;
		this.usuario = usuario;
		this.conteudo = conteudo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
