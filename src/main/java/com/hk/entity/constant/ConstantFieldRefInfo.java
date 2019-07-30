package com.hk.entity.constant;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 18:14
 */
public class ConstantFieldRefInfo extends ConstantPool {

    private int classIndex;

    private int nameAndTypeIndex;

    public ConstantFieldRefInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.classIndex = dis.readUnsignedShort();
        this.nameAndTypeIndex = dis.readUnsignedShort();
    }
}
