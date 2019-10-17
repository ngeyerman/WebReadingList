package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reader")

public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "READER_ID")
	private int id;
	@Column(name = "READER_NAME")
	private String readerName;

	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reader(int id, String readerName) {
		super();
		this.id = id;
		this.readerName = readerName;
	}
	
	

	public Reader(String readerName) {
		super();
		this.readerName = readerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", readerName=" + readerName + "]";
	}

}
