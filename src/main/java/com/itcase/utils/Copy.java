package com.itcase.utils;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

import static com.itcase.utils.Delect.func;

/**
 * @author 31264
 * @date 2022/3/13 16:43
 */
public class Copy {
    /**
     * 批量加入侧封面
     */
    @Test
    public void copyImage() {
        String name = "测试";
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        String imagePath = file + "\\侧封面.png";
        String[] files = file.list();
        //遍历文件
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
    public void delectAll() {
        String name = "测试";
        String filename="侧封面.png";
        //获取其file对象
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        Delect.func(file,filename);
    }
}

