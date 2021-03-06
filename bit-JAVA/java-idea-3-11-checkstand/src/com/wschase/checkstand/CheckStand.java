package com.wschase.checkstand;

import com.wschase.checkstand.impl.SimpleGoodsCenter;
import com.wschase.checkstand.impl.SimpleOrderCenter;

import java.util.Scanner;

/**字符界面交互式
 * Author:WSChase
 * Created:2019/3/11
 */
public class CheckStand {
    public static Scanner scanner=new Scanner(System.in);

    //一执行就先给用户一个商品管理和订单管理
    //商品管理中心
    private static GoodsCenter goodsCenter=new SimpleGoodsCenter();

    //订单管理中心
    private static OrderCenter orderCenter=new SimpleOrderCenter(goodsCenter);

//订单编号，初始化的时候先给个0，后面一直往上加,每次用到use就给订单号码加个1，将它put到集合里面
    private static Integer orderId=0;

    public static void helpInfo(){
        System.out.println("***************欢迎使用简易收银台***************");
        System.out.println("        [U] 使用 [S] 设置 [A] 关于 [Q] 退出     ");
        System.out.println("          输入：  U S A Q  进入操作             ");
        System.out.println("**********************************************");
    }

    public static void quit(){
        System.out.println("**********************************************");
        System.out.println("              欢迎使用，下次再见                ");
        System.out.println("**********************************************");
        System.exit(0);
    }

    public static void about(){
        System.out.println("**********************关于*********************");
        System.out.println("                 名称：简易收银台               ");
        System.out.println("                 功能：基于字符界面的收银台      ");
        System.out.println("                 作者：wschase                 ");
        System.out.println("                 版本：v1.0.0                  ");
        System.out.println("                 意见反馈：wschase@qq.com      ");
        System.out.println("**********************************************");
    }

    public static void usagInfo(){
        System.out.println("********************买单功能**********************");
        System.out.println("    [S] 查看 [A] 下单 [D] 取消 [L] 浏览 [R] 返回   ");
        System.out.println("       输入:  S A D L R 进入操作                  ");
        System.out.println("*************************************************");
    }

    public static void settingInfo() {
        System.out.println("******************* 设置功能 ********************");
        System.out.println("    [S] 查看 [A] 上架 [D] 下架 [U] 修改 [R] 返回   ");
        System.out.println("       输入:  S A D U R 进入操作                  ");
        System.out.println("*************************************************");
    }


    public static void usage() {
        //创建订单，并且添加到订单管理中心
        Order order = new Order(String.valueOf(++orderId));
        orderCenter.addOrder(order);

        usagInfo();
        System.out.println(orderCenter.orderTable(order.getOrderId()));
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim()) {
                case "S": {
                    System.out.println(orderCenter.orderTable(order.getOrderId()));
                    break;
                }
                case "A": {
                    System.out.println("请输入下单信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0]);
                        if (goods != null) {
                            order.add(infoArray[0], Integer.parseInt(infoArray[1]));

                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "D": {
                    System.out.println("请输入取消信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0]);
                        if (goods != null) {
                            order.cancel(infoArray[0], Integer.parseInt(infoArray[1]));
                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "L": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    usagInfo();
                }
            }
        }
    }

    public static void setting() {
        settingInfo();
        while (true) {
            String line = scanner.nextLine();
            switch (line.toUpperCase()) {
                case "S": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "A": {
                    System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("!请按照格式要求输入信息");
                        break;
                    }
                    if (goodsCenter.iSExistGoods(goods.getId())) {
                        System.out.println("!上架商品已经存在，注意编号不能重复");
                    } else {
                        goodsCenter.addGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "D": {
                    System.out.println("请输入下架商品信息编号（如下格式：1 ）:");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息");
                        break;
                    }
                    if (goodsCenter.iSExistGoods(goods.getId())) {
                        goodsCenter.deleteGoods(goods.getId());
                    } else {
                        System.out.println("请输入存在的商品");
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "U": {
                    System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4 ）");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息");
                        break;
                    }

                    if (goodsCenter.iSExistGoods(goods.getId())) {
                        goodsCenter.updateGoods(goods);
                    } else {
                        System.out.println("请输入存在的商品");
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    settingInfo();
                }
            }
        }
    }

    public static Goods readGoods() {
        String value = scanner.nextLine();
        String[] infoArray = value.split(" ");
        if (infoArray.length == 3 || infoArray.length == 1) {
            if (infoArray.length == 3) {
                Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                return goods;
            }
            Goods goods = new Goods(infoArray[0], "", 0.0D);
            return goods;
        }
        return null;
    }

    public static void main(String[] args) {
        helpInfo();
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "U":
                    usage();
                    helpInfo();
                    break;
                case "S":
                    setting();
                    helpInfo();
                    break;
                case "A":
                    about();
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    helpInfo();
            }
        }
    }
}
