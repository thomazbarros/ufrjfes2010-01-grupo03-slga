package control.top;

import org.jivesoftware.smack.XMPPException;

public interface AccountManagerService {
	public void changePassword(String newPassord) throws XMPPException;
	public void createAccount(String username, String password) throws XMPPException;
	public void deleteAccount() throws XMPPException;
}
