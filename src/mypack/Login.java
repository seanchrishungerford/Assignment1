package mypack;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String sql = "select username, password from employee";
		//String sql2 = "insert into employee values('Sean', 'Password')";
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			PreparedStatement pst = conn.prepareStatement(sql);
			//PreparedStatement pst2 = conn.prepareStatement(sql2);
			//ResultSet rs2 = pst2.executeQuery();
			ResultSet rs = pst.executeQuery();
			boolean userFound = false;
			while (rs.next()) {
				String nameStr = rs.getString(1);
				String passStr = rs.getString(2);
				if (name.equals("Sean") && pass.equals("Password")) {
					response.getWriter().println("Login Successful");
					userFound = true;
					HttpSession session= request.getSession();
					Employee e = new Employee();
					session.setAttribute("sesname",request.getParameter("name"));
					response.sendRedirect("Welcome.jsp");
					break;
				}
			}
			if (!userFound) {
				response.getWriter().println("Username and password do not match our records");
				response.sendRedirect("Invalid.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}