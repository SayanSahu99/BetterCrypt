package com.example.Helpers;

public interface Sender {
    String encrypt(String dir, String filepath, String myKey, int keyLength, String filename);
    byte[] encrypt(byte[] plaintext, String key, int keyLength) throws Exception;
}
