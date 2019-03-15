/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_final_yarab;

/**
 *
 * @author Islam
 */
public  interface ATM {
//Returnsthe current balance in string format
public double getCurrentBalance();
//withdraws from current balance and updates it
public int withdraw(double amount);
//adds to the current balance and updates it
public int deposit(double amount);
//returns the prevtransaction in String format, or Null if no more history
public double[] next();
public double[]  prev();
//returns the next transaction in String format, or Null if no morehistory
//public String next();
}
