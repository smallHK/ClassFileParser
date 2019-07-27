package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:06
 */
public class ConstantNameAndTypeInfo extends  ConstantPool {

    private int nameIndex;

    private int descriptorIndex;

    public ConstantNameAndTypeInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
