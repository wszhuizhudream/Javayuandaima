package com.wswchase.checkstand;

import com.wswchase.checkstand.Goods;
import com.wswchase.checkstand.GoodsCenter;
import com.wswchase.checkstand.Order;
import com.wswchase.checkstand.OrderCenter;
import com.wswchase.checkstand.impl.SimpleGoodsCenter;
import com.wswchase.checkstand.impl.SimpleOrderCenter;

import java.util.Scanner;
import java.util.SortedMap;

 /* Author:WSChase
 * Created:2019/1/9
 */
public class CheckStandPlus {
    private static Scanner scanner=new Scanner(System.in);

    //商品中心管理
    private static OrderCenter orderCenter=new SimpleOrderCenter();

    //订单中心管理
    private static GoodsCenter goodsCenter=new SimpleGoodsCenter();

    private static Integer orderld=0;

    public static void helpInfo() {
        System.out.println("*************** 欢迎使用简易收银台 ***************");
        System.out.println("        [U] 使用 [S]设置 [A]关于 [Q]退出          ");
        System.out.println("         输入： U S A Q 进入操作                  ");
        System.out.println("************************************************");
    }

    public static quit(){

        System.out.println("************************************************");
        System.out.println("               欢迎使用，下次再见                 ");
        System.out.println("************************************************");
        System.exit(0);
        }

    public static void about(){
        System.out.println("********************关于************************");
        System.out.println("             名称：简易收银台                    ");
        System.out.println("             功能：基于字符界面的收银台操作系统    ");
        System.out.println("              作者：wschase                     ");
        System.out.println("              版本：v1.0.0                      ");
        System.out.println("              意见反馈：wschase@qq.com          ");
        System.out.println("************************************************");

    }

}
