package com.hk.entity;

import com.hk.entity.attribute.AttributeInfo;

public class MethodInfo {

    private int accessFlags;

    private int nameIndex;

    private int descriptorIndex;

    private int attributesCount;

    private AttributeInfo[] attributes;

    public MethodInfo(int accessFlags, int nameIndex, int descriptorIndex, int attributesCount, AttributeInfo[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributes = attributes;
    }

}
