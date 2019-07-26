package com.hk;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Reader reader = new Reader("D:\\Cache\\javaPro\\201907\\23\\InvokeTest.class");
        reader.readClassFile();

    }
}
