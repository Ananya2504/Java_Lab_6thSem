import java.util.*;

public class BookList {
	Scanner sc=new Scanner(System.in);
	HashMap<Integer,Book> hm=new HashMap<>();
	LinkedList<Book> lbook = new LinkedList<Book>();
	public void BookHashmap(ArrayList<Book> ba)
	{ 
		int i=1;
		for(Book b1:ba)
		{
			hm.put(i,b1);
			i++;
		}
	}

	public void getInput(ArrayList<Book> al) {
		while(true) {
			System.out.println("Do u want to enter details of books? Yes or No: ");
			if(sc.nextLine().equals("Yes")) {
				System.out.println("Enter Title: ");
				String title=sc.nextLine();
				System.out.println("Enter Author: ");
				String author=sc.nextLine();
				System.out.println("Enter Publisher: ");
				String publisher=sc.nextLine();
				System.out.println("Enter Price: ");
				double price=Double.parseDouble(sc.nextLine());
				Book b=new Book(title,author,publisher,price);
				al.add(b);
			}
			else {
				break;
			}
		}
	}
	
	public void printHashMap() {
		for(Map.Entry<Integer,Book> entry: hm.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
	}
	
	public void search_book(String t,ArrayList<Book> al){
        int l=t.length();
        for(Book b:al){
            int l2=b.title.length();
            if(b.title.substring(l2-l,l2).equals(t)){
                System.out.println(b);
            }
        }
    }
	
	public void search_pub(String p) {
		for(Map.Entry<Integer, Book> s:hm.entrySet())
		{
			Book b1=s.getValue();
			if(b1.publisher.equals(p))
			{
				System.out.println(b1);
			}
	    }
	}
	
	public void search_auth(String a) {
		for(Map.Entry<Integer, Book> s:hm.entrySet())
		{ 
			Book b1=s.getValue();
			String s1 =b1.author;
			if(s1.equals(a))
			{
			    System.out.println(s.getValue());
			}
		}
	}
	
	public void group_price(double p) {
		for(Map.Entry<Integer, Book> s:hm.entrySet())
		{ 
			Book b1=s.getValue();
			if(b1.price>p)
			{
				lbook.add(b1);
			}
		}
		System.out.println("Books with price > than "+p);
		for(Book b:lbook)
		{
			System.out.println(b);
		}
	}
	
	public void update_pub(String t,String pub) {
		for(Map.Entry<Integer, Book> s:hm.entrySet())
		{ 
			Book b1=s.getValue();
			if(b1.title.equals(t))
			{
				b1.publisher=pub;
				hm.put(s.getKey(), b1);
			}
		}
		printHashMap();
	}

}


