package com.itcase.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.itcase.utils2.Delect;
import org.junit.Test;

import java.io.File;

/**
 * @author 31264
 * @date 2022/3/13 16:43
 */
public class DeskTest {
    /**
     * 批量加入侧封面
     */
    @Test
    public void copyImage() {
        String name = "爆笑虫子1";
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        String imagePath = file + "\\侧封面.png";
        String[] files = file.list();
        //遍历文件
        assert files != null;
        for (String string : files) {
            if (!string.contains(".png")) {
                String newPath = file + "\\" + string;
                System.out.println(imagePath);
                System.out.println(newPath);
                FileUtil.copyFile(imagePath, newPath);

            }
        }
        FileUtil.del(imagePath);
        System.out.println("侧封面加入完成");
    }

    /**
     * 批量加入简介
     */
    @Test
    public void copyDocx() {
        //桌面文件夹名
        String name = "测试";
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        String docxPath = file + "\\穆桂英.docx";
        String[] files = file.list();
        //遍历文件
        assert files != null;
        for (String string : files) {
            if (!string.contains(".docx")) {
                String newPath = file + "\\" + string;
                System.out.println(docxPath);
                System.out.println(newPath);
                FileUtil.copyFile(docxPath, newPath);

            }
        }
        FileUtil.del(docxPath);
        System.out.println("简介加入完成");
    }

    /**
     * 批量删除侧封面，文档等
     */
    @Test
    public void detectAll() {
        String name = "幸运虎lucky tiger";
        String filename="预览.png";
        //获取其file对象
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        Delect.func(file,filename);
    }

    /**
     * 为文件创建文件夹并把文件放入文件夹中
     */
    @Test
    public void createFolder(){
        //桌面文件夹名
        String name="1";
        File file = new File("C:\\Users\\31264\\Desktop\\"+name);
        String[] files = file.list();
        //遍历文件
        assert files != null;
        for (String string : files) {
            System.out.println(string);
            File dir = new File(file.getAbsolutePath() + "/"
                    + string.substring(0, string.lastIndexOf(".")));
            //创建文件同名文件夹
            FileUtil.mkdir(dir);
            //把文件复制进同名文件夹
            FileUtil.copyFile(file+"/"+string, dir.getAbsolutePath()+"/"+string);
            //删除原文件
            FileUtil.del(file+"/"+string);
        }
    }

    /**
     * 批量移动预览图片
     */
    @Test
    public void moveImages(){
        //桌面文件夹名
        String name = "1";
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        String[] files = file.list();
        //遍历文件
        assert files != null;
        for (String string : files) {
            if (string.contains(".png")){
                System.out.println(string);
                String oldPath=file+"\\"+string;
                String newPath=file+"\\"+ StrUtil.removeSuffix(string,"预览.png");
                //复制图片至文件夹内
                FileUtil.copyFile(oldPath,newPath);
                System.out.println(oldPath+"移动至"+newPath);
                //删除原图片
                FileUtil.del(oldPath);
            }
        }
        System.out.println("剪切完成");
    }
}

