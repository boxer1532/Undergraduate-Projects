/*
 *  Class    : Book.java 
 *  function : å�� id, ����, �۰�, ���¿� ���� ������ ������ ����.
 *             get, set �޼ҵ带 ����  �ν��Ͻ� �������� ������ ���ٰ���.
 *  ID       : 201420907
 *  Name     : �ȿ���
 */

package homework1;

public class Book {

	private static int numID = 0; //numID�� ���ڷ� ID�� ����
	private int id = 0;
	private int status;
	private String title;
	private String author;

	public Book() {
		
		numID = numID + 1;

		this.status = 1;
		this.id = numID;
	}

	public Book(String title, String author) {

		numID = numID + 1;

		this.id = numID;
		this.title = title;
		this.author = author;
		this.status = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public static int getNumID() {
		return numID;
	}

	public static void setNumID(int numID) {
		Book.numID = numID;
	}

}
