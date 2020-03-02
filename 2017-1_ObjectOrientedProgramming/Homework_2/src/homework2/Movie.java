package homework2;

public class Movie { //SubClass : ReservedMovie

	private String title; // ����
	private String director; // ����
	private char[][] seat; // �¼�ǥ
	private int id; // id
	private int time; // �󿵽ð�
	private int age; // ���ѿ���
	private int price; // ǥ ��
	private int row; // �¼� ��
	private int col; // �¼� ��

	public Movie() { //������

	}

	public Movie(Movie movie) { //������
		this.setTitle(movie.getTitle());
		this.setDirector(movie.getDirector());
		this.setId(movie.getId());
		this.setTime(movie.getTime());
		this.setAge(movie.getAge());
		this.setPrice(movie.getPrice());
		this.setRow(movie.getRow());
		this.setCol(movie.getRow());
		this.setSeat(movie.getSeat());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public char[][] getSeat() {
		return seat;
	}

	public void setSeat(char[][] seat) {
		this.seat = seat;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
