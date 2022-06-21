public class Book {
	String title,author,publisher;
	double price;
	public Book(String t,String a,String p,double pr) {
		title=t;
		author=a;
		publisher=p;
		price=pr;
	}
	public String toString() {
		return "Title: "+title+", Author: "+author+", Publisher: "+publisher+", Price: "+price;
	}
}
