package com.hk.entity.attribute;

public class Exceptions extends AttributeInfo{
    public Exceptions(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    private int numberOfExceptions;

    private int[] exceptionIndexTable;

}
