package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class editBookServlet
 */
@WebServlet("/editBookServlet")
public class editBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ListBookHelper dao = new ListBookHelper();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListBook bookToUpdate = dao.searchForBookById(tempId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setAuthor(author);
		bookToUpdate.setGenre(genre);
		
		dao.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
		doGet(request, response);
		
	}

}
