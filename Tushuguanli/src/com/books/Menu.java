package com.books;

import java.util.Scanner;

public class Menu {
	// ����ɨ�����࣬���ڽ����û�ͨ���������������
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	Data date = new Data();
	Book[] bs = new Book[50];
	// ����һ��Book������� �����ڴ�Ž���ͼ�����ϸ
	Book[] browsers = new Book[50];
	// ��ʾ����������±�
	int index = 0;

	/**
	 * ��Data�е����ݴ��ݵ���ǰMenu������� bs������
	 * 
	 */
	public void chuanData() {
		bs = date.init();
	}

	/**
	 * ��ӭ����
	 * @author chh
	 */
	public void welcome() {

		System.out.println("\t��ӭ���� miniͼ�����ϵͳ2.0��\n");
		System.out.println("******************************************\n");
		System.out.println("\t1. ��  ¼  ϵ  ͳ\n");
		System.out.println("\t2. ��  ��\n");
		System.out.println("******************************************\n");
		System.out.println("��ѡ���������� ��\n");
		int ok = scan.nextInt();
		switch (ok) {
		case 1:
			// �� ¼ ϵ ͳ
			this.login();
			break;
		case 2:
			// �� ��
			System.out.println("ллʹ��");
			System.exit(0);// ����JVM
			break;

		default:
			System.out.println("��������������������");
		}

	}

	/**
	 * ��½
	 * @author chh
	 */
	public void login() {
		System.out.println("\t��ӭ miniͼ�����ϵͳ2.0�� >> ��  ½   ��  ��\n");
		System.out.println("******************************************\n");
		
		int count = 3;// ���Ƶ�½����
		boolean flag = true;
		do {
			System.out.println("�������û���");
			String uname = scan.next();
			System.out.println("����������");
			String upass = scan.next();
			if (uname.equals(admin.username) && upass.equals(admin.password)) {
				// ��½�ɹ� -->�������˵�
				this.mainMenu();
				flag = false;
			} else {
				count--;
				// ��½ʧ��
				if (count == 0) {
					System.out.println("���������Ļ����Ѿ������������Ĵ������������ٵ�½");
					System.exit(0);// �˳�ϵͳ
				}
				System.out.println("��������û��������������������" + count + "����!\n");
			}
		} while (flag);

	}

	/**
	 * ���˵�
	 * @author chh
	 */
	public void mainMenu() {// ��ʼ
		System.out.println("\t��ӭ miniͼ�����ϵͳ2.0�� >> ���˵�\n");
		System.out.println("******************************************\n");
		// ���ƴ��� ctrl + alt + �¼�ͷ ɾ�� : ctrl+ d
		System.out.println("\t\t1. �  ��  ͼ  ��\n");
		System.out.println("\t\t2. ��  ��  ͼ  ��\n");
		System.out.println("\t\t3. ��  ��  ͼ  ��\n");
		System.out.println("\t\t4. ��  ��  ͼ  ��\n");
		System.out.println("\t\t5. ��  ��  ͼ  ��\n");
		System.out.println("\t\t6. ��  ��  ��  ϸ\n");
		System.out.println("\t\t7. ɾ  ��  ͼ  ��\n");
		System.out.println("\t\t8. ��  ��  ͼ  ��\n");
		System.out.println("\t\t9. ��             ��\n");
		System.out.println("******************************************\n");
		System.out.println("��ѡ���������� ��\n");
		int ok = scan.nextInt();

		switch (ok) {
		case 1:
			// ��� ͼ ��
			getAllBooks();

			break;
		case 2:
			// �� �� ͼ ��
			browser();
			break;
		case 3:
			// �� �� ͼ ��
			backBook();
			break;
		case 4:
			// �� �� ͼ ��
			addBook();
			break;
		case 5:
			// �� �� ͼ ��
			findBook();
			break;
		case 6:
			// �� �� �� ϸ
			this.readDetail();
			break;
		case 7:
			// ɾ �� ͼ ��
			this.delete();
			break;
		case 8:
			// �� �� ͼ ��
			this.update();
			break;
		case 9:
			// �� ��
			System.out.println("ллʹ��");
			System.exit(0);// ����JVM
			break;

		default:
			System.out.println("��������������������");
		}
	}



	/**
	 * ���
	 * @author chh
	 */
	public void getAllBooks() {
		System.out.println("miniͼ�����ϵͳ  >>  �   ��   ͼ  ��\n");
		System.out.println("---------------------------------------------");
		// ͼ���ͷ
		System.out.println("ͼ����\tͼ������\t\t״̬\n");
		// ��������
		for (int i = 0; i < bs.length; i++) {

			if (bs[i] != null) {
				// ���ͼ����Ϣ
				System.out.println(bs[i].toString());
			}
		}
		System.out.println("---------------------------------------------");
		// ������һ��
		returnMenu();
	}

