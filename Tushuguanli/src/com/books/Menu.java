package com.books;

import java.util.Scanner;

public class Menu {
	// 创建扫描器类，用于接收用户通过键盘输入的数据
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	Data date = new Data();
	Book[] bs = new Book[50];
	// 定义一个Book类的数组 ，用于存放借阅图书的明细
	Book[] browsers = new Book[50];
	// 表示借阅数组的下标
	int index = 0;

	/**
	 * 将Data中的数据传递到当前Menu类的属性 bs数组中
	 * 
	 */
	public void chuanData() {
		bs = date.init();
	}

	/**
	 * 欢迎界面
	 * @author chh
	 */
	public void welcome() {

		System.out.println("\t欢迎来到 mini图书管理系统2.0版\n");
		System.out.println("******************************************\n");
		System.out.println("\t1. 登  录  系  统\n");
		System.out.println("\t2. 退  出\n");
		System.out.println("******************************************\n");
		System.out.println("请选择，输入数字 ：\n");
		int ok = scan.nextInt();
		switch (ok) {
		case 1:
			// 登 录 系 统
			this.login();
			break;
		case 2:
			// 退 出
			System.out.println("谢谢使用");
			System.exit(0);// 结束JVM
			break;

		default:
			System.out.println("编号输入错误，请重新输入");
		}

	}

	/**
	 * 登陆
	 * @author chh
	 */
	public void login() {
		System.out.println("\t欢迎 mini图书管理系统2.0版 >> 登  陆   界  面\n");
		System.out.println("******************************************\n");
		
		int count = 3;// 限制登陆次数
		boolean flag = true;
		do {
			System.out.println("请输入用户名");
			String uname = scan.next();
			System.out.println("请输入密码");
			String upass = scan.next();
			if (uname.equals(admin.username) && upass.equals(admin.password)) {
				// 登陆成功 -->进入主菜单
				this.mainMenu();
				flag = false;
			} else {
				count--;
				// 登陆失败
				if (count == 0) {
					System.out.println("您输入错误的机会已经超过今日最大的次数，请明日再登陆");
					System.exit(0);// 退出系统
				}
				System.out.println("您输入的用户名或者密码错误！您还有" + count + "机会!\n");
			}
		} while (flag);

	}

	/**
	 * 主菜单
	 * @author chh
	 */
	public void mainMenu() {// 开始
		System.out.println("\t欢迎 mini图书管理系统2.0版 >> 主菜单\n");
		System.out.println("******************************************\n");
		// 复制代码 ctrl + alt + 下箭头 删除 : ctrl+ d
		System.out.println("\t\t1. 浏  览  图  书\n");
		System.out.println("\t\t2. 借  阅  图  书\n");
		System.out.println("\t\t3. 归  还  图  书\n");
		System.out.println("\t\t4. 填  加  图  书\n");
		System.out.println("\t\t5. 查  找  图  书\n");
		System.out.println("\t\t6. 借  阅  明  细\n");
		System.out.println("\t\t7. 删  除  图  书\n");
		System.out.println("\t\t8. 修  改  图  书\n");
		System.out.println("\t\t9. 退             出\n");
		System.out.println("******************************************\n");
		System.out.println("请选择，输入数字 ：\n");
		int ok = scan.nextInt();

		switch (ok) {
		case 1:
			// 浏览 图 书
			getAllBooks();

			break;
		case 2:
			// 借 阅 图 书
			browser();
			break;
		case 3:
			// 归 还 图 书
			backBook();
			break;
		case 4:
			// 填 加 图 书
			addBook();
			break;
		case 5:
			// 查 找 图 书
			findBook();
			break;
		case 6:
			// 借 阅 明 细
			this.readDetail();
			break;
		case 7:
			// 删 除 图 书
			this.delete();
			break;
		case 8:
			// 修 改 图 书
			this.update();
			break;
		case 9:
			// 退 出
			System.out.println("谢谢使用");
			System.exit(0);// 结束JVM
			break;

		default:
			System.out.println("编号输入错误，请重新输入");
		}
	}



	/**
	 * 浏览
	 * @author chh
	 */
	public void getAllBooks() {
		System.out.println("mini图书管理系统  >>  浏   览   图  书\n");
		System.out.println("---------------------------------------------");
		// 图书表头
		System.out.println("图书编号\t图书名称\t\t状态\n");
		// 遍历数组
		for (int i = 0; i < bs.length; i++) {

			if (bs[i] != null) {
				// 输出图书信息
				System.out.println(bs[i].toString());
			}
		}
		System.out.println("---------------------------------------------");
		// 返回上一级
		returnMenu();
	}

