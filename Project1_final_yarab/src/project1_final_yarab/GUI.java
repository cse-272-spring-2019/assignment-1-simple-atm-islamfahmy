/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_final_yarab;

import static java.awt.SystemColor.text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Islam
 */
public class GUI extends Application {

    user newu = new user("5785", 0);

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        Label idlabel = new Label("Enter your id : ");
        Label validation = new Label();
        TextField idfield = new TextField();
        Button submit = new Button("Submit");
        GridPane grid = new GridPane();
        grid.add(idlabel, 4, 10);
        grid.add(idfield, 5, 10);
        grid.add(submit, 5, 12);
        grid.add(validation, 5, 13);
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String id = idfield.getText();
                System.out.println(id);
                if (newu.validateid(id) == 1) {
                    /// primaryStage.close();
                    mid(primaryStage);
                } else {
                    validation.setText("Wrong iD right iD = 5785");

                }

            }
        });

        primaryStage.show();
    }

    public void mid(Stage primaryStage) {
        primaryStage.setTitle("Welcome");
        Button with = new Button("withdraw");
        Button deposit = new Button("Deposit");
        Button inquire = new Button("Balnce inquiry");
        Button history = new Button("History");
        GridPane grid = new GridPane();
        grid.add(with, 0, 0);
        grid.add(deposit, 1, 0);
        grid.add(inquire, 2, 0);
        grid.add(history, 3, 0);
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                deposit(primaryStage);
            }
        });
        inquire.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                inquire(primaryStage);
            }
        });
        with.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                withdraw(primaryStage);
            }
        });
        history.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               history(primaryStage);
            }
        });
        
     
    
                    
    }

    public void deposit(Stage primaryStage) {
        primaryStage.setTitle("Deposit");
        TextField balance = new TextField();
        Label message = new Label();
        Button deposit = new Button("Deposit");
        GridPane grid =new GridPane();
        grid.add(balance, 4, 0);
        grid.add(deposit, 3, 1);
        grid.add(message, 3, 2);
        String string = balance.getText();
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String string = balance.getText();
                if (newu.deposit(Double.parseDouble(string)) == 0) {
                    message.setText("-ve !!! please enter +ve value");

                } else {
                    message.setText("succesfull");
                    mid(primaryStage);
                }
            }
        });
         Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
     public void withdraw(Stage primaryStage) {
        primaryStage.setTitle("Withdraw");
        TextField balance = new TextField();
        Label message = new Label();
        Button deposit = new Button("Withdraw");
        GridPane grid =new GridPane();
        grid.add(balance, 4, 0);
        grid.add(deposit, 3, 1);
        grid.add(message, 3, 2);
        String string = balance.getText();
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String string = balance.getText();
                int x=newu.withdraw(Double.parseDouble(string));
                if (x == -1) {
                    message.setText("-ve !!! please enter +ve value");

                } else if (x== 0) {
                    message.setText("insufficient funds");
                    
                } else 
                {
                    message.setText("succesfull");
                    mid(primaryStage);
                }
            }
        });
         Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
     public void inquire(Stage primaryStage) {
        primaryStage.setTitle("Inquire");
        double x= newu.getCurrentBalance();
        Label message = new Label("your balance = "+ x);
        GridPane grid=new GridPane();
        Button deposit = new Button("Back");
        grid.add(message, 0, 0);
        grid.add(deposit, 1, 0);
         deposit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { mid(primaryStage);
            }
            });
         Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
         //mid(primaryStage);

    }
      public void history(Stage primaryStage) {
        primaryStage.setTitle("History");
        Label message = new Label();
        GridPane grid=new GridPane();
        Button back = new Button("Back");
        Button next =new Button("Next");
        Button prev= new Button("Prev.");
        grid.add(message, 2, 0);
        grid.add(prev, 1, 0);
        grid.add(next, 1, 2);
        grid.add(back, 1, 3);
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { mid(primaryStage);
            }
            });
         next.setOnAction(new EventHandler<ActionEvent>() {
             
             
            public void handle(ActionEvent event) {double x[]=newu.next();
            if(x[1]==-1)
                message.setText("no further transactions");
            else {
                if(x[1]==0)
                    message.setText("operation type = Balance inquiry Balance = "+x[0]);
                if(x[1]==1)
                    message.setText("operation type = Withdraw Balance = "+x[0]);
                if(x[1]==2)
                    message.setText("operation type = deposit Balance = "+x[0]);
                
                
            }
            }
            });
          prev.setOnAction(new EventHandler<ActionEvent>() {
             
             
            public void handle(ActionEvent event) {double x[]=newu.prev();
            if(x[1]==-1)
                message.setText("no further transactions");
            else {
                if(x[1]==0)
                    message.setText("operation type = Balance inquiry Balance = "+x[0]);
                if(x[1]==1)
                    message.setText("operation type = Withdraw Balance = "+x[0]);
                if(x[1]==2)
                    message.setText("operation type = deposit Balance = "+x[0]);
                
                
            }
            }
            });
         
       
         
         Scene scene = new Scene(grid, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
         //mid(primaryStage);

    }
     

    public static void main(String[] args) {
        launch(args);

    }

}
