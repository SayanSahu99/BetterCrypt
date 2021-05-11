package com.example.Security;

public interface Algorithm {
    String encrypt(String strToEncrypt, String secret);
    String decrypt(String strToDecrypt, String secret);
}
