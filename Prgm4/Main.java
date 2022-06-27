import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.*;

class CustomerInterface implements ActionListener{

  JFrame f1 = new JFrame("login");
  JFrame f2 = new JFrame("customerid");
  JFrame f3 = new JFrame("customer item purchased");

  JLabel u = new JLabel("Username");
  JTextField username= new JTextField();
  JLabel p = new JLabel("Password");
  JTextField password= new JTextField();
  JButton validate = new JButton("Validate");

  JLabel ph = new JLabel("PhoneNumber");
  JTextField phone= new JTextField();
  JLabel cid = new JLabel("CustomerId");
  JTextField customerid= new JTextField();
  JButton fetch = new JButton("Fetch customerid");
  JButton next = new JButton("Next");

  JLabel i = new JLabel("Item id");
  JTextField itemid= new JTextField();
  JLabel q = new JLabel("Quantity");
  JTextField quantity= new JTextField();
  JButton print = new JButton("Generate bill");
  JTextArea bill = new JTextArea(30,40);

  HashMap<String,String> ids = new HashMap<>();
  HashMap<String,Integer> items = new HashMap<>();
  double discount;

  public CustomerInterface(){
    
    discount=0.3;

    ids.put("123","c1");
    ids.put("345","c2");

    items.put("i1",234);
    items.put("i2",123);
    
    f1.add(u);f1.add(username);
    f1.add(p); f1.add(password);
    f1.add(validate);
    validate.addActionListener(this);

    f2.add(ph);f2.add(phone);
    f2.add(cid); f2.add(customerid);
    f2.add(fetch);
    fetch.addActionListener(this);
    f2.add(next);
    next.addActionListener(this);

    f3.add(i);f3.add(itemid);
    f3.add(q);f3.add(quantity);
    f3.add(print);
    f3.add(bill);
    print.addActionListener(this);

    
    f1.setSize(300,400);
    f1.setLayout(new GridLayout(10,8));
    f1.setVisible(true);
    f2.setSize(300,400);
    f2.setLayout(new GridLayout(10,8));
    f3.setSize(300,400);
    f3.setLayout(new GridLayout(6,8));
  }
  public void actionPerformed(ActionEvent e){
    
    if(e.getSource()==validate){
      if(username.getText().equals("admin") && password.getText().equals("admin123")){
        
        f2.setVisible(true);
      }
      else{
        username.setForeground(Color.RED);
        password.setForeground(Color.RED);
      }
    }
    
    else if(e.getSource()==fetch){
      customerid.setText(ids.get(phone.getText()));
                 
    }

    else if(e.getSource()==next){
      
      f3.setVisible(true);
    }
    else if(e.getSource()==print){
      int total=Integer.parseInt(quantity.getText())*items.get(itemid.getText());
      bill.setText(itemid.getText()+"\nTotal : "+total+"\nDiscount : 30%\nFinal : "+ discount*total);
      
    }
  }   
}

class Main {
  
  public static void main(String[] args) {
    CustomerInterface ci=new CustomerInterface();
  }
}
