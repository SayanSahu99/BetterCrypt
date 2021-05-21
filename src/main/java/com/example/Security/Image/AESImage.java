package com.example.Security.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESImage {

    private static SecretKeySpec secretKey;

    public static byte[] getFile(String filepath) {

        File f = new File(filepath);
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

    public static void getAESKeyFromPassword(String password, int keyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        char[] key = password.toCharArray();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(key, password.getBytes(), 65536, keyLength);
        secretKey =  new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
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

    public static String encrypt(String dir, String filepath, String myKey, int keyLength, String filename) {

        try {
            getAESKeyFromPassword(myKey, keyLength);
            byte[] content = getFile(filepath);
            byte[] encrypted = encryptPdfFile(secretKey, content);
            String s = new String(encrypted, StandardCharsets.ISO_8859_1);
            String ascii_enc = NinesComplimentImage.encrypt(s);
            saveFile(ascii_enc.getBytes(StandardCharsets.ISO_8859_1), dir,"encrypted_"+filename);
            return "encrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "encrypted_"+filename;
    }

    public static String decrypt(String dir, String filepath, String myKey, int keyLength, String filename) {

        MessageDigest sha = null;
        try {
            getAESKeyFromPassword(myKey, keyLength);
            byte[] encrypted = getFile(filepath);
            String ascii_enc = new String(encrypted, StandardCharsets.ISO_8859_1);
            String ascii_dec = NinesComplimentImage.decrypt(ascii_enc);
            byte[] decrypted = decryptPdfFile(secretKey, ascii_dec.getBytes(StandardCharsets.ISO_8859_1));
            saveFile(decrypted, dir,"decrypted_"+filename);
            System.out.println("Done");
            return "decrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "decrypted_"+filename;
    }

}
