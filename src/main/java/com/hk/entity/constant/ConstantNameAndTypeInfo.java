package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:06
 */
public class ConstantNameAndTypeInfo extends  ConstantPool {

    private int nameIndex;

    private int descriptorIndex;

    public ConstantNameAndTypeInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.nameIndex = dis.readUnsignedShort();
        this.descriptorIndex = dis.readUnsignedShort();

    }
}
