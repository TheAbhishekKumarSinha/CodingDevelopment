package abhi.multithread.deadlock;

public class AccountDeadLock {

	private double balance;
	private String accountHolderName;

	private AccountDeadLock(String accountHolderName,Double balance){
		this.balance=balance;
		this.accountHolderName=accountHolderName;
	}

	public void cashWithdrawal(double withdrawalAmount){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Withdrawal Not Completed");
		}
		this.balance-=withdrawalAmount;
		System.out.println(this.accountHolderName+":Amount Withdrawal:"+withdrawalAmount+" \t New Balance:"+this.balance);
	}

	public void cashDeposit(double depositAmount){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Withdrawal Not Completed");
		}
		this.balance+=depositAmount;
		System.out.println(this.accountHolderName+":Amount Deposit:"+depositAmount+" \t New Balance:"+this.balance);
	}
	

	public static void transferAmount(AccountDeadLock fromAccount,AccountDeadLock toAccount,double Amount){
		synchronized(fromAccount){
			fromAccount.cashWithdrawal(Amount);
			synchronized(toAccount){
				toAccount.cashDeposit(Amount);
			}
		}
	}

	public static void main(String args[]){
		final AccountDeadLock accountAbhi= new AccountDeadLock("Abhishek Kumar Sinha", 15000.00);
		final AccountDeadLock accountMini= new AccountDeadLock("Mini Nair", 16000.00);
		new Thread(){
			public void run(){
				AccountDeadLock.transferAmount(accountAbhi, accountMini, 1500);
			}
		}.start();
		new Thread(){
			public void run(){
				AccountDeadLock.transferAmount(accountMini, accountAbhi, 1700);
			}
		}.start();
	}
}
