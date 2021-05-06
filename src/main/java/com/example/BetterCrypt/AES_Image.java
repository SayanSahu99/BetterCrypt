package com.example.BetterCrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

class ImageEncDec {

    public static byte[] getFile(String filepath) {

        File f = new File(filepath);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        byte[] content = null;
        try {
            assert is != null;
            content = new byte[is.available()];
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            assert content != null;
            is.read(content);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return content;
    }

    public static byte[] encryptPdfFile(Key key, byte[] content) {
        Cipher cipher;
        byte[] encrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;

    }

    public static byte[] decryptPdfFile(Key key, byte[] textCryp) {
        Cipher cipher;
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypted = cipher.doFinal(textCryp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decrypted;
    }

    public static void saveFile(byte[] bytes, String dir ,String fileName) throws IOException {

        FileOutputStream fos = new FileOutputStream(dir+fileName);
        fos.write(bytes);
        fos.close();

    }

    public static String encrypt(String dir, String filepath, String myKey, String filename) {

        MessageDigest sha = null;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            byte[] content = getFile(filepath);

            byte[] encrypted = encryptPdfFile(secretKey, content);

            String s = new String(encrypted, StandardCharsets.ISO_8859_1);

            String ascii_enc = image_ascii.encrypt(s);

            saveFile(ascii_enc.getBytes(StandardCharsets.ISO_8859_1), dir,"encrypted_"+filename);
            return "encrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return "encrypted_"+filename;
    }

    public static String decrypt(String dir, String filepath, String myKey, String filename) {

        MessageDigest sha = null;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            byte[] encrypted = getFile(filepath);

            String ascii_enc = new String(encrypted, StandardCharsets.ISO_8859_1);

            String ascii_dec = image_ascii.decrypt(ascii_enc);

            byte[] decrypted = decryptPdfFile(secretKey, ascii_dec.getBytes(StandardCharsets.ISO_8859_1));

            saveFile(decrypted, dir,"decrypted_"+filename);
            System.out.println("Done");
            return "decrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return "decrypted_"+filename;
    }



//    public static void main(String[] args)
//            throws NoSuchAlgorithmException, IOException {
//
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
//        Key key = keyGenerator.generateKey();
//        System.out.println(key.toString());
//
//        byte[] content = getFile();
//
//        byte[] encrypted = encryptPdfFile(key, content);
//
//        String s = new String(encrypted, StandardCharsets.ISO_8859_1);
//
//        String ascii_enc = image_ascii.encrypt(s);
//
//        saveFile(ascii_enc.getBytes(StandardCharsets.ISO_8859_1), "C_ENC.PNG");
//
//        String ascii_dec = image_ascii.decrypt(ascii_enc);
//
//        byte[] decrypted = decryptPdfFile(key, ascii_dec.getBytes(StandardCharsets.ISO_8859_1));
//
//        saveFile(decrypted, "C_DEC.PNG");
//        System.out.println("Done");
//
//    }

}
