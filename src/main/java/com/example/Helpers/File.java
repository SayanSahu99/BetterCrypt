package com.example.Helpers;

import java.io.*;

public interface File {

    static byte[] getFile(String filepath) {

        java.io.File f = new java.io.File(filepath);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        byte[] content = null;
        try {
            assert is != null;
            content = new byte[is.available()];
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            assert content != null;
            is.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    static void saveFile(byte[] bytes, String dir ,String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(dir+fileName);
        fos.write(bytes);
        fos.close();
    }
}
