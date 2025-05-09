package src.codes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SearchStudentForm")
public class SearchStudentForm extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw=rs.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Search Student Form</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		pw.println("</head>");
		pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
		
		
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("navaccountant.html").include(req, rs);
		 
		pw.println("<br>");
		req.getRequestDispatcher("SearchStudentForm.html").include(req, rs);
		pw.println("<br><br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}
}
