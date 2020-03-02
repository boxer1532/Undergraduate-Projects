package homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Audience extends User { // SuperClass : User

	private int money = 0;
	private ArrayList<ReservedMovie> ReserveMovieList = new ArrayList<ReservedMovie>();
	private Scanner scanner = new Scanner(System.in);

	public Audience() { //������
		money = 100000;
	}

	public Audience(User user) { //������
		super(user.getId(), user.getPassword(), user.getAdmin(), user.getAge());
		money = 100000;

	}

	/* 1.��ȭ ���� */
	public void ReserveMovie(Theater theater) {

		int Reserve_id = 0;
		int Reserve_key = -1;
		int count = 0;

		System.out.println("*** ��ȭ ���� ***");
		System.out.println("���� ���� ��ȭ ���");
		System.out.println("-----------------------------------------");
		for (int i = 0; i < theater.getMovieList().size(); i++) {
			System.out.println(
					theater.getMovieList().get(i).getTitle() + " (ID:" + theater.getMovieList().get(i).getId() + ")");
		}
		System.out.println("-----------------------------------------");

		while (true) {
			try { 
				System.out.println("���� ��ȭ ID: "); /*  ��ȭ�� ID�� int���� �Է°���      */
				Reserve_id = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("ID�� ������ �Է°����մϴ�. �ٽ� �Է����ּ���.");
				scanner.nextLine();
			}
		}

		for (int i = 0; i < theater.getMovieList().size(); i++) {
			if (Reserve_id == theater.getMovieList().get(i).getId()) {
				Reserve_key = i;
				break;
			}
		}

		if (Reserve_key == -1) {
			System.out.println("�Է��� ID�� ������ ��ȭ�� �������� �ʽ��ϴ�. ����� �޴��� �ǵ��ư��ϴ�.");
			return;
		} else if (Reserve_key > -1) {
			if (theater.getMovieList().get(Reserve_key).getAge() > this.getAge()) {
				System.out.println("���� �������� ���� ���� �� �����ϴ�.");
				return;
			} 
			
			/* �¼� ��� ���� (�¼�ǥ�� Col�� ���ڸ��� �̻��϶� ���⸦ ���� ����� ������)*/
			else {
				System.out.println("-----------------------------------------");

				if (theater.getMovieList().get(Reserve_key).getCol() > 9) {
					if (theater.getMovieList().get(Reserve_key).getCol() < 101) {
						System.out.print("  ");
						for (int i = 0; i < theater.getMovieList().get(Reserve_key).getCol() - 1; i++)
							System.out.print((i + 1) + " ");

						System.out.println();

						for (int row = 0; row < theater.getMovieList().get(Reserve_key).getRow(); row++) {
							for (int col = 0; col < theater.getMovieList().get(Reserve_key).getCol(); col++) {
								if (col < 10)
									System.out.print(theater.getMovieList().get(Reserve_key).getSeat()[row][col] + " ");
								else
									System.out.print(theater.getMovieList().get(Reserve_key).getSeat()[row][col] + "  ");
							}
							System.out.println();
						}
					} else {
						System.out.print("  ");
						for (int i = 0; i < theater.getMovieList().get(Reserve_key).getCol() - 1; i++)
							System.out.print((i + 1) + " ");

						System.out.println();

						for (int row = 0; row < theater.getMovieList().get(Reserve_key).getRow(); row++) {
							for (int col = 0; col < theater.getMovieList().get(Reserve_key).getCol(); col++) {
								if (col < 10)
									System.out.print(theater.getMovieList().get(Reserve_key).getSeat()[row][col] + " ");
								else {
									System.out.print(theater.getMovieList().get(Reserve_key).getSeat()[row][col]);
									for (int i = col; i > 0; i /= 10)
										System.out.print(" ");
								}
							}
							System.out.println();
						}
					}
				} else {
					System.out.print(" ");
					for (int i = 0; i < theater.getMovieList().get(Reserve_key).getCol() - 1; i++)
						System.out.print(i + 1);

					System.out.println();

					for (int row = 0; row < theater.getMovieList().get(Reserve_key).getRow(); row++) {
						for (int col = 0; col < theater.getMovieList().get(Reserve_key).getCol(); col++) {
							System.out.print(theater.getMovieList().get(Reserve_key).getSeat()[row][col]);
						}
						System.out.println();
					}
				}
				System.out.println("-----------------------------------------");
				/* �¼� ��� ��  */
				
				String SeatNumber = null;

				scanner.nextLine();
				System.out.println("���� �¼� ���� (����: -1�Է�)");

				while (true) {
					SeatNumber = scanner.nextLine();

					if (SeatNumber.equals("-1")) {
						System.out.println("���� �Ϸ�");
						break;
					}

					else {

						try {
							int reserve_row = (SeatNumber.charAt(0) - 65);

							if (reserve_row < 0 || reserve_row > theater.getMovieList().get(Reserve_key).getRow() - 1)
								throw new IllegalArgumentException();

							int reserve_col = (Integer.parseInt(SeatNumber.substring(1)));

							if (this.getMoney() - theater.getMovieList().get(Reserve_key).getPrice() < 0) {
								System.out.println("�ܾ��� �����մϴ�.");
							}

							else {
								if (theater.getMovieList().get(Reserve_key).getSeat()[reserve_row][reserve_col] == 'O') {
									this.setMoney(this.getMoney() - theater.getMovieList().get(Reserve_key).getPrice());
									theater.getMovieList().get(Reserve_key).getSeat()[reserve_row][reserve_col] = 'X';
									count++;
								}

								else {
									System.out.println("�̹� ���޵� �¼��Դϴ�.");
								}
							}
						} catch (Exception e) {
							System.out.println("��ȿ���� ���� �¼��Դϴ�.('A5'�� ���� [���ĺ� �빮��+���]�� ���·� �Է����ּ���.)");
							System.out.println("row: A~" + (char) (theater.getMovieList().get(Reserve_key).getRow() + 'A' - 1) + " Col: 1~" + (theater.getMovieList().get(Reserve_key).getCol()-1));
							System.out.println("���� �¼� ���� (����: -1�Է�)");
						}
					}
				}
			}

			if (count > 0) {
				ReservedMovie ReserveMovie = new ReservedMovie(theater.getMovieList().get(Reserve_key));
				ReserveMovie.setCount(count);
				
				int count_key = -1;

				if (this.getReserveMovieList().size() == 0)
					this.getReserveMovieList().add(ReserveMovie);

				else if (this.getReserveMovieList().size() > 0) {
					for (int i = 0; i < this.getReserveMovieList().size(); i++) {
						if (theater.getMovieList().get(Reserve_key).getTitle().equals(this.getReserveMovieList().get(i).getTitle())) {
							this.getReserveMovieList().get(i).setCount(this.getReserveMovieList().get(i).getCount() + count);
							count_key = i;
							break;
						}
					}

					if (count_key == -1) {
						this.getReserveMovieList().add(ReserveMovie);
					}
				}
			}
		}
	}

	/* 2.���� ���� Ȯ�� */
	public void ViewReservedMovie(Theater theater) {

		// ���� ���� ��� 
		System.out.println("*** ���� ���� Ȯ�� ***");
		for (int i = 0; i < this.getReserveMovieList().size(); i++) {
			System.out.println(this.getReserveMovieList().get(i).getTitle() + ", " + this.getReserveMovieList().get(i).getCount() + "��");
		}
	}

	/* 4.�ܾ� Ȯ�� */
	public void CheckMoney() {
		System.out.println("*** �ܾ� Ȯ�� ***");
		System.out.println(this.getMoney());
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<ReservedMovie> getReserveMovieList() {
		return ReserveMovieList;
	}

	public void setReserveMovieList(ArrayList<ReservedMovie> reserveMovieList) {
		ReserveMovieList = reserveMovieList;
	}

}
