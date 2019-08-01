package com.hk;

import com.hk.entity.ClassFile;
import com.hk.entity.constant.ConstantClassInfo;
import com.hk.entity.constant.ConstantPool;
import com.hk.entity.constant.ConstantUtf8Info;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestClassFile {

    private static Reader reader = new Reader("D:\\JCache\\201908\\01\\Test.class");

    private static ClassFile file = reader.readClassFile();



    @Test
    public void testThisClass() {

        int thisClass = file.getThisClass();
        ConstantPool constantPool = file.getConstantPool()[thisClass];
        ConstantPool[] constantPools = file.getConstantPool();
        if(constantPool instanceof ConstantClassInfo) {
            int index = ((ConstantClassInfo) constantPool).getNameIndex();
            ConstantPool info = constantPools[index];
            if(info instanceof  ConstantUtf8Info) {
                byte[] bytes = Parser.parseIntToBytes(((ConstantUtf8Info)info).getBytes());
                ByteBuffer bf = ByteBuffer.wrap(bytes);
                String classname = StandardCharsets.UTF_8.decode(bf).toString();
                System.out.println(classname);

            }

        }

    }

    @Test
    public void testMethodsCount() {
        System.out.println(file.getMethodsCount());

    }

}
