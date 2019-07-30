package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 23:02
 */
public class ConstantFloatInfo extends ConstantPool {

    private int bytes;

    public ConstantFloatInfo(int tag) {
        super(tag);
    }

    public void readContent(DataInputStream dis) throws IOException {
        this.bytes = dis.readInt();
    }


}
