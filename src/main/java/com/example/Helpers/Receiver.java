package com.example.Helpers;

public interface Receiver extends File{
    String decrypt(String dir, String filepath, String myKey, int keyLength, String filename);
    String decrypt(String cipherText, String key, int keyLength) throws Exception;
}
