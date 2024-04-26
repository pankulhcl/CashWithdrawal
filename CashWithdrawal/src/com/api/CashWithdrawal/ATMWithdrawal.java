package com.api.CashWithdrawal;

/**
 * @author Pankul
 *
 */
class Account {
    int balance = 2000;
 
    public int getBal(){
        return balance;
    }
 
    public void withdraw(int amount){
        balance = balance - amount;
    }
 
}

/**
 * @author Pankul
 *
 */
public class ATMWithdrawal implements Runnable {
	Account account = new Account();
	public static void main(String[] args) {
		        ATMWithdrawal threadService = new ATMWithdrawal();
		        Thread t1 = new Thread(threadService, "customer 1");
		        Thread t2 = new Thread(threadService, "customer 2");

		        t1.start();
		        t2.start();	   
	}
		    @Override
		    public void run() {
		        for (int i = 0; i < 3; i++) {
		            withdraw(100);
		            if (account.getBal() < 0) {
		                System.out.println("account is overdrawn!");
		            }
		   
		        }
		    }
 
		    public synchronized boolean withdraw(int amount){
				if (amount > 0) {
					if (account.getBal() >= amount) {
						System.out.println(Thread.currentThread().getName() + " " + "is try to withdraw");
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
						account.withdraw(amount);
						System.out.println(Thread.currentThread().getName() + " " + "is complete the withdraw");
						return true;
					}
					else{        
			            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for withdraw");
			            return false;
			        }
				}
				
				else if(amount == 0) {
					System.out.println(Thread.currentThread().getName() + " " + "has entered invalid 0 number");
					return false;
				}
		        
		        else{        
		            System.out.println(Thread.currentThread().getName()+ " "+"has entered invalid negative number");
		            return false;
		        }
		    }
   
		}