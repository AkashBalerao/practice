package project;

public interface Bank {
	
	void createAccount(String name,double balance);
	
	void deposit(int accountNum,double amt);
	
	void withDraw(int accountNum,double amt);
	
	void showAccount(int accountNum);
	
	void showTransactions(int accountNum);
	
	void showBalance(int accountNum);
	
	void closeAccount(int accountNum);
	
	void transferMoney(int sourceAccountNum,int destinationAccountNum,double amt);
	
	void miniStatement(int accountNum);
	
	void applyLoan(int accountNumber , double loanAmt);
	
	void repayLoan(int accountNumber , double amt);
	
	void displayAccounts();
}
