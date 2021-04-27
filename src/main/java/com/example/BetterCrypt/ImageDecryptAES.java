package com.example.BetterCrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ImageDecryptAES {

    public static void decrypt(String filePath, String secrectkey)
            throws FileNotFoundException, IOException
    {

        long key = Long.parseLong(secrectkey);

        // Selecting a Image for Decryption.

        FileInputStream fis = new FileInputStream(
                filePath);

        // Converting image into byte array,it will
        // Create a array of same size as image.
        byte data[] = new byte[fis.available()];

        // Read the array

        fis.read(data);
        int i = 0;

        // Performing an XOR operation
        // on each value of
        // byte array to Decrypt it.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }

        // Opening file for writting purpose
        FileOutputStream fos = new FileOutputStream(
                filePath);

        // Writting Decrypted data on Image
        fos.write(data);
        fos.close();
        fis.close();
        System.out.println("Decyption Done...");
    }
}

