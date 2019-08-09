package com.hk.entity.attribute;

public class Code extends AttributeInfo {
    public Code(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    private int maxStack;

    private int maxLocals;

    private int codeLength;

    private int[] code;

    private int exceptionTableLength;

    private class ExceptionTable {
        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;
    }

    private ExceptionTable[] exceptionTable;

    private int attributeCount;

    private AttributeInfo[] attributes;

}
