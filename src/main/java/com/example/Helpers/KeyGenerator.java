package com.example.Helpers;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public interface KeyGenerator {
     static SecretKeySpec getAESKeyFromPassword(String password, int keyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        char[] key = password.toCharArray();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(key, password.getBytes(), 65536, keyLength);
         return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }
}
