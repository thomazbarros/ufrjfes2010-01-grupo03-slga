package signaling;

import java.net.*;
import java.util.*;
import java.text.*;
import javax.sip.*;
import javax.sip.header.*;
import javax.sip.address.*;
import javax.sip.message.*;

public abstract class SipLayer implements SipListener {
    protected static SipStack stack;
    protected static SipProvider provider;
    protected static HeaderFactory headerFactory;
    protected static AddressFactory addressFactory;
    protected static MessageFactory messageFactory;
    
    public static String getHost() {
        return stack.getIPAddress();
    }
    
    public static int getPort() {
        return provider.getListeningPoint().getPort();
    }
    
    private static Address getLocalAddress(String username)
        throws ParseException{
        String addressString = getHost() + ":" + getPort();
        SipURI uri = addressFactory.createSipURI(username, addressString);
        Address address = addressFactory.createAddress(uri);
        return address;
    }

    public SipLayer(String host, int port)
        throws SipException, ParseException, InvalidArgumentException {

        SipFactory sipFactory = SipFactory.getInstance();
        sipFactory.setPathName("gov.nist");
        
        Properties properties = new Properties();
        properties.setProperty("javax.sip.STACK_NAME", "WebSipPhone");
        properties.setProperty("javax.sip.IP_ADDRESS", host);
        properties.setProperty("gov.nist.javax.sip.TRACE_LEVEL", "32");
        properties.setProperty("gov.nist.javax.sip.SERVER_LOG", "server.log");
        properties.setProperty("gov.nist.javax.sip.DEBUG_LOG", "debug.log");

        stack = sipFactory.createSipStack(properties);
        headerFactory = sipFactory.createHeaderFactory();
        addressFactory = sipFactory.createAddressFactory();
        messageFactory = sipFactory.createMessageFactory();

        ListeningPoint udp = stack.createListeningPoint(port, "udp");

        provider = stack.createSipProvider(udp);
    }
}
