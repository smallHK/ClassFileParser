package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:03
 */
public class ConstantLongInfo extends ConstantPool {

    private int highBytes;

    private int lowBytes;

    public ConstantLongInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
