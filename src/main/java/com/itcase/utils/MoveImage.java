package com.itcase.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;

/**
 * @author 31264
 * @date 2022/3/13 16:18
 */

/**
 * 移动预览图片至文件夹  注意图片格式！！！
 */
public class MoveImage {
    public static void main(String[] args) {
        String name = "幸运虎lucky tiger";
        File file = new File("C:\\Users\\31264\\Desktop\\" + name);
        file.getAbsoluteFile();
        String[] files = file.list();
        //遍历文件
        for (String string : files) {
            if (string.contains(".png")){
            System.out.println(string);
            String oldPath=file+"\\"+string;
            String newPath=file+"\\"+StrUtil.removeSuffix(string,"预览.png");
                FileUtil.copyFile(oldPath,newPath);
                System.out.println(oldPath);
                System.out.println(newPath);
                FileUtil.del(oldPath);
            }
        }
        System.out.println("剪切完成");
    }
}
