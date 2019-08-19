package com.hk.entity.attribute;

public class LineNumberTableAttribute extends AttributeInfo{
    public LineNumberTableAttribute(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    private int lineNumberTableLength;

    private class LineNumberTable{
        private int startPc;
        private int lineNumber;
    }

    private LineNumberTable[] lineNumberTable;


}
