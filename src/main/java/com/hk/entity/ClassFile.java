package com.hk.entity;

/**
 * @author smallHK
 * 2019/7/23 22:51
 */
public class ClassFile {

    private int magic;

    private int minorVersion;

    private int majorVersion;

    private int constant_pool_count;

    class ConstantPool {

    }

    private ConstantPool[] constantPool;

    private int accessFlags;

    private int thisClass;

    private int superClass;

    private int interfacesCount;

    class Interface {

    }

    private Interface[] interfaces;

    private int fieldsCount;

    class FieldInfo {

    }

    private FieldInfo[] fields;

    private int methodsCount;

    class MethodInfo {

    }

    private MethodInfo[] methods;

    private int attributesCount;

    class AttributeInfo {

    }

    private AttributeInfo[] attributes;

}
