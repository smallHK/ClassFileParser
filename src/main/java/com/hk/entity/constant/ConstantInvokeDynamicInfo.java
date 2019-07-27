package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:11
 */
public class ConstantInvokeDynamicInfo extends ConstantPool {

    private int bootstrapMethodAttrIndex;

    private int nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
