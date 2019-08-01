package com.hk;

import com.hk.entity.ClassFile;
import com.hk.entity.FieldInfo;
import com.hk.entity.MethodInfo;
import com.hk.entity.attribute.AttributeInfo;
import com.hk.entity.constant.ConstantPool;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author smallHK
 * 2019/7/23 22:51
 */
public class Reader {

    private byte[] origin;

    private DataInputStream dis;

    private ClassFile classFile;

    public Reader(String path) {
        init(path);
    }

    public void init(String path) {

        try {
            origin = Files.readAllBytes(Path.of(path));
        } catch (IOException e) {

            System.out.println("File read failed!");
            e.printStackTrace();
            System.exit(1);
        }

        dis = new DataInputStream(new ByteArrayInputStream(origin));

        classFile = new ClassFile();
    }

    public ClassFile readClassFile() {

        System.out.println("Start parse!");
        readMagicInfo();
        readMinorVersion();
        readMajorVersion();
        readConstantPoolCount();
        readConstantPool();
        readThisClass();
        readSuperClass();
        readInterfacesCount();
        readInterfaces();
        readFieldsCount();
        readFields();
        readMethodsCount();
        readMethods();
        readAttributesCount();
        readAttributes();
        System.out.println("Finish parse!");
        return classFile;
    }

    private void readMagicInfo() {
        int magic = 0;
        try {
             magic = this.dis.readInt();
        } catch (IOException e) {
            System.out.println("Magic read failed!");
            System.exit(2);
        }
        classFile.setMagic(magic);

    }

    private void readMinorVersion() {
        try {
            int minorVersion = this.dis.readUnsignedShort();
            classFile.setMinorVersion(minorVersion);
        } catch (IOException e) {
            System.out.println("Minor Version read failed!");
            System.exit(2);
        }
    }

    private void readMajorVersion() {
        try {
            int majorVersion = this.dis.readUnsignedShort();
            classFile.setMajorVersion(majorVersion);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Major Version read failed!");
            System.exit(2);
        }
    }

    private void readConstantPoolCount() {
        int constantPoolCount = 0;
        try {
            constantPoolCount = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Constant pool count read failed!");
            System.exit(2);
        }
        classFile.setConstant_pool_count(constantPoolCount);
    }

    private void readConstantPool() {

        int poolCount = classFile.getConstant_pool_count() - 1;
        ConstantPool[] constantPools = new ConstantPool[poolCount];

        for (int i = 0; i < poolCount; i++) {
            ConstantPool constant = null;
            try {
                if (i == 39) {
                    int jjj = 1;
                }
                constant = ConstantPool.constructConstantPool(dis);
                constant.readContent(dis);
                constant.print();
            } catch (IOException e) {
                System.out.println("Constant pool read failed!");
                System.exit(2);
            } catch (RuntimeException e) {
                System.out.println("iterator: " + i);
                System.exit(3);
            }
            constantPools[i] = constant;
        }

        this.classFile.setConstantPool(constantPools);
    }

    private void readAccessFlags() {

        try {
            int accessFlags = this.dis.readUnsignedShort();
            classFile.setAccessFlags(accessFlags);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Access flags read failed!");
            System.exit(2);
        }
    }

    private void readThisClass() {
        int thisClass = 0;
        try {
            thisClass = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("This class read failed!");
            System.exit(2);
        }
        classFile.setThisClass(thisClass);
    }

    private void readSuperClass() {
        int superClass = 0;
        try {
            superClass = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Super class read failed!");
            System.exit(2);
        }
        classFile.setSuperClass(superClass);

    }

    private void readInterfacesCount() {
        int interfacesCount = 0;
        try {
            interfacesCount = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Interfaces count read failed!");
            System.exit(2);
        }
        classFile.setInterfacesCount(interfacesCount);

    }

    private void readInterfaces() {
        int interfacesCount = classFile.getInterfacesCount();
        int[] interfaces = new int[interfacesCount];
        for (int i = 0; i < interfacesCount; i++) {
            int index = -1;
            try {
                index = dis.readUnsignedShort();
            } catch (IOException e) {
                System.out.println("Interfaces info read failed!");
                System.exit(2);
            }
            interfaces[i] = index;
        }
        classFile.setInterfaces(interfaces);
    }


    private void readFieldsCount() {
        int fieldsCount = 0;
        try {
            fieldsCount = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Fields count read failed!");
            System.exit(2);
        }
        classFile.setFieldsCount(fieldsCount);
    }

    private void readFields() {

        int fieldsCount = this.classFile.getFieldsCount();
        FieldInfo[] fieldInfos = new FieldInfo[fieldsCount];
        for (int i = 0; i < fieldsCount; i++) {
            try {
                int accessFlags = dis.readUnsignedShort();
                int nameIndex = dis.readUnsignedShort();
                int descriptorIndex = dis.readUnsignedShort();
                int attributesCount = dis.readUnsignedShort();//假设属性的数量一定小于20亿
                AttributeInfo[] attributeInfos = readAttributes(dis, attributesCount);
                fieldInfos[i] = new FieldInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributeInfos);
            } catch (IOException e) {
                System.out.println("Field read Fail!");
                System.exit(2);
            }
        }
        this.classFile.setFields(fieldInfos);
    }


    private void readMethodsCount() {
        int methodsCount = 0;
        try {
            methodsCount = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Methods count read failed!");
            System.exit(2);
        }
        classFile.setFieldsCount(methodsCount);
    }

    private void readMethods() {

        int methodCount = this.classFile.getMethodsCount();
        MethodInfo[] infos = new MethodInfo[methodCount];
        for (int i = 0; i < methodCount; i++) {

            try {
                int accessFlags = this.dis.readUnsignedShort();
                int nameIndex = this.dis.readUnsignedShort();
                int descriptor = this.dis.readUnsignedShort();
                int attributesCount = this.dis.readUnsignedShort();
                AttributeInfo[] attributeInfos = readAttributes(dis, attributesCount);
                infos[i] = new MethodInfo(accessFlags, nameIndex, descriptor, attributesCount, attributeInfos);
            } catch (IOException e) {
                System.out.println("method read fail!");
                System.exit(2);
            }
        }
        this.classFile.setMethods(infos);
    }

    private AttributeInfo[] readAttributes(DataInputStream dis, int attributesCount) throws IOException {
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            int attributeNameIndex = dis.readUnsignedShort();
            int attributeLength = dis.readInt();//假设属性的长度小于20亿字节

            int[] info = new int[attributeLength];
            for (int t = 0; t < attributeLength; t++) {
                info[t] = dis.readUnsignedByte();
            }
            attributeInfos[i] = new AttributeInfo(attributeNameIndex, attributeLength, info);
        }
        return attributeInfos;
    }


    private void readAttributesCount() {
        int attributesCount = 0;
        try {
            attributesCount = this.dis.readUnsignedShort();
        } catch (IOException e) {
            System.out.println("Attributes count read failed!");
            System.exit(2);
        }
        classFile.setAttributesCount(attributesCount);
    }

    private void readAttributes() {
        int count = this.classFile.getAttributesCount();
        AttributeInfo[] attributes = null;
        try {
            attributes = readAttributes(dis, count);
        } catch (IOException e) {
            System.out.println("read attributes fail!");
            System.exit(2);
        }
        this.classFile.setAttributes(attributes);
    }


    private byte[] getOrigin() {
        return this.origin;
    }


}
