package com.api.CashWithdrawal;

import java.util.Scanner;

/**
 * @author Pankul
 *
 */
class Account {
    int balance = 2000;
 
    public int getBal(){
        return balance;
    }
 
    public int withdraw(int amount){
        balance = balance - amount;
        return balance;
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
		    	Scanner sc = new Scanner(System.in);
		    	System.out.println("Enter money to be withdrawn for customer : ");
		         int input = sc.nextInt();
		        
		            withdraw(input);
		            if (account.getBal() < 0) {
		                System.out.println("account is overdrawn!");		   
		        }
		    }
		    
		    public static void countCurrency(int amount){
		        int[] notes = new int[]{ 2000, 1000, 500, 200, 100};
		        int[] noteCounter = new int[5];
		      
		        for (int i = 0; i < 5; i++) {
		            if (amount >= notes[i]) {
		                noteCounter[i] = amount / notes[i];
		                amount = amount % notes[i];
		            }
		        }
		      
		        System.out.println("Currency Count : ");
		        for (int i = 0; i < 5; i++) {
		            if (noteCounter[i] != 0) {
		                System.out.println(notes[i] + " : "
		                    + noteCounter[i]);
		            }
		        }
		    }
 
		    public synchronized boolean withdraw(int amount){
				if (amount > 0) {
					countCurrency(amount);
					if(amount % 10 != 0) {
						System.out.println("Amount entered should be multiple of 10");
						return false;
					}
				    else if (account.getBal() >= amount) {
						System.out.println(Thread.currentThread().getName() + " " + "is try to withdraw");
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
						int remainingAmount = account.withdraw(amount);
						System.out.println("Remaining Amount : "+ remainingAmount);
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