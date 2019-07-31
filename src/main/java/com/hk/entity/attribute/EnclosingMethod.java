package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class EnclosingMethod extends AttributeInfo {


    public EnclosingMethod(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    public void readContent(DataInputStream dis) throws IOException {

    }
}
