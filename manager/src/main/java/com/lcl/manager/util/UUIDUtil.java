package com.lcl.manager.util;

/**
 * @author liuchaolong
 * @version V1.0
 * @Package com.lcl.manager.util
 * @Description: 生成64位UUID
 * @date 2017/12/8
 */
import java.util.UUID;

public class UUIDUtil {
    /**
     * 获得一个UUID
     * @return String UUID
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.replaceAll("-","");
    }

    public static void main(String[] args){
        String s = UUIDUtil.getUUID();
        System.out.println("s:"+s);
        System.out.println("len:"+s.length());
    }
}
