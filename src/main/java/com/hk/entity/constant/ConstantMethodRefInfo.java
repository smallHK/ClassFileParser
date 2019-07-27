package com.hk.entity.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @author smallHK
 * 2019/7/27 17:57
 */
@Getter
@Setter
class ConstantMethodRefInfo extends ConstantPool {

    private int classIndex;

    private int nameAndTypeIndex;

    ConstantMethodRefInfo(int tag) {
        super(tag);
    }

    ConstantMethodRefInfo(int tag, int classIndex, int nameAndTypeIndex) {
        super(tag);
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public void readContent() {

    }
}