	/**
	 * ���ͼ��
	 * @author chh
	 */
	public void addBook() {
		System.out.println("miniͼ�����ϵͳ >> ��   ��    ͼ  ��");
		System.out.println("---------------------------------------------");
		System.out.println("������ͼ�����ƣ�");
		String bookName = scan.next();
		// �ƶ����� alt+��ͷ
		System.out.println("��ѡ��ͼ��״̬��( 0.���ɽ���    1.�ɽ���   )\n");
		int state = scan.nextInt();
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == null) {
				// ����ͼ��
				Book book = new Book();
				// ��ͼ������name��ֵ
				book.name = bookName;
				// ��ͼ������state��ֵ
				book.state = state;
				// ��ͼ������id��ֵ
				book.id = i + 1;
				bs[i] = book;
				System.out.println("��ӡ�" + book.name + "���ɹ�");
				break;
			}
		}
		// ������һ���˵�
		this.returnMenu();


	}

	/**
	 *  ����ͼ��
	 *  @author chh
	 */
	public void findBook() {
		System.out.println("miniͼ�����ϵͳ >> ��   ��   ͼ  ��");
		System.out.println("---------------------------------------------");
		// �����ѯ������ ��������
		System.out.println("������ͼ�����ƣ�");

		String bookName = scan.next();
		// �������飬ȡ�������е�ÿһ���� ���û�������������жԱȣ�

		boolean flag = false;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == null) {
				break;
	    }
			// �ж��û�����������������е�ͼ��������Ƿ�һ�£����һ��
		if (bookName.equals(bs[i].name)) {
		
			System.out.println("\n���\t\t����\t\t״̬");
		
			System.out.println(bs[i].toString());
			flag = true;
			break;
		}

		}
		if (flag == false) {

			System.out.println("\n���޴��飬��ѯʧ�ܣ�");
		}
		System.out.println("---------------------------------------------");
		// ������һ��
		this.returnMenu();
	}


	/**
	 * ������һ���˵�
	 * @author chh
	 */
	public void returnMenu() {
		int ok;
		System.out.println("\n������'0'������һ��");
		do {

			ok = scan.nextInt();
			if (ok == 0) {
				mainMenu();
			}
			System.out.println("�����������������룬������'0'������һ��");
		} while (ok != 0);

	}

	
	/**
	 * ����
	 * @author chh
	 */
	public void browser() {
		System.out.println("miniͼ�����ϵͳ >> ��    ��    ͼ  ��");
		System.out.println("---------------------------------------------");	
		System.out.println("��ѡ�� 1. ͼ����   2. ͼ������ ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			// ���ݱ�Ž���
			browserId();
			break;
		case 2:
			// ������������
			browserName();
			break;
		}
	}

	/**
	 * ���ݱ�Ž���
	 * @author chh
	 */
	public void browserId() {
		// 1.��ȡ�û������ͼ����
		System.out.println("������ͼ���ţ�");
		int id = scan.nextInt();
		boolean flag = true;
		// 2.����ͼ������
		for (int i = 0; i < bs.length; i++) {			
            if ( bs[i]!=null) {
            	// �ж��û������id ��������ͼ���Ž��бȽ�
    			if (bs[i].id == id) {
    				// ���ͼ��״̬Ϊ1 ����ʾ�ɽ���
    				if (bs[i].state == 1) {
    					// ���ĳɹ�
    					System.out.println("���� ��" + bs[i].name + "���ɹ�");
    					// ���ĵ�ǰͼ��״̬��Ϊ���ɽ���
    					bs[i].state = 0;
    					// ����ͼ���ŵ�������ϸ��browsers������
    					browsers[index++] = bs[i];
    					flag = false;
    					break;
    				}
    				// ͼ��״̬��1 ���ɽ���
    				else {
    					flag = false;
    					System.out.println("�á�" + bs[i].name + "���ѱ��������ǰ���ɽ���");
    					break;
    				}

    			}
			}			
		}
		if (flag) {

			System.out.println("��Ǹ�����鲻���ڣ��޷����ģ�");
		}
		// ������һ��
		this.returnMenu();

	}

	/**
	 * ������������
	 * @author chh
	 */
	public void browserName() {		
		// 1.��ȡ�û������ͼ����
		System.out.println("������ͼ�����ƣ�");
		String name = scan.next();
		boolean flag = true;		
		for (int i = 0; i < bs.length; i++) {
		  if ( bs[i] != null) {
			// �ж��û������id ��������ͼ���Ž��бȽ�
			if (bs[i].name.equals(name)) {
				// ���ͼ��״̬Ϊ1 ����ʾ�ɽ���
				if (bs[i].state == 1) {
					// ���ĳɹ��������ǰͼ����Ϣ��������ͼ���״̬Ϊ���ɽ���
					System.out.println("���� ��" + bs[i].name + "���ɹ�");
					// ���ĵ�ǰͼ��״̬��Ϊ���ɽ���
					bs[i].state = 0;
					// ����ͼ���ŵ�������ϸ��browsers������
					browsers[index++] = bs[i];
					flag = false;
					break;
				}
				// ͼ��״̬��1 ���ɽ���
				else {
					flag = false;
					System.out.println("�á�" + bs[i].name + "���ѱ��������ǰ���ɽ���");
					break;
				}
			}
		  }
		}
		if (flag) {

			System.out.println("��Ǹ�����鲻���ڣ��޷����ģ�");
		}
		// ������һ��
		this.returnMenu();
	}

	/**
	 * ������ϸ
	 * @author chh
	 */
	public void readDetail() {
		System.out.println("miniͼ�����ϵͳ >> ��  ��   ͼ  ��\n");
		System.out.println("------------------------------------------------");
		System.out.println("\nͼ����\tͼ������\t\t״̬\n");
		boolean flag = true;
		for (int i = 0; i < browsers.length; i++) {
			if (this.browsers[i] != null) {
				String value = "";
				if (browsers[i].state == 0) {
					value = "�ѽ���";
				}
				// ���ͼ����Ϣ
				System.out.println(browsers[i].id + "\t\t" + browsers[i].name
						+ "\t\t" + value);
				flag = false;
			}
		}
	 if ( flag ) {
		System.out.println("�޽��ļ�¼�����Ƚ���...��");
	}
	 System.out.println("------------------------------------------------");
	 // ������һ��
		this.returnMenu();
	}
	/**
	 * ɾ��ͼ��
	 * @author chh
	 */
	public void delete() {
		System.out.println("miniͼ�����ϵͳ >> ɾ  ��  ͼ  ��\n");
		System.out.println("---------------------------------------------");	

		System.out.println("������ͼ����: ");
		int id = scan.nextInt();
		boolean flag = true;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] != null) {
				if (bs[i].id == id) {
					if (bs[i].state == 1) {

						System.out.println("ɾ����" + bs[i].name + "���ɹ�");
						bs[i] = null;
						flag = false;
						break;
					} else {
						System.out.println("���顶" + bs[i].name
								+ "�����ڽ�����...���޷�ɾ����");

						flag = false;
						break;

					}
				}
			}
		}// for����
		if (flag) {
			System.out.println("���鲻���ڣ���������");
		}
		// ������һ��
		this.returnMenu();

	}

	/**
	 * 3���黹ͼ��
	 * @author chh
	 */
	public void backBook() {
		System.out.println("miniͼ�����ϵͳ  >>  ��   ��   ͼ  ��\n");
		System.out.println("---------------------------------------------");	
		System.out.println("������ͼ���ţ�");
		int id = scan.nextInt();
		boolean flag = false;
		for (int i = 0; i < bs.length; i++) {
			// ���������ͼ�鲻Ϊnull
			if (bs[i] != null) {
				// �ж�ͼ��ı�ź������е�ͼ�����Ƿ�һ��
				if (bs[i].id == id) {
					// �������
					// �ж���״̬���ѽ��� ����δ����
					if (bs[i].state == 0) {
						//�黹�ɹ�
						System.out.println("�黹��" + bs[i].name + "���ɹ���");
						//����״̬
						bs[i].state = 1;
						//���ý�����ϸ����
						for (int j = 0; j < this.browsers.length; j++) {
							if (this.browsers[j]!=null) {
								if ( browsers[j].id==bs[i].id) {
									browsers[j]=null;
									break;
								}
							}
						}
						flag = true;
						break;
					}
					// ����δ����
					else {
						flag = true;
						System.out.println("����δ�����������黹..!");
						break;
					}
				}
			}
		}
		if (flag == false) {
			System.out.println("���鲻���ڣ����ʵ�����²�����");
		}
		// ������һ���˵�
		this.returnMenu();
	}

	/**
	 * 5.�޸�ͼ�� �Ȳ�ѯ��������id�� ��Ȼ������޸�
	 * @author chh
	 */
	public void update() {
		System.out.println("miniͼ�����ϵͳ >> ��    ��   ͼ  ��");
		System.out.println("---------------------------------------------");

		System.out.println("������ͼ���ţ�");
		int id = scan.nextInt();
		boolean flag = true;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] != null) {
				if (bs[i].id == id) {
					System.out.println("\nͼ����\t\tͼ������\t\t״̬\n");
					// ����������ϸ��Ϣ
					System.out.println(bs[i].toString());
					if (bs[i].state == 1) {
						System.out.println("������ͼ�������ƣ�");
						String newName = scan.next();
						bs[i].name = newName;
						System.out.println("�Ƿ�����޸���������(y/n)");
						String ok = scan.next();
						if (!ok.equals("n")) {
							// �����޸�״̬
							System.out.println("��ѡ��ͼ����״̬��0 .���ɽ���  1. �ɽ���");
							int newState = scan.nextInt();
							bs[i].state = newState;
						}
						System.out.println("�޸ĳɹ���");
						flag = false;
						break;
					} else {
						System.out.println("\n��" + bs[i].name + "���ڽ�����...,�����޸ģ�");
						flag = false;
						break;
					}
				}
			}
		}// for ����
		if (flag) {
			System.out.println("���鲻���ڣ��޷��޸ģ�������");
		}

		this.returnMenu();
	}
}