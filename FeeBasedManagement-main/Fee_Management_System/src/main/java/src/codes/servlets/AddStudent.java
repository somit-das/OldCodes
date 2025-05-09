
package src.codes.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.codes.beans.StudentBean;
import src.codes.dao.StudentDao;

import java.sql.*;
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw=rs.getWriter();
		
		int rollno=Integer.parseInt(req.getParameter("rno"));
		String name=req.getParameter("name");
	 	String email=req.getParameter("email");
		String sex=req.getParameter("sex");
		String course=req.getParameter("course");
		int fee=Integer.parseInt(req.getParameter("fee"));
		int paid=Integer.parseInt(req.getParameter("paid"));
		int due=Integer.parseInt(req.getParameter("due"));
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
		
		StudentBean bean=new StudentBean(rollno, name, email, sex, course, fee, paid, due, address, contact);
		int status=StudentDao.save(bean);
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Add Student</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		pw.println("</head>");
		pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
		
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("navaccountant.html").include(req, rs);
		
		pw.println("<div class='row'><div class='col-2'></div><div class='col-10'><br><b style='color:blue;font-size:27px;'>Student is Added Successfully <span class='bi bi-person-check-fill'></span></b></div></div>");
		
		req.getRequestDispatcher("AddStudentForm.html").include(req, rs);
		pw.println("<br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	private int parseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
