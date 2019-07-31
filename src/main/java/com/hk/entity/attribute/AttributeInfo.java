package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class AttributeInfo {

    private int attributeNameIndex;

    private int attributeLength;

    private int[] info;

    public AttributeInfo(int attributeNameIndex, int attributeLength, int[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }

}
