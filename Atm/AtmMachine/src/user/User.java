package user;



public class User {

	private String fullName;
	private String username;
	private String password;
	private Account account;
	
	public User(){
		
	}//no arg constructor
	
	public User(String fullName, String username, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}//constructor with fields
	
	
	
	/*public User getCurrentUser(){
		return GlobalDataHolder.users.get(GlobalDataHolder.currentUser);
	}*/
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", username=" + username + ", password=" + password + ", account="
				+ account + "]";
	}
	



	
	
}
