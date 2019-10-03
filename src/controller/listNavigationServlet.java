package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;
import model.ListDetails;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listNavigationServlet() {
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
		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			// no button selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListByID(tempId);
				ldh.deleteItem(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

			}
		}

		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = ldh.searchForListByID(tempId);
				ListBookHelper lbh = new ListBookHelper();
				List<ListBook> allBooks = lbh.showAllBooks();
				List<ListBook> currentListBooks = listToEdit.getListOfBooks();

				System.out.println("-----After removing items------");
				for (int i = 0; i < allBooks.size(); i++) {
					for (int j = 0; j < currentListBooks.size(); j++) {
						if (allBooks.get(i).getId() == currentListBooks.get(j).getId()) {
							allBooks.remove(i);
						}
					}
				}

				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("allBooksToAdd", allBooks);
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addBooksForListServlet").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
