import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection c;
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosp","root","");
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String age = request.getParameter("age");
			String doa = request.getParameter("doa");
			String cause = request.getParameter("cause");
			String doc = request.getParameter("doc");
			String treatment = request.getParameter("treatment");
			String sql = "insert into patients values(?,?,?,?,?,?,?)";
			
			PreparedStatement st= c.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,id);
			st.setString(3,age);
			st.setString(4,doa);
			st.setString(5,cause);
			st.setString(6,doc);
			st.setString(7,treatment);
			st.executeUpdate();
			
			response.getWriter().append("inserted");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			response.getWriter().append("error"+e.toString());
		}	
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
