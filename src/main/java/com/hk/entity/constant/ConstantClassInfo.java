package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;


/**
 * @author smallHK
 * 2019/7/27 18:13
 */
public class ConstantClassInfo extends ConstantPool {

    private int nameIndex;

    public ConstantClassInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {
        this.nameIndex = dis.readUnsignedShort();
    }
}
