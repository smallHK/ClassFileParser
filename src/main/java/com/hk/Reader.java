package com.hk;

import com.hk.entity.ClassFile;
import com.hk.entity.constant.ConstantPool;

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
//        readFields();
//        readMethodsCount();
//        readMethods();
//        readAttributesCount();
//        readAttributes();

        return classFile;
    }

    private void readMagicInfo() {

        try {
            int magic = this.dis.readInt();

            System.out.println(Integer.toBinaryString(magic));
            int unit = (1 << 8) - 1;
            System.out.println(Integer.toBinaryString(unit));
            int[] values = Parser.parseIntToBytes(magic);
            for (int i = 0; i < 4; i++) {
                System.out.println(Integer.toHexString(values[i]));
            }

            classFile.setMagic(magic);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Magic read failed!");
            System.exit(2);
        }
    }

    private void readMinorVersion() {
        try {
            int minorVersion = this.dis.readUnsignedShort();
            classFile.setMinorVersion(minorVersion);
        } catch (IOException e) {
            e.printStackTrace();
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

    }


    private byte[] getOrigin() {
        return this.origin;
    }


}
