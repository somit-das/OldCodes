package src.codes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.codes.dao.AccountantDao;
import src.codes.dao.StudentDao;
@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
				AccountantDao.delete(id);
		response.sendRedirect("ViewAccountant");
	}
}
