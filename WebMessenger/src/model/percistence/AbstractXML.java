package model.percistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class AbstractXML {

	private HashMap <String,Element> chat;
	private Element historicoConversas;
	private Document documento;
	private String path;
	private String user;
	private int ultimoId;

	public AbstractXML() {
		SAXBuilder builder = new SAXBuilder();
		try {
			documento = builder.build("c:/arquivo.xml");
			historicoConversas = documento.getRootElement();
			ultimoId = historicoConversas.getChildren().size();
		} catch (Exception e) {
			historicoConversas = new Element("Historico");
			documento = new Document(historicoConversas);
			// e.printStackTrace();
		}

		path = "C:\\arquivo.xml";
		
		chat = new HashMap<String,Element>();
	}

	public String iniciaChat() {
		Element novoChat = new Element("Chat");
		String id = String.valueOf(ultimoId + 1);
		ultimoId++;
		novoChat.setAttribute("id", id);
		chat.put(id, novoChat);
		return id;
	}

	public void gravaMensagemRecebida(String usuario, String conteudo, String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String data = sdf.format(new Date());

		Element mensagem = new Element("mensagem");
		mensagem.setAttribute("data", data);
		mensagem.setAttribute("usuario", usuario);
		mensagem.setText(conteudo);

		chat.get(id).addContent("\n		");
		chat.get(id).addContent(mensagem);
	}
	
	public void gravaMensagemEnviada(String conteudo, String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String data = sdf.format(new Date());

		Element mensagem = new Element("mensagem");
		mensagem.setAttribute("data", data);
		mensagem.setAttribute("usuario", user);
		mensagem.setText(conteudo);

		chat.get(id).addContent("\n		");
		chat.get(id).addContent(mensagem);
	}

	public void encerraChat(String id) {

		chat.get(id).addContent("\n	");

		historicoConversas.addContent("\n	");
		historicoConversas.addContent(chat.get(id));
		historicoConversas.addContent("\n");

		XMLOutputter xout = new XMLOutputter();

		try {

			FileWriter arquivo = new FileWriter(new File(path));
			xout.output(documento, arquivo);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		chat.remove(id);
	}

	public void imprimeConversas() {
		Element conversas = documento.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> lista = conversas.getChildren();
		for (Element e : lista) {
			@SuppressWarnings("unchecked")
			List<Element> listaMensagens = e.getChildren();
			for (Element e2 : listaMensagens) {
				System.out.print(e2.getAttributeValue("data") + " ");
				System.out.print(e2.getAttributeValue("usuario") + ": ");
				System.out.println("Mensagem: " + e2.getText());
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<ChatMessage>> buscaConversaPeriodo(String dataInicial, String dataFinal){
		Date dataInicioConversa, dataFinalConversa;
		Date dataInicioBusca, dataFinalBusca;		
		ArrayList<ArrayList<ChatMessage>> chatsBuscados = new ArrayList<ArrayList<ChatMessage>>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		
		Element conversas = documento.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> lista = conversas.getChildren();
		for (Element e : lista) {
			@SuppressWarnings("unchecked")
			List<Element> listaMensagens = e.getChildren();
			String data1 = listaMensagens.get(0).getAttributeValue("data");
			String data2 = listaMensagens.get(listaMensagens.size()-1).getAttributeValue("data");
			
			try{
				dataInicioConversa = new Date(format.parse(data1).getTime());
				dataFinalConversa = new Date(format.parse(data2).getTime());
				dataInicioBusca = new Date(format.parse(dataInicial).getTime());
				dataFinalBusca = new Date(format.parse(dataFinal).getTime());
			}
			catch(Exception exc){
				exc.printStackTrace();
				return null;
			}
			
			if (dataInicioConversa.before(dataFinalBusca) && dataInicioConversa.after(dataInicioBusca))
			{
				ArrayList<ChatMessage> conversa = formataChat(listaMensagens);
				chatsBuscados.add(conversa);
			}
			else
			{
				if(dataFinalConversa.before(dataFinalBusca) && dataFinalConversa.before(dataInicioBusca))
				{
					ArrayList<ChatMessage> conversa = formataChat(listaMensagens);
					chatsBuscados.add(conversa);					
				}
			}
		}
		
		return chatsBuscados;
	}

	public ArrayList<ArrayList<ChatMessage>> buscaConversaUsuario(String usuario) {
		
		ArrayList<ArrayList<ChatMessage>> chatsBuscados = new ArrayList<ArrayList<ChatMessage>>();
		
		Element conversas = documento.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> lista = conversas.getChildren();
		for (Element e : lista) {
			@SuppressWarnings("unchecked")
			List<Element> listaMensagens = e.getChildren();
			for (Element e2 : listaMensagens) {
				if (e2.getAttributeValue("usuario").equals(usuario)){
					ArrayList<ChatMessage> temp = formataChat(listaMensagens);
					chatsBuscados.add(temp);
					break;
				}
				System.out.println("Mensagem: " + e2.getText());
			}
			System.out.println();
		}
		
		return chatsBuscados;
	}
	
	public ArrayList<ChatMessage> formataChat(List<Element> chat){
		ArrayList<ChatMessage> listaFormatada = new ArrayList<ChatMessage>();
		ChatMessage temp;
		String usuario,conteudo,dataTemp;
		Date data;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		
		for (Element e : chat){
			try{
				dataTemp = e.getAttributeValue("data");
				data = new Date(format.parse(dataTemp).getTime());
			}
			catch(Exception exc){
				exc.printStackTrace();
				return null;
			}
			usuario = e.getAttributeValue("usuario") + ": ";
			conteudo = e.getText();
			
			temp = new ChatMessage(data,usuario,conteudo);
			listaFormatada.add(temp);
		
		}
		return listaFormatada;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
