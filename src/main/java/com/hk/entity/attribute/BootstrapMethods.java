package com.hk.entity.attribute;

public class BootstrapMethods extends AttributeInfo{

    public BootstrapMethods(int attributeNameIndex, int attributeLength, int[] info) {
        super(attributeNameIndex, attributeLength, info);
    }

    private int numBootstrapMethods;

    private class BootstrapMethod {
        private int bootstrapMethodRef;
        private int numBootstrapArguments;
        private int[] bootStrapArguments;
    }
    private BootstrapMethod[] bootstrapMethods;

}
