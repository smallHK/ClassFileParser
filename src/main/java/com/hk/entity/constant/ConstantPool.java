package com.hk.entity.constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author smallHK
 * 2019/7/27 17:56
 */
public abstract class ConstantPool {

    private int tag;

    ConstantPool(int tag) {
        this.tag = tag;
    }

    public static ConstantPool constructConstantPool(DataInputStream dis) throws IOException{
        int tag = 0;
        try {
            tag = dis.readUnsignedByte();
        } catch (IOException e) {
           throw new IOException("Tag read Failed!");
        }


        switch (tag) {
            case 7:
                return new ConstantClassInfo(tag);
            case 9:
                return new ConstantFieldRefInfo(tag);
            case 10:
                return new ConstantMethodRefInfo(tag);
            case 11:
                return new ConstantInterfaceMethodRefInfo(tag);

        }

        throw  new RuntimeException("No such constant pool!");
    }

    public abstract void readContent();

}