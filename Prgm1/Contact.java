public class Contact {
	long ph;
	String name;
	public Contact(String name,long ph) {
		this.name=name;
		this.ph=ph;
	}
	public String toString() {
		return "Name: "+name+", Phone: "+ph;
	}
}
