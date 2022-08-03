package els.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/regs")
public class Prompt3 extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Connection conn;
		Statement stmt;
		ResultSet rset;
		
		try {
			Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery("select * from training.account");
			
			PrintWriter out = res.getWriter();
			
			out.println("Registered Users : ");
			
			while(rset.next()) {
				out.println(rset.getString(1) + " " + rset.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

