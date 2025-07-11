package project;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		SBIBank bank=new SBIBank();
		while(true) {
			System.out.println();
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("\n Welcome to the SBIBank: ");
			System.out.println("\n1.add account");
			System.out.println("2.deposit amount");
			System.out.println("3.withdraw amount");
			System.out.println("4.view account");
			System.out.println("5.show transaction history");
			System.out.println("6.check balance");
			System.out.println("7.close account");
			System.out.println("8.money transfer");
			System.out.println("9.mini statements");
			System.out.println("10.show accounts");
			System.out.println("11.take loan");
			System.out.println("12.repay loan");
			System.out.println("13.exit");
			
			switch(scn.nextInt()) {
			case 1:
				System.out.println("enter your name ");
				String name=scn.next();
				System.out.println("enter the balance");
				double balance=scn.nextDouble();
				
				bank.createAccount(name, balance);
				break;
				
			case 2:
				System.out.println("Enter account number");
				int accountNumber = scn.nextInt();
				System.out.println("Enter the deposit amount");
				double amt=scn.nextDouble();
				
				bank.deposit(accountNumber, amt);
				break;
				
			case 3:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				System.out.println("Enter the withdraw amount");
				amt=scn.nextDouble();
				
				bank.withDraw(accountNumber, amt);
				break;
				
			case 4:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				bank.showAccount(accountNumber);
				break;
				
			case 5:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				bank.showTransactions(accountNumber);
				break;
				
			case 6:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				bank.showBalance(accountNumber);
				break;
				
			case 7:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				bank.closeAccount(accountNumber);
				break;
				
			case 8:
				System.out.println("Enter source account number");
				int sourceAccountNumber=scn.nextInt();
				System.out.println("enter destination account number");
				int destnationAccountNumber=scn.nextInt();
				System.out.println("enter the amt");
				amt=scn.nextDouble();
				
				bank.transferMoney(sourceAccountNumber, destnationAccountNumber, amt);
				break;
				
			case 9: 
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				bank.miniStatement(accountNumber);
				break;
				
			case 10:
				System.out.println("accounts list:");
				bank.displayAccounts();
				break;
				
			case 11:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				System.out.println("enter the loan amount");
				double loanAmt=scn.nextDouble();
				
				bank.applyLoan(accountNumber,loanAmt);
				break;
			case 12:
				System.out.println("Enter account number");
				accountNumber = scn.nextInt();
				System.out.println("enter the repayment loan amount");
				double repayAmt=scn.nextDouble();
				
				bank.repayLoan(accountNumber,repayAmt);
				break;
			case 13:
				bank.serializeObjects();
				scn.close();
				return;
				
			default:
				System.out.println("enter a valid option");
				
			}
		}
	}
}