package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SBIBank implements Bank {
	
	SBIBank(){
//		accounts.put(99,new Account(99,"abc",100.0,new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"))));
//		accounts.put(100,new Account(100,"shankar",100.0,new ArrayList<String>()));
//		accounts.put(101, new Account(101, "John Doe", 5000.0, new ArrayList<String>()));
//		accounts.put(102, new Account(102, "Alice Smith", 7500.0, new ArrayList<String>()));
//		accounts.put(103, new Account(103, "Bob Johnson", 12000.0, new ArrayList<String>()));
//		accounts.put(104, new Account(104, "Emily Davis", 3000.0, new ArrayList<String>()));
//		accounts.put(105, new Account(105, "Michael Brown", 8900.0, new ArrayList<String>()));
//		accounts.put(106, new Account(106, "Sophia Wilson", 15000.0, new ArrayList<String>()));
//		accounts.put(107, new Account(107, "David Lee", 6400.0, new ArrayList<String>()));
//		accounts.put(108, new Account(108, "Olivia Taylor", 9200.0, new ArrayList<String>()));
//		accounts.put(109, new Account(109, "James Anderson", 4100.0, new ArrayList<String>()));
//		accounts.put(110, new Account(110, "Emma Martinez", 7300.0, new ArrayList<String>()));
//		accounts.put(111, new Account(111, "William Harris", 6200.0, new ArrayList<String>()));
//		accounts.put(112, new Account(112, "Charlotte White", 13400.0, new ArrayList<String>()));
//		accounts.put(113, new Account(113, "Daniel Clark", 5700.0, new ArrayList<String>()));
//		accounts.put(114, new Account(114, "Ava Lewis", 8100.0, new ArrayList<String>()));
//		accounts.put(115, new Account(115, "Matthew Hall", 2900.0, new ArrayList<String>()));
//		accounts.put(116, new Account(116, "Isabella Allen", 10500.0, new ArrayList<String>()));
//		accounts.put(117, new Account(117, "Ethan Young", 6800.0, new ArrayList<String>()));
//		accounts.put(118, new Account(118, "Mia Scott", 7200.0, new ArrayList<String>()));
//		accounts.put(119, new Account(119, "Alexander Green", 9400.0, new ArrayList<String>()));
//		accounts.put(120, new Account(120, "Harper Adams", 8600.0, new ArrayList<String>()));
//		accounts.put(121, new Account(121, "Benjamin Nelson", 4200.0, new ArrayList<String>()));
//		accounts.put(122, new Account(122, "Amelia Carter", 5600.0, new ArrayList<String>()));
//		accounts.put(123, new Account(123, "Lucas Baker", 11000.0, new ArrayList<String>()));
//		accounts.put(124, new Account(124, "Ella Gonzalez", 7500.0, new ArrayList<String>()));
//		accounts.put(125, new Account(125, "Henry Perez", 9900.0, new ArrayList<String>()));
//		accounts.put(126, new Account(126, "Sofia Thompson", 5300.0, new ArrayList<String>()));
//		accounts.put(127, new Account(127, "Jack Rivera", 8800.0, new ArrayList<String>()));
//		accounts.put(128, new Account(128, "Lily Torres", 4700.0, new ArrayList<String>()));
//		accounts.put(129, new Account(129, "Mason Ramirez", 7600.0, new ArrayList<String>()));
//		accounts.put(130, new Account(130, "Zoe Peterson", 6800.0, new ArrayList<String>()));
		
		try {
			
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/project/Accounts.ser"));
			HashMap<Integer,Account> collection = (HashMap<Integer,Account>)ois.readObject();
			accounts=collection;
			SBIBank.initialNumber=(Integer)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println(accounts.size());
		
		
	}
	

	HashMap<Integer,Account> accounts=new HashMap<>();
	private static int initialNumber=131;

	//create an account
	public void createAccount(String name,double balance) {
		if(!accounts.containsKey(initialNumber)) {
			accounts.put(initialNumber, new Account(initialNumber++,name,balance,new ArrayList<String>()));
			showAccount(initialNumber-1);
			System.out.println("account created");
		}
		else {
			System.out.println("account already exists");
		}
		
	}

	//deposit operation
	public void deposit(int accountNum,double amt) {
		if(accounts.containsKey(accountNum)) {
			Account acc=accounts.get(accountNum);
			if(amt>0) {
				acc.setBalance(acc.getBalance()+amt);
				acc.getTransactionHistory().add("amount of RS "+amt+" is credited");
				showAccount(acc.getAccNum());
			}
			else {
				System.out.println("invalid amt");
			}
		}
		else {
			System.out.println("account not exists");
		}
	}

	//withdraw operation
	public void withDraw(int accountNum,double amt) {
		if(accounts.containsKey(accountNum)) {
			Account acc=accounts.get(accountNum);
			if(amt>0&&amt<=acc.getBalance()) {
				acc.setBalance(acc.getBalance()-amt);
				acc.getTransactionHistory().add("amount of RS"+amt+" is debited");
				showAccount(acc.getAccNum());
			}
			else {
				System.out.println("invalid amt");
			}
		}
		else {
			System.out.println("account not exists");
		}
	}

	//to display a particular account
	public void showAccount(int accountNum) {
		System.out.println(accounts.get(accountNum));
	}

	//transaction history
	public void showTransactions(int accountNum) {
		if(accounts.containsKey(accountNum)) {
			Account acc=accounts.get(accountNum);
			ArrayList<String> transactions=acc.getTransactionHistory();
			
			System.out.println("account number : "+acc.getAccNum()+" name : "+acc.getHolderName()+" balance : "+acc.getBalance());
			System.out.println("Transaction History : ");
			for(String s:transactions) {
				System.out.println(s);
			}
		}
		else {
			System.out.println("account not found");
		}
	}

	// check balance
	public void showBalance(int accountNum) {
		if(accounts.containsKey(accountNum)) {
			Account acc=accounts.get(accountNum);
			System.out.println("account number : "+acc.getAccNum()+" name : "+acc.getHolderName()+" balance : "+acc.getBalance());
		}
	}
	
	//closing the account
	public void closeAccount(int accountNum) {
		if(accounts.containsKey(accountNum)) {
			accounts.remove(accountNum);
			System.out.println("account is removed");
		}
		else {
			System.out.println("account not found");
		}
	}

	//transfer money from one account to another account
	public void transferMoney(int sourceAccountNum,int destinationAccountNum,double amt) {
		if(!accounts.containsKey(sourceAccountNum)) {
			System.out.println("source account number is not valid");
		}
		else if(!accounts.containsKey(destinationAccountNum)){
			System.out.println("Destination account number is not valid");
		}
		else if(accounts.containsKey(sourceAccountNum)&&accounts.containsKey(destinationAccountNum)) {
			Account sourceAccount=accounts.get(sourceAccountNum);
			Account destinationAccount=accounts.get(destinationAccountNum);
			
			if(amt<=sourceAccount.getBalance()) {
				sourceAccount.setBalance(sourceAccount.getBalance()- amt);
				destinationAccount.setBalance(destinationAccount.getBalance()+amt);
				sourceAccount.getTransactionHistory().add("an ammount of rs: "+ amt + " is transfered to account number "+destinationAccountNum);
				destinationAccount.getTransactionHistory().add("an ammount of rs: "+ amt + " is recieved from the account "+sourceAccountNum);
				System.out.println("amount transfered");
				showAccount(sourceAccountNum);
				showAccount(destinationAccountNum);
			}
			else {
				System.out.println("invalid amt");
			}
		}
	}

	//printing last 5 transactions
	public void miniStatement(int accountNum) {
		if(accounts.containsKey(accountNum)) {
			Account acc=accounts.get(accountNum);
			ArrayList<String> transactions = acc.getTransactionHistory();
			
			int length=transactions.size();
			for(int i=length-1;i>=0;i--) {
				if(i==length-5-1)
					break;
				
				System.out.println(transactions.get(i));
			}
			
			if(length<=0) {
				System.out.println("no recent transactions");
			}
		}
		else {
			System.out.println("account not found");
		}
	}
	
	//display all accounts in the bank
	public void displayAccounts() {
		System.out.println("{");
		for(Integer a:accounts.keySet()) {
			System.out.println(accounts.get(a));
			System.out.println();
		}
		System.out.println("}");
	}
	
	//taking a loan
	public void applyLoan(int accountNum,double loanAmt) {
		if(accounts.containsKey(accountNum)) {
			Account account=accounts.get(accountNum);
			if(account.getLoanAmount()==0) {
				if(loanAmt>0&&account.getBalance()*3>=loanAmt) {
					account.setBalance(account.getBalance()+loanAmt);
					account.setLoanAmount(loanAmt);
					account.getTransactionHistory().add("loan of amount rs: "+loanAmt+" is credited");
					System.out.println("loan is approved");
					showAccount(accountNum);
				}
				else {
					System.out.println("invalid loan amount");
				}
			}
			else {
				System.out.println("your account has already taken loan");
			}
		}
		else {
			System.out.println("account not found");
		}
	}
	
	//repay loan
	public void repayLoan(int accountNum,double repayAmt) {
		if(accounts.containsKey(accountNum)) {
			Account account=accounts.get(accountNum);
			if(account.getLoanAmount()>0) {
				if(repayAmt>0&&repayAmt<=account.getLoanAmount()) {
					account.setBalance(account.getBalance()-repayAmt);
					account.setLoanAmount(account.getLoanAmount()-repayAmt);
					account.getTransactionHistory().add("rapayment loan  amount of rs: "+repayAmt+" is debited");
					System.out.println("repayment of loan is successfull");
					showAccount(accountNum);
				}
				else {
					System.out.println("invalid loan amount");
				}
			}
			else {
				System.out.println("your account has no loan");
			}
		}
		else {
			System.out.println("account not found");
		}
	}
	
	//serializing the objects before shutdown
	public void serializeObjects() {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/project/Accounts.ser"));
			oos.writeObject(accounts);
			oos.writeObject(Integer.valueOf(initialNumber));
//			System.out.println("written successfully");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(accounts.size());
	}

}
	