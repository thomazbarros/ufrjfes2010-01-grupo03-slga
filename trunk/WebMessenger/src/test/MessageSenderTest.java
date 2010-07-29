package test;

import org.jivesoftware.smack.MessageListener;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.xmpp.XMPPConnectionService;
import control.top.MessageService;

@RunWith(JMock.class)
public class MessageSenderTest {
	
	static MessageService service;
	static XMPPConnectionService connection;
	static Mockery context;
	
	@BeforeClass static public void
	messageSenderInitiation() throws Exception{
		connection = new XMPPConnectionService();
		connection = new XMPPConnectionService();
		connection.connect(TestAccount.server, TestAccount.port);
		service = connection.chat("gust.has@gmail.com");
		context = new JUnit4Mockery();
	}
	
	@Test public void
	testSend() throws Exception{
		MessageListener listener = context.mock(MessageListener.class);
		service.createChat(listener);
		service.send("Cante 'Hare Krishna' e seja feliz!");
		
		context.checking(new Expectations() {{
		}});
	}
}
