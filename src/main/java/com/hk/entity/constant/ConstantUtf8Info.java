package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:07
 */
public class ConstantUtf8Info extends ConstantPool {

    private int length;

    private int[] bytes;

    public ConstantUtf8Info(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.length = dis.readUnsignedShort();
        this.bytes = new int[this.length];
        for(int i = 0; i < this.length; i++) {
            this.bytes[i] = dis.readUnsignedByte();
        }
    }
}
