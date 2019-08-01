package com.hk.entity;

import com.hk.entity.attribute.AttributeInfo;

public class FieldInfo {

    public FieldInfo(int accessFlags, int nameIndex, int descriptorIndex, int attributeCount, AttributeInfo[] attributeInfos) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributeCount = attributeCount;
        this.attributeInfos = attributeInfos;
    }

    private int accessFlags;

    private int nameIndex;

    private int descriptorIndex;

    private int attributeCount;

    private AttributeInfo[] attributeInfos;

}
