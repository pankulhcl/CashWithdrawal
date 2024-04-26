package com.api.CashWithdrawalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import com.api.CashWithdrawal.ATMWithdrawal;

/**
 * @author Pankul
 *
 */
public class ATMWithdrawalTest {
	
	// This method is used to check whether withdrawal will be done.
    @Test
	public void testSuccess() throws Exception {
  	  ATMWithdrawal atm = new ATMWithdrawal();
  	  boolean result = atm.withdraw(1000);
  	  assertTrue(result);
	}
    
 // This method is used to check whether withdrawal will be not be done.
    @Test
	public void testFail() throws Exception {
  	  ATMWithdrawal atm = new ATMWithdrawal();
  	  boolean result = atm.withdraw(10000);
  	  assertFalse(result);
	}
  
    // This method is used to check whether entered amount is 0
    @Test
	public void testFailZero() throws Exception {
  	  ATMWithdrawal atm = new ATMWithdrawal();
  	  boolean result = atm.withdraw(0);
  	  assertFalse(result);
	} 
    
	// This method is used to check whether entered amount is negative
    @Test
	public void testFailNegative() throws Exception {
  	  ATMWithdrawal atm = new ATMWithdrawal();
  	  boolean result = atm.withdraw(-200);
  	  assertFalse(result);
	} 

}
