package homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User { //SuperClass : User

	private Scanner scanner = new Scanner(System.in);

	public Admin() { //������

	}

	public Admin(User user) { //������
		super(user.getId(), user.getPassword(), user.getAdmin());
	}

	/* ��ȭ �߰� Method */
	/*[ID && �󿵽ð�(1�̻�) && ���ѿ���(0�̻�) && ǥ ��(0�̻�) && �¼� ��(1~26),��(1�̻�)]��  ����(int) */
	public void AppendMovie(Theater theater) {

		Movie addMovie = new Movie();

		while (true) {
			try {
				System.out.println("*** ��ȭ �߰� ***");
				
				while(true){
				boolean id_flag = false;	
					
				System.out.println("ID:"); /*  ��ȭ�� ID�� int���� �Է°���      */
				addMovie.setId(scanner.nextInt());
				scanner.nextLine();
				
					for (int i = 0; i < theater.getMovieList().size(); i++) {
						if(theater.getMovieList().get(i).getId()==addMovie.getId()){
							System.out.println("�ߺ��� ID�� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
							id_flag=true;
							break;
						}
					}
					
					if(id_flag == false)
						break;
				}
				
				System.out.println("����: ");
				addMovie.setTitle(scanner.nextLine());
				System.out.println("����: ");
				addMovie.setDirector(scanner.nextLine());
				
				while (true) {
					System.out.println("�󿵽ð�(��): "); /*  ��ȭ�� �󿵽ð���  1�̻� int���� �Է°���      */
					addMovie.setTime(scanner.nextInt());

					if (addMovie.getTime() < 1) {
						System.out.println("�󿵽ð��� 1�̻��� �������� �����ϴ�. �ٽ��Է����ּ���. ");
					} else
						break;
				}
				
				while(true){
				System.out.println("���ѿ���: "); /*  ��ȭ�� ���ѿ��ɴ� 0�̻� int���� �Է°���      */
				addMovie.setAge(scanner.nextInt());
				
				if (addMovie.getAge() < 0) {
					System.out.println("���ѿ����� 0�̻��� �������� �����ϴ�. �ٽ��Է����ּ���. ");
				} else
					break;
				}
				while(true){
				System.out.println("ǥ ��: ");  /*  ��ȭ�� ǥ����  0�̻� int���� �Է°���      */
				addMovie.setPrice(scanner.nextInt());
				
				if (addMovie.getPrice() < 0) {
					System.out.println("ǥ ���� 0�̻��� �������� �����ϴ�. �ٽ��Է����ּ���. ");
				} else
					break;
				}
				while(true){
				System.out.println("�¼� ��(row): "); /*  ��ȭ�� ���� 1~26������ int���� �Է°���      */
				addMovie.setRow(scanner.nextInt());
				
				if(addMovie.getRow() < 1 || addMovie.getRow() > 26)
					System.out.println("��(row)�� 1~26�� ������ �Է°����մϴ�.");
				else
					break;
				}

				while (true) {
					System.out.println("�¼� ��(col): "); /*  ��ȭ�� ���� 1�̻� int���� �Է°���      */
					addMovie.setCol(scanner.nextInt());
					addMovie.setCol(addMovie.getCol() + 1);

					if (addMovie.getCol() < 2)
						System.out.println("��(col)�� 1�̻��� ������ �Է°����մϴ�.");
					else
						break;
				}

				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. ó������ �ٽ��Է����ּ���. "); //�ٽ� ID���� �Է��ϵ��� ��.
				System.out.println("ID/�󿵽ð�/���ѿ���/ǥ ��/�¼� ��&���� ����(int)�� ���� �����ϴ�. ");
			}
		} //END ALL While(true) loop

		char[][] temp = new char[addMovie.getRow()][addMovie.getCol()];
		
		for (int i = 0; i < addMovie.getRow(); i++) {

			temp[i][0] = (char) ('A' + i);

			for (int j = 1; j < addMovie.getCol(); j++) {
				temp[i][j] = 'O';
			}
		}

		addMovie.setSeat(temp);

		theater.getMovieList().add(addMovie);
	}

	/* ��ȭ ���� Method */
	public void DeleteMovie(Theater theater, ArrayList<User> userList) {

		int Delete_id = 0;
		int Delete_key = -1;

		ArrayList<Audience> AudienceList = new ArrayList<Audience>();
		
		for(int i=0;i<userList.size();i++){
			if(userList.get(i) instanceof Audience)
			AudienceList.add((Audience)userList.get(i));
		}
		
		while (true) {
			try {
				/*  ��ȭ�� ID�� int���� �Է°���      */
				System.out.println("*** ��ȭ ���� ***");
				System.out.println("������ ��ȭ ID: ");
				Delete_id = scanner.nextInt();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("ID�� ����(int)�� ���� �Է��� �����մϴ�.");
			}
		}
		
		for (int i = 0; i < theater.getMovieList().size(); i++) {
			if (Delete_id == theater.getMovieList().get(i).getId()) {
				Delete_key = i;
				break;
			}
		}

		if (Delete_key == -1) {
			System.out.println("�Է��� ID�� ������ ��ȭ�� �������� �ʽ��ϴ�.");
		} else if (Delete_key > -1) {
			
			/* �մ�(����)���� ���࿵ȭ��Ͽ��� �����ϴ� ��ȭ�� ���ŵǾ��ִٸ� �������� ���ϵ��� ��.
			 * ��ȭ�� ������ ������ �������� ���� (Delete_flag==true�϶��� ����)*/
			boolean Delete_flag = true;
			
			for (int i = 0; i < AudienceList.size(); i++) {
				for (int j = 0; j < AudienceList.get(i).getReserveMovieList().size(); j++) {
					if (Delete_id == AudienceList.get(i).getReserveMovieList().get(j).getId()) {
						Delete_flag = false;
						break;
						}
					}
				if(Delete_flag == false)
					break;
			}
			
			if(Delete_flag == true)
			theater.getMovieList().remove(Delete_key);
			else
				System.out.println("������ ������ �־� ������ �Ұ����մϴ�");
		}
	}
}
