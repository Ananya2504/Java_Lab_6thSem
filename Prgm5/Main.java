import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RepCust implements ActionListener{

  JFrame f = new JFrame("Data entry");
  JFrame f2 = new JFrame("Filter display");
  
  JLabel rnum = new JLabel("Representative no.");
  JTextField repnum=new JTextField();
  JLabel rn = new JLabel("Representative name");
  JTextField repname=new JTextField();

  JButton repadd= new JButton("Add Representative");

  JLabel cnum = new JLabel("Customer no.");
  JTextField custnum=new JTextField();
  JLabel cn = new JLabel("Customer name");
  JTextField custname=new JTextField();
  JLabel cre = new JLabel("Credit limit");
  JTextField creditlimit=new JTextField();
  JLabel repn=new JLabel("Representative no.");
  JTextField repno=new JTextField();

  JButton custadd= new JButton("Add Customer");

  JButton next= new JButton("Next");

  JTextArea filter = new JTextArea(30,40);
  
 
  public RepCust(){

    f.add(rnum); f.add(repnum);
    f.add(rn);f.add(repname);
    f.add(repadd);
    f.add(cnum); f.add(custnum);
    f.add(cn);f.add(custname);
    f.add(repn); f.add(repno);
    f.add(cre); f.add(creditlimit);
    f.add(custadd);
    f.add(next);

    repadd.addActionListener(this);
    custadd.addActionListener(this);
    next.addActionListener(this);

    f2.add(filter);
    
    f.setSize(300,400);
    f.setLayout(new GridLayout(18,12));
    f.setVisible(true); 
    f2.setSize(300,400);
    f2.setLayout(new GridLayout(1,8));
    
  }
  public void actionPerformed(ActionEvent e){
    try{
    	Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prg5","root","");
      System.out.println("Connection established");
      Statement stmt = conn.createStatement();

      if(e.getSource()==repadd){
        String r="Insert into representative values('"+repnum.getText()+"','"+repname.getText()+"');";
        int i= stmt.executeUpdate(r);
        System.out.println(i+"row added");
      }
      
      else if(e.getSource()==custadd){
        String r="Insert into customer values('"+custnum.getText()+"','"+custname.getText()+"','"+creditlimit.getText()+"','"+repno.getText()+"');";
        int i= stmt.executeUpdate(r);
        System.out.println(i+"row added");
      }
      
      else if(e.getSource()==next){
        f2.setVisible(true);
        String n = "Select * from Representative where repno in (Select repno from Customer where credit_limit>'15000');";
        ResultSet rs = stmt.executeQuery(n);
        while(rs.next()){
          filter.append("Representative num : "+repnum.getText()+"\nRepresentative name :"+repname.getText());
        }
        
      }
    }
    catch(Exception s){
      System.out.println(s);
    }
    
    
  }
}

class Main {
  public static void main(String[] args) {
    
    RepCust rc = new RepCust();
   
  }
}
