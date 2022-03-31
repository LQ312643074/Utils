package com.itcase.utils2;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author 31264
 * @date 2022/3/26 15:01
 */
public class Delect {
    /**
     *
     * @param file 需要删除的文件的文件夹名
     * @param name 需要删除的文件名
     */
    public static void func(File file,String name) {
            File[] fs = file.listFiles();
        assert fs != null;
        for(File f:fs){
                //若是目录，则递归打印该目录下的文件
                if(f.isDirectory()){

                    func(f,name);
                }
                //若是文件，删除
                if(f.isFile()&& f.getName().contains(name)){
                    FileUtil.del(f);
                    System.out.println(f +"已删除");
                }
            }
        }


    }
