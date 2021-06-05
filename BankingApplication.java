import java.util.*;
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Aya El", "JJ4556");	
	    obj.showMenu();	
	}

}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname , String cid) {
		customerName = cname;
		customerId = cid;
	}
	
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdraw: " +Math.abs(previousTransaction));
		}
		
		else {
			System.out.println("No Transaction Occured");
		}
	}
	
	void showMenu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenue " +customerName + "!");
		System.out.println("ID :" +customerId);
		System.out.println("\n");
		
		System.out.println("A : Vérifier votre solde ");
		System.out.println("B : Déposer");
		System.out.println("C : Retirer ");
		System.out.println("D : Opération précédente");
		System.out.println("E : Exit");
		
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("Veuillez choisir une option :");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			
			case 'A':
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("Entrer un montant à déposer : ");
				System.out.println("-------------------------------------------------------");
				
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("Entrer un montant à retirer ");
				System.out.println("-------------------------------------------------------");
				
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				getPreviousTransaction();
				System.out.println("-------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E' :
				System.out.println("Fin");
				break;

			default:
				System.out.println("Option Invalide!! Veuillez entrer une option correcte...");
				break;
			}			
		}
		while(option != 'E');
			System.out.println("Merci d'avoir choisi notre service bancaire!");
	}
}
