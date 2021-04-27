package com.example.BetterCrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ImageEncryptAES {

    public static void encrypt(String filePath, String Secrectkey)
            throws FileNotFoundException, IOException
    {

                // Here key is act as password to Encrypt and
                // Decrypt the Image

        long key = Long.parseLong(Secrectkey);

        // Selecting a Image for operation
        FileInputStream fis = new FileInputStream(filePath);

        // Converting Image into byte array, create a
        // array of same size as Image size

        byte[] data = new byte[fis.available()];

        // Read the array
        fis.read(data);
        int i = 0;

        // Performing an XOR operation on each value of
        // byte array due to which every value of Image
        // will change.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }

        // Opening a file for writing purpose
        FileOutputStream fos = new FileOutputStream(filePath);

        // Writing new byte array value to image which
        // will Encrypt it.

        fos.write(data);

        // Closing file
        fos.close();
        fis.close();
        System.out.println("Encyption Done...");
    }
}

