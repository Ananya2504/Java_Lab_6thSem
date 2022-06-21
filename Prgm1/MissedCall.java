import java.time.LocalDateTime;

public class MissedCall {
	String name="private caller";
	long ph;
	LocalDateTime t;
	public MissedCall(long ph) {
		this.ph=ph;
		this.t=LocalDateTime.now();
		for(Contact i:ContactList.getclist()) {
			if(i.ph==ph) {
				this.name=i.name;
				break;
			}
		}
	}
	public String toString() {
		return "Name: "+name+", Phone: "+ph+", Time: "+t;
	}

}
