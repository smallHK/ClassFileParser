package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:08
 */
public class ConstantMethodHandleInfo extends ConstantPool {

    private int referenceKind;

    private int referenceIndex;


    public ConstantMethodHandleInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.referenceKind = dis.readUnsignedByte();
        this.referenceIndex = dis.readUnsignedShort();
    }


}
