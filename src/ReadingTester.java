import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ReaderHelper;
import model.ListBook;
import model.ListDetails;
import model.Reader;

public class ReadingTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reader neil = new Reader("Neil");
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListBook prey1 = new ListBook("Rules of Prey", "Stanford", "fiction");
		ListBook zooKeeper = new ListBook("Zookeeper's Wife", "Ackerman", "non-fiction");
		List<ListBook> neilBooks = new ArrayList<ListBook>();
		neilBooks.add(prey1);
		neilBooks.add(zooKeeper);
		
		ListDetails neilsList = new ListDetails("Neil's BookList", LocalDate.now(), neil);
		neilsList.setListOfBooks(neilBooks);
		
		ldh.insertNewListDetails(neilsList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
		/*Reader neil = new Reader("Neil");
		ReaderHelper rh = new ReaderHelper();
		
		rh.insertReader(neil);

		List<Reader> allReaders = rh.showAllReaders();
		for(Reader a: allReaders) {
			System.out.println(a.toString());*/
		
		/*Reader grandpa = new Reader("Grandpa");
		ReaderHelper rh = new ReaderHelper();
		
		rh.insertReader(grandpa);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails grandpaList = new ListDetails("Grandpa's List", LocalDate.now(), grandpa);
		
		ldh.insertNewListDetails(grandpaList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());*/
		
			
			
		}
	

}
