package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class RuntimeVisibleParameterAnnotations extends AttributeInfo {
    public RuntimeVisibleParameterAnnotations(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {

    }
}
