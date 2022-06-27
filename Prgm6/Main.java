import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Hosp implements ActionListener{

  JFrame f = new JFrame("Data entry");
  JFrame f2 = new JFrame("Filter display");
  
  JLabel mi = new JLabel("Medicine ID");
  JTextField medid=new JTextField();
  JLabel mn = new JLabel("Medicine name");
  JTextField medname=new JTextField();

  JButton medadd= new JButton("Add Medicine");

  JLabel pnum = new JLabel("Patient no.");
  JTextField patnum=new JTextField();
  JLabel pn = new JLabel("Patient name");
  JTextField pname=new JTextField();
  JLabel pdis = new JLabel("Patient Disease");
  JTextField patdis=new JTextField();
  JLabel mid=new JLabel("Medicine ID given");
  JTextField medicineid=new JTextField();

  JButton patadd= new JButton("Add Patient");

  JButton findPat1= new JButton("Find Patient by Disease");
  JTextField searchdis=new JTextField();
  JButton findPat2=new JButton("Find Patient by Medicine");
  JTextField searchmed=new JTextField();
  JTextArea filter = new JTextArea(30,40);
  
 
  public Hosp(){

    f.add(mi); f.add(medid);
    f.add(mn);f.add(medname);
    f.add(medadd);
    f.add(pnum); f.add(patnum);
    f.add(pn);f.add(pname);
    f.add(pdis); f.add(patdis);
    f.add(mid); f.add(medicineid);
    f.add(patadd);
    f.add(findPat1);
    f.add(searchdis);
    f.add(findPat2);
    f.add(searchmed);

    medadd.addActionListener(this);
    patadd.addActionListener(this);
    findPat1.addActionListener(this);
    findPat2.addActionListener(this);
    
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prg6","root","");
      System.out.println("Connection established");

      if(e.getSource()==medadd){
        String r="Insert into medicine values('"+medid.getText()+"','"+medname.getText()+"');";
        PreparedStatement stmt = conn.prepareStatement(r);
        stmt.executeUpdate();
      }
      
      else if(e.getSource()==patadd){
        String r="Insert into patient values('"+patnum.getText()+"','"+pname.getText()+"','"+patdis.getText()+"','"+medicineid.getText()+"');";
        PreparedStatement stmt = conn.prepareStatement(r);
        stmt.executeUpdate();
      }
      
      else if(e.getSource()==findPat1){
        f2.setVisible(true); 
        String disname=searchdis.getText();
        String n = "Select * from patient where disease=?";
        PreparedStatement stmt = conn.prepareStatement(n);
        stmt.setString(1,disname);    
        ResultSet rs = stmt.executeQuery();
        filter.setText("");
        while(rs.next()){
          filter.append("Patient num : "+rs.getString("patient_num")+"\nPatient name :"+rs.getString("patient_name")+"\n");
        }
        
      }
      else if(e.getSource()==findPat2){
    	  f2.setVisible(true); 
          String medicinename=searchmed.getText();
          String s = "Select * from patient where medid in (Select medid from medicine where medname=?)";
          PreparedStatement stmt = conn.prepareStatement(s);
          stmt.setString(1,medicinename);
          ResultSet rs = stmt.executeQuery();
          filter.setText("");
          while(rs.next()){
            filter.append("Patient num : "+rs.getString("patient_num")+"\nPatient name :"+rs.getString("patient_name")+"\n");
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
    
    Hosp h = new Hosp();
   
  }
}
