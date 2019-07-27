package com.hk.entity.constant;

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

    @Override
    public void readContent() {

    }
}
