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
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw=rs.getWriter();
		String srollno=req.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentBean bean=StudentDao.getRecordByRollno(rollno);
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Search Student</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		pw.println("</head>");
	    pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
			
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("navaccountant.html").include(req, rs);
		
		if(bean.getRollno()>0){
		pw.print("<br><br><div class='row'><div class='col-4'></div><div class='col-3'><div class='p-4 w-100 rounded-3 text-dark'style='background-color:#00d2d3;box-shadow:13px 13px 13px black;'>");
		pw.print("<img src='resources/images/nitnav.png' class='img-fluid d-block mx-auto'>");
		pw.print("<b style='text-align:center;font-size:22px;color:deeppink;font-family: Times New Roman, Times, serif;text-decoration:underline'>Searched Student Details</b><br><br>");
		pw.print("<div class='row'><div class='col-4'><b>Rollno:<br>Name:<br>Email:<br>Sex:<br>Course:<br>Fee:</b></div>");
		pw.print("<div class='col-8'>"+bean.getRollno()+"<br>"+bean.getName()+"<br>"+bean.getEmail()+"<br>"+bean.getSex()+"<br>"+bean.getCourse()+"<br>"+bean.getFee()+"<br></div></div>");
		pw.print("</div><div class='col-5'></div></div></div>");
		pw.println("<br><br><br>");
		}else{
			pw.println("<div class='row'><div class='col-4'></div><div class='col-4'><br><b style='color:red;font-size:17px; font-family: Times New Roman, Times, serif;'>Sorry,No Records Found For RollNo "+rollno+"</b></div><div class='col-4'></div></div>");
			req.getRequestDispatcher("SearchStudentForm.html").include(req, rs);
			pw.println("<br><br>");
		}
		
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}
}
