package com.hk.entity.constant;

/**
 * @author smallHK
 * 2019/7/27 23:10
 */
public class ConstantDynamicInfo extends ConstantPool {

    private int bootstrapMethodAttrIndex;

    private int nameAndTypeIndex;

    public ConstantDynamicInfo(int tag) {
        super(tag);
    }

    @Override
    public void readContent() {

    }
}
