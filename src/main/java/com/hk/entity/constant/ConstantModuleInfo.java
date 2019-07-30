package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:12
 */
public class ConstantModuleInfo extends ConstantPool {

    private int nameIndex;

    public ConstantModuleInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.nameIndex = dis.readUnsignedShort();
    }
}
