import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		BookList bl=new BookList();
		ArrayList<Book> al=new ArrayList<Book>();
		bl.getInput(al);
		ArrayList<Book> booklist=new ArrayList<Book>();
		for(Book b:al) 
			booklist.add(b);
		booklist.sort(new BookCompare());
		System.out.println("After sorting: ");
		for(Book b:booklist)
			System.out.println(b);
		bl.BookHashmap(booklist);
		System.out.println("Enter the title of book to search: ");
		String t=sc.nextLine();
		bl.search_book(t, al);
		System.out.println("Enter auth name to search his books: ");
		String a=sc.nextLine();
		bl.search_auth(a);
		System.out.println("Enter publisher name to search for books: ");
		String p=sc.nextLine();
		bl.search_pub(p);
		System.out.println("Enter title of book whose publisher you wish to update:");
		String ut=sc.nextLine();
		System.out.println("Enter new publisher details: ");
		String up=sc.nextLine();
		bl.update_pub(ut,up);
		sc.close();
	}
}

