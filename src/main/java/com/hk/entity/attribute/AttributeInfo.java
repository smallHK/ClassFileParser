package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class AttributeInfo {

    private int attributeNameIndex;

    private int attributeLength;

    public AttributeInfo(int attributeNameIndex, int attributeLength) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
    }

    public abstract void readContent(DataInputStream dis) throws IOException;
}
