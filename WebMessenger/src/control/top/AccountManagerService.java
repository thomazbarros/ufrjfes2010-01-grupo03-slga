package control.top;

public interface AccountManagerService {
	public void changePassword(String newPassord) throws Exception;
	public void createAccount(String username, String password) throws Exception;
	public void deleteAccount() throws Exception;
}
