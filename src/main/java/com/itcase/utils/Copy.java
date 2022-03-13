package com.itcase.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.io.File;

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
        file.getAbsoluteFile();
        String[] files = file.list();
        //遍历文件
        for (String string : files) {
            if (!string.contains(".png")) {
                String newPath = file + "//" + string;
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
        String docxPath = file + "\\简介.docx";
        file.getAbsoluteFile();
        String[] files = file.list();
        //遍历文件
        for (String string : files) {
            if (!string.contains(".png")) {
                String newPath = file + "//" + string;
                FileUtil.copyFile(docxPath, newPath);

            }
        }
        FileUtil.del(docxPath);
        System.out.println("简介加入完成");
    }
}

