package com.hk.entity.constant;

import com.hk.entity.ClassFile;

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
            case 8:
                return new ConstantStringInfo(tag);
            case 3:
                return new ConstantIntegerInfo(tag);
            case 4:
                return new ConstantFloatInfo(tag);
            case 5:
                return new ConstantLongInfo(tag);
            case 6:
                return new ConstantDoubleInfo(tag);
            case 12:
                return new ConstantNameAndTypeInfo(tag);
            case 1:
                return new ConstantUtf8Info(tag);
            case 15:
                return new ConstantMethodHandleInfo(tag);
            case 16:
                return new ConstantMethodTypeInfo(tag);
            case 17:
                return new ConstantDynamicInfo(tag);
            case 18:
                return new ConstantInvokeDynamicInfo(tag);
            case 19:
                return new ConstantModuleInfo(tag);
            case 20:
                return new ConstantPackageInfo(tag);

        }

        throw  new RuntimeException("No such type constant! type: " + tag);
    }

    public abstract void readContent(DataInputStream dis) throws IOException;


    public void print() {
        System.out.println(this);
    }

}