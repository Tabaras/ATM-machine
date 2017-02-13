package main;

import database.GlobalDataHolder;
import loginRegister.Login;
import loginRegister.Register;
import menu.Menu;
import user.Account;
import user.User;

public class App {

	Menu menu;
	User user;
	Double balance;
	Double amount;
	
	public User getCurrentUser(){
		return GlobalDataHolder.users.get(GlobalDataHolder.currentUser);
	}
	
	public void run() {
		
		initUsers();
		menu = new Menu();
		menu.displayMainMenu();

		Integer opt = menu.readOption();

		switch (opt) {
		//start login, if login fail enter credentials again
		case 1:
			
			Login login = new Login();
			boolean b = login.login();
			//If login successful => log to second menu
			if (b == true) {
				executeLogin();
			//else enter credential again	
			}else if(b == false){
				login.login();
			}

			break;
		case 2:
			Register register = new Register();
			boolean isCreated = register.registerUser();
			if(isCreated == true){
			login = new Login();
			b = login.login();
			if (b == true) {
				executeLogin();
			//else enter credential again	
			}else if(b == false){
				login.login();
			}
			}
			break;
		case 3:
			System.out.println("Exiting the Atm");
		break;
		}
			

	}
	
	//second menu method
	public void executeLogin(){
		Menu m = new Menu();
		
		
		m.displaySecondMenu();
		
		Integer choice = null;
		
		do{
		//	m.displaySecondMenu();
			System.out.println("Choose an option: ");
			choice = GlobalDataHolder.s.nextInt();
			
		switch(choice){
		case 1:
			System.out.println(GlobalDataHolder.users.get(GlobalDataHolder.currentUser));
			System.out.println("Status: " +GlobalDataHolder.runningApp);
			break;
		case 2:
			addMoney();
			break;
		case 3:
			withdrawMoney();
			break;
		case 4:
			showBalance();
			break;
		case 5:
			setNewPassword();
			break;
		case 6:
			System.out.println("Out of the program");
		default : 
			System.out.println("This option is not in the menu!");
			GlobalDataHolder.runningApp = false;
		}//end switch
		
		}while(GlobalDataHolder.runningApp);
			
			
			
			
		}//end execute login
	
	//adding money to your account
	void addMoney(){
		balance = this.getCurrentUser().getAccount().getBalance();
		System.out.println("How much you want to add to your account ?");
		amount = GlobalDataHolder.s.nextDouble();
		balance+=amount;
		this.getCurrentUser().getAccount().setBalance(balance);
		System.out.print("Current balance: "+this.getCurrentUser().getAccount().getBalance());
		System.out.println(" Currency: "+this.getCurrentUser().getAccount().getCurrency());
		//new Account().addMoney(amount);
	}
	
	//withdrawing money
	void withdrawMoney(){
		balance = this.getCurrentUser().getAccount().getBalance();
		System.out.println("How much you want to withdraw from your account ?");
		amount = GlobalDataHolder.s.nextDouble();
		if(amount > balance){
			System.out.println("Not enough funds!!!");
		}else{
		balance-=amount;
		}
		this.getCurrentUser().getAccount().setBalance(balance);
		System.out.print("Current balance: "+this.getCurrentUser().getAccount().getBalance());
		System.out.println(" Currency: "+this.getCurrentUser().getAccount().getCurrency());
		//new Account().addMoney(amount);
		
	}
	
	//show current balance
	void showBalance(){

		System.out.println("Your account current status is: ");
		System.out.print(this.getCurrentUser().getAccount().getBalance());
		System.out.println(" "+this.getCurrentUser().getAccount().getCurrency());
	}
	
	//changing password method	
	public void setNewPassword(){
		String oldPassword;
		String newPassword;
		String newPassword2;
		System.out.println("Please enter your old password: ");
		oldPassword = GlobalDataHolder.s.next();
		do{
		System.out.println("Please enter your new password: ");
		newPassword = GlobalDataHolder.s.next();
		System.out.println("Confirm your password: ");
		newPassword2 = GlobalDataHolder.s.next();
		}while(!newPassword.equals(newPassword2));
		if(!oldPassword.equals(newPassword)){
		this.getCurrentUser().setPassword(newPassword);
		}else{
			System.out.println("Your new password has not been changed.");
			System.out.println("You choose the same password!!!");
		}
	}
			
	//u1="Tabaras Tudor", "Tudor", "1234"
	//		String allData = prop.getProperty(u+index);
	//		[]String = allData.split("|");
			
	//u2="Amalia Radu", "Amalia", "2222"
	
	//init users
	public void initUsers(){
		
		User user1 = new User("Tabaras Tudor", "Tudor", "1234");
		Account accountTudorRon = new Account();
		user1.setAccount(accountTudorRon);
		user1.getAccount().setBalance(10.0);
		user1.getAccount().setCurrency("RON");
		GlobalDataHolder.users.add(user1);
		
		User user2 = new User("Amalia Radu", "Amalia", "2222");
		Account accountAmaliaEur = new Account();
		user2.setAccount(accountAmaliaEur);
		user2.getAccount().setBalance(15.2);
		user2.getAccount().setCurrency("Eur");
		GlobalDataHolder.users.add(user2);
		
		User user3 = new User("Dana Mihai", "Dana", "0000");
		Account accountDanaRon = new Account();
		user3.setAccount(accountDanaRon);
		user3.getAccount().setBalance(20.4);
		user3.getAccount().setCurrency("Ron");
		GlobalDataHolder.users.add(user3);
			
			
	}	
			
			
			
			
			
			
			
			
			
		
		
		
	
}
