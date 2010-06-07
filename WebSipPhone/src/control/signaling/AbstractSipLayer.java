package signaling;

import java.net.*;
import java.util.*;
import java.text.*;
import javax.sip.*;
import javax.sip.header.*;
import javax.sip.address.*;
import javax.sip.message.*;

public abstract class AbstractSipLayer implements SipListener {
    private static SipStack stack;
    private static SipProvider provider;
    private static HeaderFactory headerFactory;
    private static AddressFactory addressFactory;
    private static MessageFactory messageFactory;
    
    public static String getHost() {
        return stack.getIPAddress();
    }
    
    public static int getPort() {
        return provider.getListeningPoint().getPort();
    }
    
    public static SipURI createSipURI(String username, String addressString)
        throws ParseException {
        return addressFactory.createSipURI(username, addressString);
    }

    public static Address createAddress(String username, String addressString)
        throws ParseException {
        SipURI uri = createSipURI(username, addressString);
        Address address = addressFactory.createAddress(uri);
        address.setDisplayName(username);
        return address;
    }
    
    public static Address getLocalAddress(String username)
        throws ParseException {
        return createAddress(username, getHost() + ":" + getPort());
    }
    
    public static FromHeader createFromHeader(Address address)
        throws ParseException {
        return headerFactory.createFromHeader(address, "WebSipPhone0.1");
    }

    public static ToHeader createToHeader(Address address)
        throws ParseException {
        return headerFactory.createToHeader(address, null);
    }

    public static ViaHeader createViaHeader()
        throws ParseException, InvalidArgumentException {
        return headerFactory.createViaHeader(getHost(), getPort(), "udp", null);
    }

    public static CallIdHeader createCallIdHeader() {
        return provider.getNewCallId();
    }

    public static CSeqHeader createCSeqHeader(String type)
        throws ParseException, InvalidArgumentException {
        return headerFactory.createCSeqHeader(1, type);
    }

    public static MaxForwardsHeader createMaxForwardsHeader(int max)
        throws InvalidArgumentException {
        return headerFactory.createMaxForwardsHeader(max);
    }

    public AbstractSipLayer(String host, int port)
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
