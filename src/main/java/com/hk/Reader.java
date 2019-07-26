package com.hk;

import com.hk.entity.ClassFile;

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
        readConstantPool();

        return classFile;
    }

    public void readMagicInfo() {

        try {
            int magic = this.dis.readInt();

            System.out.println(Integer.toBinaryString(magic));
            int unit = (1 << 8) - 1;
            System.out.println(Integer.toBinaryString(unit));
            int[] values = Parser.parseIntToBytes(magic);
            for(int i = 0; i < 4; i++) {
                System.out.println(Integer.toHexString(values[i]));
            }

            classFile.setMagic(magic);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Magic read failed!");
            System.exit(2);
        }
    }

    public void readMinorVersion() {
        try {
            int minorVersion = this.dis.readUnsignedShort();
            classFile.setMinorVersion(minorVersion);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Minor Version read failed!");
            System.exit(2);
        }
    }

    public void readMajorVersion() {
        try {
            int majorVersion = this.dis.readUnsignedShort();
            classFile.setMajorVersion(majorVersion);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Major Version read failed!");
            System.exit(2);
        }
    }

    public void readConstantPoolCount() {
        try {
            int constantPoolCount = this.dis.readUnsignedShort();
            classFile.setConstant_pool_count(constantPoolCount);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Constant pool count read failed!");
            System.exit(2);
        }
    }

    public void readConstantPool() {

        try {
            int poolCount = classFile.getConstant_pool_count();

            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Constant pool read failed!");
            System.exit(2);
        }
    }


    public byte[] getOrigin() {
        return this.origin;
    }



}
