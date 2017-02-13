package loginRegister;

import database.GlobalDataHolder;
import user.Account;
import user.User;

public class Register {


	public boolean registerUser(){
		User registerUser = new User();
		System.out.println("Please enter your fullname: ");
		String fullname = GlobalDataHolder.s.next();
		if(fullname != ""){
			registerUser.setFullName(fullname);
		}else{
			return false;
		}
		System.out.println("Please select a username: ");
		String username = GlobalDataHolder.s.next();
		if(username != ""){
			registerUser.setUsername(username);
		}else{
			return false;
		}
		String password1 = null;
		String password2 = null;
		System.out.println("Please enter a password");
		do{
		password1 = GlobalDataHolder.s.next();
		System.out.println("Confirm your password: ");
		password2 = GlobalDataHolder.s.next();
		}while(!password1.equals(password2));
		if(password1 !=  ""){
			registerUser.setPassword(password1);
		}else{
			return false;
		}
		
		System.out.println("Please enter currency");
		String currency = GlobalDataHolder.s.next();
		Account acc = new Account();
		registerUser.setAccount(acc);
		registerUser.getAccount().setCurrency(currency);
		System.out.println("First deposit: ");
		double balance = GlobalDataHolder.s.nextDouble();
		registerUser.getAccount().setBalance(balance);
		
		
		//works ok
		System.out.println(registerUser.getAccount().getCurrency());
		GlobalDataHolder.users.add(registerUser);
		return true;
	}

}
