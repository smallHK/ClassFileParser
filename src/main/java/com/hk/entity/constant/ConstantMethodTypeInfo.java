package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:09
 */
public class ConstantMethodTypeInfo extends ConstantPool {

    private int descriptorIndex;

    public ConstantMethodTypeInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.descriptorIndex = dis.readUnsignedShort();
    }


}
