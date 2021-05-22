package com.example.Security.Text;

import com.example.Helpers.KeyGenerator;
import com.example.Helpers.Receiver;
import com.example.Helpers.Sender;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESText implements Sender, Receiver, KeyGenerator {

    private static SecretKeySpec Key;

    public static void getAESKeyFromPassword(String password, int KeyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        char[] key = password.toCharArray();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(key, password.getBytes(), 65536, KeyLength);
        Key =  new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    public byte[] encrypt (byte[] plaintext, String key, int keyLength) throws Exception
    {
        getAESKeyFromPassword(key, keyLength);
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(Key.getEncoded(), "AES");
        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        //Perform Encryption
        return cipher.doFinal(plaintext);
    }


    public String decrypt (String cipherText, String key, int keyLength) throws Exception
    {
        getAESKeyFromPassword(key, keyLength);
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(Key.getEncoded(), "AES");
        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedText);
    }

    public String decrypt(String dir, String filepath, String myKey, int keyLength, String filename) {
        return null;
    }

    public String encrypt(String dir, String filepath, String myKey, int keyLength, String filename) {
        return null;
    }
}

