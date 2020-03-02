/*
 *  Class    : User.java 
 *  function : ������� id, ��ȣ, admin�� ���� ������ ������ �ִ�.
 *             get, set �޼ҵ带 ����  �ν��Ͻ� �������� ������ ���ٰ���.
 *  ID       : 201420907
 *  Name     : �ȿ���
 */

package homework1;

import java.util.ArrayList;

public class User {

	private int id;
	private String password;
	private int admin;
	private ArrayList<Book> borrowBookList = new ArrayList<Book>();

	public User(int id, String password, int admin) {
		this.id = id;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public ArrayList<Book> getBorrowBookList() {
		return borrowBookList;
	}

	public void setBorrowBookList(Book book) {
		borrowBookList.add(book);

	}

	public void delBorrowBookList(Book book) {
		borrowBookList.remove(book);

	}
}
