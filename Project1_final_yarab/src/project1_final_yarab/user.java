/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_final_yarab;

import java.util.ArrayList;

public class user implements ATM {
     int flag =1;
    private String iD;
    private double balance;
    int start = 0;
    int max = 0;
    ArrayList<Double> history = new ArrayList<Double>();
    ArrayList<Integer> historytype = new ArrayList<Integer>();

    public user(String iD, double balance) {
        this.iD = iD;
        this.balance = balance;
    }

    public double getCurrentBalance() {
        addhistory(balance, 0);
        return balance;

    }

    private void addhistory(double x, int type) {
        if (history.size() < 5) {
            history.add(x);
            historytype.add(type);
            start++;
            max++;
        } else {
            history.remove(0);
            history.add(x);
            historytype.remove(0);
            historytype.add(type);
        }
    }

    public int withdraw(double amount) {
        start = max;
        if (amount < 0) {
            return -1;
        } else 
            if (balance < amount) {
                return 0;
            } else {
                balance -= amount;
                //amount*=-1;

                addhistory(amount, 1);
                return 1;
            }
        }
    

    public int deposit(double amount) {
        start = max;
        if (amount < 0) {
            return 0;
        } else {
            addhistory(amount, 2);
            balance += amount;
return 1;
        }
    }

    public double[] next() {
        flag=1;
        if (++start >= max) {
            double a[] = {0, -1};
            start--;
            return a;
        } else {
            double have = history.get(start);
            int type = historytype.get(start);
            double a[]={have,type};
            return a;
        }

    }

    public double[] prev() {
        if(history.size()==1&&flag==1) {flag=0;double a[]= {history.get(0),historytype.get(0)};start=-1;return a;}
        else if (--start <0) {
            double a[] = {0, -1};
            start++;
            return a;
        } else {
            double have = history.get(start);
            int type = historytype.get(start);
            if (type == 0) {
                double a[] = {have, 0};
                return a;
            } else if (type == 1) {
                double a[] = {have, 1};
                return a;
            }
             else {
                double a[] = {have, 2};
                return a;
            }
        } 
        }

    

    public int validateid(String iD) {
        System.out.println(this.iD+" "+iD);
        if (Integer.parseInt(this.iD) == Integer.parseInt(iD)) {
            return 1;
        }
        return 0;
    }

}


/*public void setHistory(int history) {
        
        if(entryCounter<0)
        {  if(c==true){history2[4]=history;
           for(int i=3;i>=0;i--)
               history2[i]=history1[i+1];
           c=false;
        }else{
            history1[4]=history;
           for(int i=3;i>=0;i--)
               history1[i]=history2[i+1];
           c=true;
        }
            
        }else{
        history1[entryCounter--] = history;
    }
    }
    public void getHistory(int i) {
        if(i==1)
          navCounter++;
        else navCounter--;
        if(navCounter>4)
        { System.out.println("exceeded number of transactions");navCounter=4;}
        else if(navCounter<0);
        { System.out.println("exceeded number of transactions");navCounter=0;}  
        
        }

    public void setBalance(double balance) {
        this.balance = balance;
    }*/
