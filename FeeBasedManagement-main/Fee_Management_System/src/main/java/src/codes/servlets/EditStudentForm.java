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
@WebServlet("/EditStudentForm")
public class EditStudentForm extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		PrintWriter pw=rs.getWriter();
		String srollno=req.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentBean bean=StudentDao.getRecordByRollno(rollno);
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Edit Student Form</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		
		pw.println("</head>");
		pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
		
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("navaccountant.html").include(req, rs);
		
		pw.println("<br><div class='row'><div class='col-2'></div><div class='col-4'>");
		pw.println("<div class='p-5 w-100 shadow-lg rounded-4' style='border:1 px solid black;'>");
		pw.println("<img src='resources/images/stu.png'height='90'width='90' class='img-fluid d-block mx-auto' style='border-radius:50%;border:1px solid black;'><b class='mx-5 text-success' style='font-size:25px;font-family: Times New Roman, Times, serif;'>Edit Student Form</b><br><br>");
		
		pw.print("<form action='EditStudent' method='post'>");
		
		pw.print("<input type='hidden' name='rollno' value='"+bean.getRollno()+"'/>");
		pw.print("<b class='form-label'><span class='bi bi-box2-heart-fill'></span> Name</b><input class='form-control' type='text' name='name' value='"+bean.getName()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-envelope-fill'></span> Email</b> <input class='form-control' type='email' name='email' value='"+bean.getEmail()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-gender-ambiguous'></span> Sex</b> <input class='form-control' type='text' name='sex' value='"+bean.getSex()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-book-half'></span> Course</b> <input class='form-control' type='text' name='course' value='"+bean.getCourse()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-currency-rupee'></span> Fee</b> <input class='form-control' type='number' name='fee' value='"+bean.getFee()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-currency-pound'></span> Paid</b><input class='form-control type='number' name='paid'  value='"+bean.getPaid()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-currency-euro'></span> Due</b><input class='form-control' type='number' name='due'  value='"+bean.getDue()+"'required/>");
		pw.print("<b class='form-label'><span class='bi bi-geo-alt-fill'></span> Address</b><textarea class='form-control' name='address'>"+bean.getAddress()+"</textarea>");
		pw.print("<b class='form-label'><span class='bi bi-phone-fill'></span> Contact No</b><input class='form-control' type='text' placeholder='+91' name='contact' value='"+bean.getContact()+"'required/><br><br>");
		pw.print("<button type='submit' class='btn btn-outline-success w-100'>Update Student <span class='bi bi-arrow-clockwise'></span></button>");
		pw.print("</table>");
		pw.print("</form>");
		
		pw.println("</div></div><div class='col-6'></div></div><br><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		pw.println("</body>");
		pw.println("</html>");
				
		pw.close();
	}

}
