package els.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LogIn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rset;
		
		try {
			
			Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root");
			pstmt = conn.prepareStatement("Select * from training.account where username = ? and password = ?");
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				out.println("Welcome " + userName);
			} else {
				out.println("Invalid Credentials...Please try again...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
