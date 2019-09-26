package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public navigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		ListBookHelper dao = new ListBookHelper();
		String act = request.getParameter("doThisToBook");

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);

		} else if (act.equals("Delete Book")) {

			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListBook bookToDelete = dao.searchForBookById(tempId);
				dao.deleteBook(bookToDelete);

			} catch (NumberFormatException e) {
				System.out.println("You must click a button.");
			} finally {

				getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);

			}

		} else if (act.equals("Edit Book")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListBook bookToEdit = dao.searchForBookById(tempId);
				request.setAttribute("bookToEdit", bookToEdit);
				getServletContext().getRequestDispatcher("/edit-book.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
			}
		} else if (act.equals("Add Book")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}
	}

}
