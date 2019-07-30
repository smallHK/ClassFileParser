package com.hk;

import com.hk.entity.ClassFile;

/**
 * @author smallHK
 * 2019/7/24 11:07
 */
public class Parser {


    public boolean parser(byte[] origin) {

        return false;
    }

    /**
     * 将int解析为表示byte的int数组
     */
    public static int[] parseIntToBytes(int src){
        int unit = (1 << 8) - 1;
        int[] values = new int[4];
        int tm = src;
        for(int i = 0; i < 4; i++) {
            values[i] = unit & tm;
            tm  = tm >>> 8;
        }
        return values;
    }

    /**
     * 将int[]转为byte[]
     */
    public static byte[] parseIntToBytes(int[] src) {
        int len = src.length;
        byte[] bytes = new byte[len];
        for(int i = 0; i < len; i++) {
            byte b = -1;
            bytes[i] = (byte)(src[i] & b);
        }
        return bytes;
    }
}
