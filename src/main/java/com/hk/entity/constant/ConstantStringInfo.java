package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:00
 */
public class ConstantStringInfo extends ConstantPool {

    private int stringIndex;

    public ConstantStringInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.stringIndex = dis.readUnsignedShort();
    }
}
