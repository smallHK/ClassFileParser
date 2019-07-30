package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class LineNumberTable extends AttributeInfo {
    public LineNumberTable(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {

    }
}
