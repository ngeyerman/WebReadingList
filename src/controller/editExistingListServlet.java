package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;
import model.ListDetails;
import model.Reader;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ListDetailsHelper slh = new ListDetailsHelper();
		ListBookHelper lbh = new ListBookHelper();
		ReaderHelper rh = new ReaderHelper();
		//search for object to make changes to
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails toEdit =slh.searchForListByID(idToEdit);
		
		//update the listName
		String listName = request.getParameter("listName");
		System.out.println("List Name: " +listName);
		toEdit.setListName(listName);
		
		//update the date
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld=LocalDate.now();
		}
		toEdit.setReadDate(ld);
		
		//update the reader
		String readerName = request.getParameter("readerName");
		Reader reader;
		try {
			reader = rh.searchForReaderByName(readerName);
		} catch(NoResultException ex) {
			reader = new Reader(readerName);
		} catch(Exception ex) {
			reader = new Reader(readerName);
		}
		toEdit.setReader(reader);
		
		//update list of items
		List<ListBook> previousListOfBooks = toEdit.getListOfBooks(); 
		
		String[] selectedBooks	= request.getParameterValues("booksToAdd");
		List<ListBook> selectedBooksInList = new ArrayList<ListBook>();
		
		if(selectedBooks != null && selectedBooks.length> 0) {
			for(int i = 0; i< selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				ListBook c = lbh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(c);
			}
			previousListOfBooks.addAll(selectedBooksInList);
		}
		
		toEdit.setListOfBooks(previousListOfBooks);
		
		slh.updateList(toEdit);
		
		System.out.println("Success!");
		System.out.println(toEdit.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
