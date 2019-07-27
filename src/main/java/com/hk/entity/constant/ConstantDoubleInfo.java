package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:04
 */
public class ConstantDoubleInfo extends ConstantPool {

    private int highBytes;

    private int lowBytes;

    public ConstantDoubleInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
