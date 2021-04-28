package com.example.BetterCrypt;

import java.io.*;

public class ImageDecryptAES {

    public static void decrypt(String filePath, String fileName, String secrectkey)
            throws FileNotFoundException, IOException
    {

        long key = Long.parseLong(secrectkey);

        // Selecting a Image for Decryption.

        FileInputStream fis = new FileInputStream(filePath+fileName);

        // Converting image into byte array,it will
        // Create a array of same size as image.
        byte[] data = new byte[fis.available()];

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
        FileOutputStream fos = new FileOutputStream(filePath+fileName);

        // Writting Decrypted data on Image
        fos.write(data);

//        File oldName =
//                new File(filePath+fileName);
//        File newName =
//                new File(filePath+"decrypted.PNG");
//
//        if (oldName.renameTo(newName))
//            System.out.println("Renamed successfully");
//        else
//            System.out.println("Error");

        fos.close();
        fis.close();
        System.out.println("Decyption Done...");
    }
}

