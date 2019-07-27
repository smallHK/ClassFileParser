package com.hk.entity.constant;

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

    @Override
    public void readContent() {

    }
}
