package els.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Reg")
public class Prompt2 {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String courseId = request.getParameter("courseId");
		String[] languages = request.getParameterValues("language");
		
		String langList = "";
		for (String langs : languages) {
			langList = langList + langs + " ";
		}
		
		PrintWriter out = response.getWriter();
		out.println("Name: " + name);
		out.println("Age: " + age);
		out.println("Gender: " + gender);
		out.println("Course ID: " + courseId);
		out.println("Languages: " + langList);
	}

}