package menu;



import database.GlobalDataHolder;

public class Menu {

	
	public void displayMainMenu(){
		
		System.out.println("The program is running...");
		System.out.println("(1)Login.");
		System.out.println("(2)Register new user.");
		System.out.println("(3)EXIT.");
	}
	
	
	public void displaySecondMenu(){
		
		System.out.println("Choose an option from the menu below.");
		System.out.println("(1)Show user details.");
		System.out.println("(2)Add money to account.");
		System.out.println("(3)Withdraw money from account.");
		System.out.println("(4)Show account balance.");
		System.out.println("(5)Change account password.");
		System.out.println("(6)EXIT.");
	}
	
	public Integer readOption(){
		
		Integer opt;
		opt = GlobalDataHolder.s.nextInt();
		return opt;
		}
}
