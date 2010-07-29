package control.base.xmpp;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class XMPPAccountService implements AccountService{
	
	private AccountManager accountManager;
	
	public XMPPAccountService(XMPPConnection connection){
		accountManager = new AccountManager(connection);
	}
	
	@Override
	public void changePassword(String newPassord) throws XMPPException {
		accountManager.changePassword(newPassord);
	}

	@Override
	public void createAccount(String username, String password) throws XMPPException {
		accountManager.createAccount(username, password);
	}

	@Override
	public void deleteAccount() throws XMPPException {
		accountManager.deleteAccount();
	}
}
