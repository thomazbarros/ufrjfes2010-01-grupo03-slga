package model.structural;

public class Contact extends People implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private boolean isBlocked;
	
	public Contact(){
		
	}
	
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
}
