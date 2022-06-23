import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/controller")
public class controller extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public controller() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name=request.getParameter("name");
		int salary=Integer.parseInt(request.getParameter("salary"));
		int taxdeduction=Integer.parseInt(request.getParameter("taxdeduction"));
		response.getWriter().append(name);
		try {
			FileWriter writer=new FileWriter("/home/ritadmin/eclipse-workspace/IT_Tax/src/main/webapp/salary.txt");
			writer.write("Name : "+name+"\nSalary: "+String.valueOf(salary)+"\nTax Deduction: "+String.valueOf(taxdeduction)+"\n");
			System.out.println("Stored in file");
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name=request.getParameter("name");
		response.getWriter().append(name);
		doGet(request,response);
	}

}
