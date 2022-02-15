import java.util.Scanner;
public class Action {
	private char option;
	private double balance;
	private double withdrawal;
	private String recent;
	private double saving;
	private String cusName;
	private int cusID;
	
	Scanner sc = new Scanner(System.in);	
	
public Action(String name, int ID) {
	cusName = name;
	cusID = ID;
}

public double checkBalance(){
	return balance;
}

public void deposit(double amount) {
	balance = balance + amount;
	recent = ("You deposited " + amount);
}

public void withdrawal(double amount) {
	if (amount >balance) { 
	System.out.println("you do not have enough money");
	}else {
	balance = balance - amount;
	}
}
public void transaction() {
	System.out.println(recent);
}

public void interest(int month, double amount) {
	float interest = 1/100;
	for (int i = 1; i <= month ; i++) {
	saving = ((balance * (1 + interest)) * (balance * (1 + interest))); 
	}
	recent = ("You saved " + amount + " for " + "month");
}
public void menu() {
	System.out.println("Hi " + cusName + "and your ID is" + cusID );
	System.out.println("A. check balance");
	System.out.println("B. Make a deposit");
	System.out.println("C. Make a withdrawal");
	System.out.println("D. View Previous transaction");
	System.out.println("E. Calculate interest");
	System.out.println("F. Exist");

do {
	System.out.println("Type your option: ");
	option = sc.next().charAt(0);
	option = Character.toUpperCase(option);
	
switch(option) {
case 'A': 
	System.out.print("Your balance now is $" + balance);
	break;
case 'B':
	System.out.println("Type the amount you want to depost:");
	double amount = sc.nextDouble();
	deposit(amount);
	System.out.println("your money now is " + balance);
	break;
case 'C': 
	System.out.println("Type the amount you want to withdrawal");
	amount = sc.nextDouble();
	withdrawal(amount); 
	System.out.println("you balance now is " + balance);
	recent = ("you withdrew " + amount);
	break;
case 'D': 
	transaction();
	break;
case 'E': 
	System.out.println("How many months you want to save?");
	int month = sc.nextInt();
	System.out.println("How much you want to save?");
	amount = sc.nextDouble();
	interest(month, amount);
	System.out.println("your money then is " + saving);
	break;
default:
	System.out.println("your option is invalid, please choose again");
	break;
}
}
while (option != 'F');
	System.out.println("Thanks for your access!");
}
}

