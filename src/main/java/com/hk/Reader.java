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

    public void readConstantPool() {

        try {
            int poolCount = dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public byte[] getOrigin() {
        return this.origin;
    }



}
