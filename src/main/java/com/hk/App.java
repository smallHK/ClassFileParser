package com.hk;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Reader reader = new Reader("D:\\JCache\\201908\\01\\Test.class");
        reader.readClassFile();

    }
}
