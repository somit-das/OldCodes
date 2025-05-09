package src.codes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw=rs.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Admin Logout</title>");
		pw.println("<link rel='stylesheet' href='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css'>");
		pw.println("<script src='https:/cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>");
		pw.println("<link rel='stylesheet' href='resources/bootstrap-icons/font/bootstrap-icons.css'>");
		pw.println("<link rel='stylesheet' href='textstyle.css'/>");
		pw.println("<link rel='stylesheet' href='style.css'/>");
		pw.println("<link rel='stylesheet' href='footer.css'/>");
		pw.println("</head>");
		pw.println("<body style='background-image:url(resources/images/bg1.webp);background-size:cover;'>");
		
		req.getRequestDispatcher("font.html").include(req, rs);
		req.getRequestDispatcher("mainNavbar.html").include(req, rs);
		
		pw.println("<div class='row'><div class='col-2'></div><div class='col-10'><br><b style='color:blue;margin-left:25px;font-size:30px;'>Admin Logout Success <span class='bi bi-check-circle-fill'></span></b></div></div>");
		HttpSession session=req.getSession();
		session.invalidate();
		req.getRequestDispatcher("AdminLoginForm.html").include(req, rs);
		
		req.getRequestDispatcher("footer.html").include(req, rs);
		req.getRequestDispatcher("contactModal.html").include(req, rs);
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

}
