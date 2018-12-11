package com.wschase.practiceliu;

import java.io.File;

/**文件路劲给定递归打印
 * Author:WSChase
 * Created:2018/12/8
 */
public class TestIO {
    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
        listAllFile(file);
    }

    private static void listAllFile(File file) {
        if(file.isDirectory()) {
            //判断以后如果这个file还是目录就继续拆分。直到为普通文件才输出
            File[] result = file.listFiles();//先将目录进行拆分
            if (result != null) {
                for (int i = 0; i < result.length; i++) {
                    listAllFile(result[i]);
                }
            }
        }else{
                //给定的这个是文件就直接输出（相当于已经到了最底层）
                System.out.println(file);
            }
    }
}
