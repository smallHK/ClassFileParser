package com.hk.entity.constant;

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

    @Override
    public void readContent() {

    }
}
