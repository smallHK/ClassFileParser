package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:07
 */
public class ConstantUtf8Info extends ConstantPool {

    private int length;

    private int[] bytes;

    public ConstantUtf8Info(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
