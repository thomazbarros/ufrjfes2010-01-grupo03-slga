package control.base;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import control.top.AccountManagerService;

public class XMPPAccountManagerService implements AccountManagerService{
	
	private AccountManager accountManager;
	
	public XMPPAccountManagerService(XMPPConnection connection){
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
