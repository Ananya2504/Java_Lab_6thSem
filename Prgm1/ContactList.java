import java.util.*;
public class ContactList {
	Scanner sc=new Scanner(System.in);
	static ArrayList<Contact> c=new ArrayList<Contact>();
	public ContactList() {
		while(true) {
			System.out.println("Enter 1 to enter, 0 to exit");
			if(sc.nextLine().equals("1")) {
				System.out.println("Enter name: ");
				String name=sc.nextLine();
				System.out.println("Enter phone number: ");
				long phone=sc.nextLong();
				sc.nextLine();
				Contact cs=new Contact(name,phone);
				c.add(cs);
			}
			else {
				break;
			}
		}	
	}
	public static ArrayList<Contact> getclist(){
		return c;
	}
	public void viewList() {
		for(Contact i:c)
			System.out.println(i);
	}
}
