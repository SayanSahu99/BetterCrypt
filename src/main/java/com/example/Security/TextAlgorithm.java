package com.example.Security;

public interface TextAlgorithm {
    String encrypt(String strToEncrypt, String secret);
    String decrypt(String strToDecrypt, String secret);
}
