package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");

		ListBook li = new ListBook(title, author, genre);
		ListBookHelper dao = new ListBookHelper();
		dao.insertBook(li);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}