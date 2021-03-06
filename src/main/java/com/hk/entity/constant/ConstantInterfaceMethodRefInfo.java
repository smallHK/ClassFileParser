package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 18:16
 */
public class ConstantInterfaceMethodRefInfo extends ConstantPool {

    private int classIndex;

    private int nameAndTypeIndex;

    ConstantInterfaceMethodRefInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.classIndex = dis.readUnsignedShort();
        this.nameAndTypeIndex = dis.readUnsignedShort();
    }

}
