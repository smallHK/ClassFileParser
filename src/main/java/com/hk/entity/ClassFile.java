package com.hk.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author smallHK
 * 2019/7/23 22:51
 */
@Getter
@Setter
public class ClassFile {

    private int magic;

    private int minorVersion;

    private int majorVersion;

    private int constant_pool_count;

    class ConstantPool {
        int tag;
        ConstantPool(int tag) {
            this.tag = tag;
        }
    }

    class ConstantMethodRefInfo extends ConstantPool{

        int classIndex;

        int nameAndTypeIndex;

        ConstantMethodRefInfo(int tag, int classIndex, int nameAndTypeIndex) {
            super(tag);
            this.classIndex = classIndex;
            this.nameAndTypeIndex = nameAndTypeIndex;
        }
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

        int attributeNameIndex;

        int attributeLength;

        int[] info;
    }

    private AttributeInfo[] attributes;



    public void addConstantMethodRefInfo(int tag, int classIndex, int nameAndTypeIndex) {

        var info = new ConstantMethodRefInfo(tag, classIndex, nameAndTypeIndex);
    }
}
