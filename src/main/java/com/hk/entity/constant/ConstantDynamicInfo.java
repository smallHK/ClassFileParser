package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:10
 */
public class ConstantDynamicInfo extends ConstantPool {

    private int bootstrapMethodAttrIndex;

    private int nameAndTypeIndex;

    public ConstantDynamicInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.bootstrapMethodAttrIndex = dis.readUnsignedShort();
        this.nameAndTypeIndex = dis.readUnsignedShort();
    }
}
