package com.itcase.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 31264
 * @date 2022/3/13 16:13
 */
public class CreateFolder {
    public static void main(String[] args) {
        String name="测试";
        File file = new File("C:\\Users\\31264\\Desktop\\"+name);
        //file.getAbsoluteFile();
        String[] files = file.list();
        //遍历文件
        for (String string : files) {
            System.out.println(string);
            File dir = new File(file.getAbsolutePath() + "/"
                    + string.substring(0, string.lastIndexOf(".")));
            dir.mkdir();
            copyFile(file+"/"+string, dir.getAbsolutePath()+"/"+string);
            delFile(file+"/"+string);
        }
    }
//删除文件
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//复制文件
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
}
