package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class Synthetic extends AttributeInfo {
    public Synthetic(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {

    }
}
