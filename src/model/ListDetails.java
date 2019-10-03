package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="READ_DATE")
	private LocalDate readDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="READER_ID")
	private Reader reader;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				name="BOOKS_ON_LIST",
				joinColumns= {@JoinColumn(name="LIST_ID",
				referencedColumnName="LIST_ID")},
				inverseJoinColumns= {@JoinColumn(name="BOOK_ID",
				referencedColumnName="ID", unique=true)}
				)
	private List<ListBook> listOfBooks;
	
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ListDetails(int id, String listName, LocalDate readDate, Reader reader, List<ListBook> listOfBooks) {
		super();
		this.id = id;
		this.listName = listName;
		this.readDate = readDate;
		this.reader = reader;
		this.listOfBooks = listOfBooks;
	}


	public ListDetails(String listName, LocalDate readDate, Reader reader, List<ListBook> listOfBooks) {
		super();
		this.listName = listName;
		this.readDate = readDate;
		this.reader = reader;
		this.listOfBooks = listOfBooks;
	}


	public ListDetails(String listName, LocalDate readDate, Reader reader) {
		super();
		this.listName = listName;
		this.readDate = readDate;
		this.reader = reader;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getListName() {
		return listName;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public LocalDate getReadDate() {
		return readDate;
	}


	public void setReadDate(LocalDate readDate) {
		this.readDate = readDate;
	}


	public Reader getReader() {
		return reader;
	}


	public void setReader(Reader reader) {
		this.reader = reader;
	}


	public List<ListBook> getListOfBooks() {
		return listOfBooks;
	}


	public void setListOfBooks(List<ListBook> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}


	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", readDate=" + readDate + ", reader=" + reader
				+ ", listOfBooks=" + listOfBooks + "]";
	}
	
	
	
	
	
	

}
