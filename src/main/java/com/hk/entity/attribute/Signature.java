package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class Signature extends AttributeInfo {
    public Signature(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {

    }
}
