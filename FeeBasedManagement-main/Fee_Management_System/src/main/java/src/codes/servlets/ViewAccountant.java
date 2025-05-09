package src.codes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.codes.beans.AccountantBean;
import src.codes.beans.StudentBean;
import src.codes.dao.AccountantDao;
import src.codes.dao.StudentDao;
@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw=rs.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>View Accountant</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		pw.println("<style> table{border:1px solid black;} td a{text-decoration:none; border:1px solid rgb(15, 147, 15); padding:3px;color:white;font-size:15px;border-radius:3px 10px;box-shadow:6px 6px 6px black;background-color:rgb(15, 147, 15);}</style>");
		pw.println("</head>");
		pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("navadmin.html").include(req, rs);
		
		pw.print("<br><h2 class='text-center' style='font-family: Times New Roman, Times, serif;font-weight:bold;  text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;'> Accountant Lists <span class='bi bi-people-fill'></span></h2>");
	
		List<AccountantBean> list=AccountantDao.getAllRecords();
		pw.println("<div class='container-fluid'>");
		pw.println("<table class='table table-hover shadow-lg'>");
		pw.print("<thead class='bg-success text-white text-center rounded-2'><tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th></thead>");
		for(AccountantBean bean:list){
			pw.print("<tbody class='text-center'><tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a style='background-color:blue;border:1px solid blue;padding:2px;border-radius:3px 5px;' href='EditAccountantForm?id="+bean.getId()+"'>Edit</a></td><td><a style='background-color:red;border:1px solid red;padding:2px;border-radius:3px 5px;' href='DeleteAccountant?id="+bean.getId()+"'>Delete</a></td></tr></tbody>");
		}
		pw.println("</table>");
		pw.println("</div><br>");
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}
}
