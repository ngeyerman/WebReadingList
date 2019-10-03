package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;
import model.ListDetails;
import model.Reader;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ListBookHelper lbh = new ListBookHelper();
		String listName = request.getParameter("listName");
		
		System.out.println("List Name: " +listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String readerName = request.getParameter("readerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld=LocalDate.now();
		}
		
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<ListBook> selectedBooksInList = new ArrayList<ListBook>();
		//verify an option was selected otherwise null pointer exception
		if(selectedBooks != null && selectedBooks.length>0) {
			for(int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				ListBook c = lbh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(c);
			}
		}
		
		Reader reader = new Reader(readerName);
		ListDetails sld = new ListDetails(listName, ld, reader);
		sld.setListOfBooks(selectedBooksInList); 
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
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
