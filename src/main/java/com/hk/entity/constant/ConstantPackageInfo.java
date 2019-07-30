package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:13
 */
public class ConstantPackageInfo extends ConstantPool {

    private int nameIndex;

    public ConstantPackageInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.nameIndex = dis.readUnsignedShort();
    }


}