	/**
	 * 添加图书
	 * @author chh
	 */
	public void addBook() {
		System.out.println("mini图书管理系统 >> 添   加    图  书");
		System.out.println("---------------------------------------------");
		System.out.println("请输入图书名称：");
		String bookName = scan.next();
		// 移动代码 alt+箭头
		System.out.println("请选择图书状态：( 0.不可借阅    1.可借阅   )\n");
		int state = scan.nextInt();
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == null) {
				// 创建图书
				Book book = new Book();
				// 给图书属性name赋值
				book.name = bookName;
				// 给图书属性state赋值
				book.state = state;
				// 给图书属性id赋值
				book.id = i + 1;
				bs[i] = book;
				System.out.println("添加《" + book.name + "》成功");
				break;
			}
		}
		// 返回上一级菜单
		this.returnMenu();


	}

	/**
	 *  查找图书
	 *  @author chh
	 */
	public void findBook() {
		System.out.println("mini图书管理系统 >> 查   找   图  书");
		System.out.println("---------------------------------------------");
		// 输入查询的条件 根据书名
		System.out.println("请输入图书名称：");

		String bookName = scan.next();
		// 遍历数组，取出数组中的每一本书 与用户输入的书名进行对比，

		boolean flag = false;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == null) {
				break;
	    }
			// 判断用户输入的书名和数组中的图书的书名是否一致，如果一致
		if (bookName.equals(bs[i].name)) {
		
			System.out.println("\n编号\t\t书名\t\t状态");
		
			System.out.println(bs[i].toString());
			flag = true;
			break;
		}

		}
		if (flag == false) {

			System.out.println("\n查无此书，查询失败！");
		}
		System.out.println("---------------------------------------------");
		// 返回上一级
		this.returnMenu();
	}


	/**
	 * 返回上一级菜单
	 * @author chh
	 */
	public void returnMenu() {
		int ok;
		System.out.println("\n请输入'0'返回上一级");
		do {

			ok = scan.nextInt();
			if (ok == 0) {
				mainMenu();
			}
			System.out.println("输入有误！请重新输入，请输入'0'返回上一级");
		} while (ok != 0);

	}

	
	/**
	 * 借阅
	 * @author chh
	 */
	public void browser() {
		System.out.println("mini图书管理系统 >> 借    阅    图  书");
		System.out.println("---------------------------------------------");	
		System.out.println("请选择： 1. 图书编号   2. 图书名称 ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			// 根据编号借阅
			browserId();
			break;
		case 2:
			// 根据书名借阅
			browserName();
			break;
		}
	}

	/**
	 * 根据编号借阅
	 * @author chh
	 */
	public void browserId() {
		// 1.获取用户输入的图书编号
		System.out.println("请输入图书编号：");
		int id = scan.nextInt();
		boolean flag = true;
		// 2.遍历图书数组
		for (int i = 0; i < bs.length; i++) {			
            if ( bs[i]!=null) {
            	// 判断用户输入的id 和数组中图书编号进行比较
    			if (bs[i].id == id) {
    				// 如果图书状态为1 ，表示可借阅
    				if (bs[i].state == 1) {
    					// 借阅成功
    					System.out.println("借阅 《" + bs[i].name + "》成功");
    					// 更改当前图书状态变为不可借阅
    					bs[i].state = 0;
    					// 将该图书存放到借阅明细的browsers数组中
    					browsers[index++] = bs[i];
    					flag = false;
    					break;
    				}
    				// 图书状态非1 不可借阅
    				else {
    					flag = false;
    					System.out.println("该《" + bs[i].name + "》已被借出，当前不可借阅");
    					break;
    				}

    			}
			}			
		}
		if (flag) {

			System.out.println("抱歉！该书不存在，无法借阅！");
		}
		// 返回上一级
		this.returnMenu();

	}

	/**
	 * 根据书名借阅
	 * @author chh
	 */
	public void browserName() {		
		// 1.获取用户输入的图书编号
		System.out.println("请输入图书名称：");
		String name = scan.next();
		boolean flag = true;		
		for (int i = 0; i < bs.length; i++) {
		  if ( bs[i] != null) {
			// 判断用户输入的id 和数组中图书编号进行比较
			if (bs[i].name.equals(name)) {
				// 如果图书状态为1 ，表示可借阅
				if (bs[i].state == 1) {
					// 借阅成功，输出当前图书信息，并更改图书的状态为不可借阅
					System.out.println("借阅 《" + bs[i].name + "》成功");
					// 更改当前图书状态变为不可借阅
					bs[i].state = 0;
					// 将该图书存放到借阅明细的browsers数组中
					browsers[index++] = bs[i];
					flag = false;
					break;
				}
				// 图书状态非1 不可借阅
				else {
					flag = false;
					System.out.println("该《" + bs[i].name + "》已被借出，当前不可借阅");
					break;
				}
			}
		  }
		}
		if (flag) {

			System.out.println("抱歉！该书不存在，无法借阅！");
		}
		// 返回上一级
		this.returnMenu();
	}

	/**
	 * 借阅明细
	 * @author chh
	 */
	public void readDetail() {
		System.out.println("mini图书管理系统 >> 借  阅   图  书\n");
		System.out.println("------------------------------------------------");
		System.out.println("\n图书编号\t图书名称\t\t状态\n");
		boolean flag = true;
		for (int i = 0; i < browsers.length; i++) {
			if (this.browsers[i] != null) {
				String value = "";
				if (browsers[i].state == 0) {
					value = "已借阅";
				}
				// 输出图书信息
				System.out.println(browsers[i].id + "\t\t" + browsers[i].name
						+ "\t\t" + value);
				flag = false;
			}
		}
	 if ( flag ) {
		System.out.println("无借阅记录，请先借阅...！");
	}
	 System.out.println("------------------------------------------------");
	 // 返回上一级
		this.returnMenu();
	}
	/**
	 * 删除图书
	 * @author chh
	 */
	public void delete() {
		System.out.println("mini图书管理系统 >> 删  除  图  书\n");
		System.out.println("---------------------------------------------");	

		System.out.println("请输入图书编号: ");
		int id = scan.nextInt();
		boolean flag = true;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] != null) {
				if (bs[i].id == id) {
					if (bs[i].state == 1) {

						System.out.println("删除《" + bs[i].name + "》成功");
						bs[i] = null;
						flag = false;
						break;
					} else {
						System.out.println("该书《" + bs[i].name
								+ "》正在借阅中...，无法删除！");

						flag = false;
						break;

					}
				}
			}
		}// for结束
		if (flag) {
			System.out.println("该书不存在，输入有误");
		}
		// 返回上一级
		this.returnMenu();

	}

	/**
	 * 3。归还图书
	 * @author chh
	 */
	public void backBook() {
		System.out.println("mini图书管理系统  >>  归   还   图  书\n");
		System.out.println("---------------------------------------------");	
		System.out.println("请输入图书编号：");
		int id = scan.nextInt();
		boolean flag = false;
		for (int i = 0; i < bs.length; i++) {
			// 如果数组中图书不为null
			if (bs[i] != null) {
				// 判断图书的编号和数组中的图书编号是否一致
				if (bs[i].id == id) {
					// 该书存在
					// 判断书状态，已借阅 还是未借阅
					if (bs[i].state == 0) {
						//归还成功
						System.out.println("归还《" + bs[i].name + "》成功！");
						//更改状态
						bs[i].state = 1;
						//更该借阅明细数组
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
					// 该书未借阅
					else {
						flag = true;
						System.out.println("该书未被借出，无需归还..!");
						break;
					}
				}
			}
		}
		if (flag == false) {
			System.out.println("该书不存在，请核实后重新操作！");
		}
		// 返回上一级菜单
		this.returnMenu();
	}

	/**
	 * 5.修改图书 先查询到（根据id） ，然后进行修改
	 * @author chh
	 */
	public void update() {
		System.out.println("mini图书管理系统 >> 修    改   图  书");
		System.out.println("---------------------------------------------");

		System.out.println("请输入图书编号：");
		int id = scan.nextInt();
		boolean flag = true;
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] != null) {
				if (bs[i].id == id) {
					System.out.println("\n图书编号\t\t图书名称\t\t状态\n");
					// 输出该书的详细信息
					System.out.println(bs[i].toString());
					if (bs[i].state == 1) {
						System.out.println("请输入图书新名称：");
						String newName = scan.next();
						bs[i].name = newName;
						System.out.println("是否继续修改其他属性(y/n)");
						String ok = scan.next();
						if (!ok.equals("n")) {
							// 继续修改状态
							System.out.println("请选择图书新状态：0 .不可借阅  1. 可借阅");
							int newState = scan.nextInt();
							bs[i].state = newState;
						}
						System.out.println("修改成功！");
						flag = false;
						break;
					} else {
						System.out.println("\n该" + bs[i].name + "正在借阅中...,不可修改！");
						flag = false;
						break;
					}
				}
			}
		}// for 结束
		if (flag) {
			System.out.println("该书不存在，无法修改．．．！");
		}

		this.returnMenu();
	}
}