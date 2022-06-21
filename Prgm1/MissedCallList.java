import java.util.*;

public class MissedCallList {
	Scanner in=new Scanner(System.in);
	ArrayList<MissedCall> mc=new ArrayList<MissedCall>();
	
	public MissedCallList() {
		while(true) {
			System.out.println("Enter yes to give missedcall: ");
			if(in.nextLine().equals("yes")) {
				System.out.println("Enter number: ");
				long num=Long.parseLong(in.nextLine());
				if(mc.size()>4) {
					mc.remove(0);
				}
				mc.add(new MissedCall(num));
			}
			else {
				break;
			}
		}
	}
    public void viewLog() {
    	for(int i=0;i<mc.size();) {
			System.out.println("Enter option for call "+(i+1)+" :\n1.Delete this missedcall\n2.Next\n3.Display this missedcall\n4.exit");
			int n = Integer.parseInt(in.nextLine());
			if(n==1) {
				mc.remove(mc.get(i));
			}
			else if(n==2) {
				i++;
			}
			else if(n==3){
				System.out.println(mc.get(i));
				System.out.println();
			}
			else {
				break;
			}
		}
    }
}
