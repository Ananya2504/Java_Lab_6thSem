import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosp","root","");
			String sql = "select * from patients where name=?";
			String name = request.getParameter("name");
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1,name);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				response.getWriter().append("Name: "+r.getString("name")+"\n");
				response.getWriter().append("ID: "+r.getString("id")+"\n");
				response.getWriter().append("Age: "+r.getString("age")+"\n");
				response.getWriter().append("DOA: "+r.getString("doa")+"\n");
				response.getWriter().append("Cause: "+r.getString("cause")+"\n");
				response.getWriter().append("Doctor: "+r.getString("doc")+"\n");
				response.getWriter().append("Treatment: "+r.getString("treatment")+"\n");
			}
		}catch(Exception e) {
			response.getWriter().append(e.toString());

		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}