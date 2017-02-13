package loginRegister;

import database.GlobalDataHolder;
import user.User;

public class Login {
	
public boolean login(){
		
		int index = 0;
		boolean isFound = false;
		System.out.println("Enter your user name: ");
		String username = GlobalDataHolder.s.next();
		System.out.println("Enter your password.");
		String password = GlobalDataHolder.s.next();
		for(User u: GlobalDataHolder.users){
		
			
			if((username.equalsIgnoreCase(u.getUsername())) && (password.equalsIgnoreCase(u.getPassword()))){
				System.out.println("Access granted "+u.toString());
				isFound = true;
				break;
			}else{
				System.out.println("user not found!!");
				
			}
//			
			isFound = false;
			index++;
			System.out.println(GlobalDataHolder.currentUser = index);
				
		
		
		}
		return isFound;
	}
	
}//end class
