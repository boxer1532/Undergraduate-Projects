package homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private static Scanner scanner = new Scanner(System.in);
	private static Theater theater = new Theater();
	private static ArrayList<User> userList = new ArrayList<User>();

	public static void main(String[] args) {

		int opt = 0;

		while (true) {
			Printing.PrintMenu();

			while (true) {
				try {
					while (true) {
						opt = scanner.nextInt();
						scanner.nextLine();

						if (opt > 0 && opt < 4)
							break;

						System.out.println("1~3 ������ ������ �Է����ּ���.");
					}
					break;
				} catch (Exception e) {
					System.out.println("1~3 ������ ������ �Է����ּ���.");
					scanner.nextLine();
				}
			}

			if (opt == 1) { /* 1.���� ���� */
				User temp = new User();
				Printing.AppendUser(temp, userList);
			}

			else if (opt == 2) { /* 2.�α��� */
				String id;
				String password;

				System.out.println("***�α��� ***");
				System.out.println("���̵�: ");
				id = scanner.nextLine();
				System.out.println("��й�ȣ: ");
				password = scanner.nextLine();

				int key = -1;

				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getId().equals(id) && userList.get(i).getPassword().equals(password))
						key = i;
				}

				if (key > -1) {
					System.out.println("�α��� ����");

					if (userList.get(key).getAdmin() == 1) { // ������(Admin)
						Admin admin=(Admin) userList.get(key);
						
						while (true) {
							Printing.PrintAdminMenu();
							int admin_opt = 0;
							boolean admin_quit = false;
							
							while (true) {
								try { 
									admin_opt = scanner.nextInt(); /*  admin_opt�� 1~4������ int���� �Է°���      */
									scanner.nextLine();
									if (admin_opt < 1 || admin_opt > 4) {
										System.out.println("1~4������ ���ڸ� �Է����ּ���.");
										continue;
									} 
									
									else {
										break;
									}
								} catch (Exception e) {
									scanner.nextLine();
									System.out.println("1~4������ ���ڸ� �Է����ּ���.");
								}
							}

							switch (admin_opt) {
							case 1: // 1.��ȭ �߰�
								admin.AppendMovie(theater);
								break;
							case 2: // 2.��ȭ ����
								admin.DeleteMovie(theater, userList);
								break;
							case 3: // 3.��ȭ ����Ʈ ����
								admin.BrowseMovie(theater);
								break;
							case 4: // 4.�α׾ƿ�
								admin_quit = true;
								break;
							}

							if (admin_quit == true) {
								System.out.println("*** �α׾ƿ� ***");
								break;
							}
						}
					} else if (userList.get(key).getAdmin() == 0) { // �Ϲݻ����(Audience)
						Audience audience = (Audience) userList.get(key);

						while (true) {
							Printing.PrintAudienceMenu();
							int audie_opt = 0;
							boolean audie_quit = false;
							
							
							while (true) {
								try {
									audie_opt = scanner.nextInt(); /*  audie_opt�� 1~4������ int���� �Է°���      */
									scanner.nextLine();

									if (audie_opt < 1 || audie_opt > 5) {
										System.out.println("1~5������ ���ڸ� �Է����ּ���.");
										continue;
									} else {
										break;
									}
								} catch (Exception e) {
									scanner.nextLine();
									System.out.println("1~5������ ���ڸ� �Է����ּ���.");
								}
							}

							switch (audie_opt) {
							case 1: // 1.��ȭ ����
								audience.ReserveMovie(theater);
								break;
							case 2: // 2.���� ���� Ȯ��
								audience.ViewReservedMovie(theater);
								break;
							case 3: // 3.��ȭ ���� �󼼺���
								audience.BrowseMovie(theater);
								break;
							case 4: // 4.�ܾ� Ȯ��
								audience.CheckMoney();
								break;
							case 5: // 5.�α׾ƿ�
								audie_quit = true;
								break;
							}

							if (audie_quit == true) {
								System.out.println("*** �α׾ƿ� ***");
								break;
							}
						}
					}
				}

				else if (key == -1) {
					System.out.println("�α��� ����");
				}
			}

			else if (opt == 3) { /* 3.���� */
				System.out.println("Program Exit");
				break;
			}
		}
	}
}
