package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:03
 */
public class ConstantLongInfo extends ConstantPool {

    private int highBytes;

    private int lowBytes;

    public ConstantLongInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.highBytes = dis.readInt();
        this.lowBytes = dis.readInt();
    }
}
