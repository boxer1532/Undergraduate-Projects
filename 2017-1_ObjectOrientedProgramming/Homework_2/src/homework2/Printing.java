package homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Printing {

	private static Scanner scanner = new Scanner(System.in);
	
	/* �ʱ� Menu ���   Method */
	static void PrintMenu() {
		System.out.println("### Welcome to Ajou Movie Theater ###");
		System.out.println("1. ���� ����");
		System.out.println("2. �α���");
		System.out.println("3. ����");
		System.out.println("���ϴ� �޴��� �����ϼ���.");
	}

	/* AdminMenu ���   Method */
	static void PrintAdminMenu() {
		System.out.println("### ������ �޴� ###");
		System.out.println("1. ��ȭ �߰�");
		System.out.println("2. ��ȭ ����");
		System.out.println("3. ��ȭ ����Ʈ ����");
		System.out.println("4. �α׾ƿ�");
		System.out.println("���ϴ� �޴��� �����ϼ���.");
	}

	/* AudienceMenu ���   Method */
	static void PrintAudienceMenu() {
		System.out.println("### �Ϲ� ����� �޴� ###");
		System.out.println("1. ��ȭ ����");
		System.out.println("2. ���� ���� Ȯ��");
		System.out.println("3. ��ȭ ���� �󼼺���");
		System.out.println("4. �ܾ� Ȯ��");
		System.out.println("5. �α׾ƿ�");
		System.out.println("���ϴ� �޴��� �����ϼ���.");
	}
	
	/* User �߰� Method */
	static void AppendUser(User user, ArrayList<User> userList) {

		while (true) {
			System.out.println("*** ������ �����ϼ���. ***");
			System.out.println("���̵�: ");
			user.setId(scanner.nextLine());
			System.out.println("��й�ȣ: ");
			user.setPassword(scanner.nextLine());
			
			while (true) {
				try {
					System.out.println("��������� �����ϼ���. (0=�Ϲ�, 1=������)");
					user.setAdmin(scanner.nextInt()); /*  admin�� 0�Ǵ� 1�� int���� �Է°���      */
					scanner.nextLine();

					if (user.getAdmin() != 0 && user.getAdmin() != 1) {
						System.out.println("���� ����� 0�Ǵ� 1�� ���� �Է��� �����մϴ�.");
						continue;
					}
					break;
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("���� ����� 0�Ǵ� 1�� ���� �Է��� �����մϴ�.");
				}
			}

			int id_check = -1;

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getId().equals(user.getId())) {
					id_check = i;
					break;
				}
			}

			if (id_check > -1) {
				System.out.println("�ߺ��� id�� �����մϴ�. �ٽ� �Է����ּ���.");
				continue;
			}

			if (user.getAdmin() == 1) { /* ���������� �������� */

				boolean admin_flag = false;

				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getAdmin() == 1) {
						admin_flag = true;
						break;
					}
				}

				if (admin_flag == true) {
					System.out.println("�̹� ������ ������ ������ �����մϴ�. ������ ������ 1���� ���� �����մϴ�.");
				} else if (admin_flag == false) {
					Admin admin = new Admin(user);
					userList.add(admin);
					break;
				}
			}

			else if (user.getAdmin() == 0) { /* �Ϲݻ�������� �������� */

				int Audience_age = 0;
				
				while (true) {
					try {
						System.out.println("���̸� �Է��ϼ���.");
						Audience_age = scanner.nextInt(); /*  Audience_age�� 1�̻��� int���� �Է°���      */
						scanner.nextLine();
						
						if(Audience_age < 1)
							throw new IllegalArgumentException();
						
						break;
						
					} catch (Exception e) {
						System.out.println("���̴� 1�̻��� ����Դϴ�. �ٽ� �Է����ּ���.");
						
						if(e instanceof IllegalArgumentException)
							continue;
						else
							scanner.nextLine();
						
					}
				}

				user.setAge(Audience_age);

				Audience audience = new Audience(user);
				userList.add(audience);
				break;
			}

			else {
				System.out.println("\nadmin�� �߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
}
