package com.hk.entity.attribute;

public class StackMapTableAttribute extends AttributeInfo {
    public StackMapTableAttribute(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    private int numberOfEntries;

    private AttributeInfo[] entries;
}
