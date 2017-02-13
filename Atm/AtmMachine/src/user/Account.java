package user;



public class Account {

	private Double balance;
	private String currency;
	
	
	
	

	public Account(){
		
	}
	
	public Account(Double balance, String currency){
		
		this.balance = balance;
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", currency=" + currency + "]";
	}

	
	// Add and withdraw operation
	
//	public Double addMoney(Double amount){
		//=>Luam balanta userului curent
		//=>O adunam peste valoare
		//=>Il mai adaugam in lista ?
		/*User u = new User();
		Double d = u.getCurrentUser().getAccount().getBalance();
		System.out.println("Add money: ");
		Double amount = GlobalDataHolder.s.nextDouble();
		d = +amount;
		u.getAccount().setBalance(d);
		GlobalDataHolder.users.add(u);
		
		return u;*/
		
		
		
	//}//end addMoney method
	
	public Double withdrawMoney(Double amount){
		
		this.balance = balance - amount;
		return this.balance;
	}
}
