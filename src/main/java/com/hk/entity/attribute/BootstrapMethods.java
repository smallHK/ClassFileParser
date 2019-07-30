package com.hk.entity.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public class BootstrapMethods extends AttributeInfo {
    public BootstrapMethods(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }

    @Override
    public void readContent(DataInputStream dis) throws IOException {

    }
}
