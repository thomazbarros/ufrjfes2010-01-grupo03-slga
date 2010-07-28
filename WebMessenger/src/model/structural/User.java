package model.structural;

public class User extends People implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private boolean accept;

	public User(){
		
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
}
