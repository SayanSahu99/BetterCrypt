package com.example.Security.Image;

import com.example.Helpers.File;
import com.example.Helpers.KeyGenerator;
import com.example.Helpers.Receiver;
import com.example.Helpers.Sender;

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
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class AESImage implements Sender, Receiver, KeyGenerator {

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


    public String encrypt(String dir, String filepath, String myKey, int keyLength, String filename) {

        try {
            SecretKeySpec secretKey = KeyGenerator.getAESKeyFromPassword(myKey, keyLength);
            byte[] content = File.getFile(filepath);
            byte[] encrypted = encryptPdfFile(secretKey, content);
            String s = new String(encrypted, StandardCharsets.ISO_8859_1);
            String ascii_enc = NinesComplimentImage.encrypt(s);
            File.saveFile(ascii_enc.getBytes(StandardCharsets.ISO_8859_1), dir,"encrypted_"+filename);
            return "encrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "encrypted_"+filename;
    }

    public String decrypt(String dir, String filepath, String myKey, int keyLength, String filename) {

        MessageDigest sha = null;
        try {
            SecretKeySpec secretKey = KeyGenerator.getAESKeyFromPassword(myKey, keyLength);
            byte[] encrypted = File.getFile(filepath);
            String ascii_enc = new String(encrypted, StandardCharsets.ISO_8859_1);
            String ascii_dec = NinesComplimentImage.decrypt(ascii_enc);
            byte[] decrypted = decryptPdfFile(secretKey, ascii_dec.getBytes(StandardCharsets.ISO_8859_1));
            File.saveFile(decrypted, dir,"decrypted_"+filename);
            System.out.println("Done");
            return "decrypted_"+filename;
        }
        catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "decrypted_"+filename;
    }

    public byte[] encrypt(byte[] plaintext, String key, int keyLength) throws Exception {
        return null;
    }

    public String decrypt(String cipherText, String key, int keyLength) throws Exception {
        return null;
    }

}
