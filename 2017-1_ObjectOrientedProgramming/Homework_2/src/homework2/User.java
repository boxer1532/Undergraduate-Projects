package homework2;

public class User { //SubClass : Admin, Audience

	private String id; // id
	private String password; // �н�����
	private int admin; // admin = 0 or 1
	private int age; // �Ϲݻ������ ����

	public User() { //������

	}

	public User(String id, String password, int admin) { // admin�� ������
		this.setId(id);
		this.setPassword(password);
		
		this.setAdmin(admin);
	}

	public User(String id, String password, int admin, int age) { // Audience�� ������
		this.setId(id);
		this.setPassword(password);
		this.setAdmin(admin);
		this.setAge(age);
	}
	
	/* ��ȭ ����Ʈ����(AdminMenu) && ��ȭ ���� �󼼺���(AudienceMenu) Method */
	public void BrowseMovie(Theater theater) {
		System.out.println("*** ��ȭ ��� ***");
		for (int i = 0; i < theater.getMovieList().size(); i++) {
			System.out.println("ID: " + theater.getMovieList().get(i).getId());
			System.out.println("����: " + theater.getMovieList().get(i).getTitle());
			System.out.println("����: " + theater.getMovieList().get(i).getDirector());
			System.out.println("�󿵽ð�: " + theater.getMovieList().get(i).getTime());
			System.out.println("���ѿ���: " + theater.getMovieList().get(i).getAge());
			System.out.println("ǥ ��: " + theater.getMovieList().get(i).getPrice());
			System.out.println("-----------------------------------------");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
