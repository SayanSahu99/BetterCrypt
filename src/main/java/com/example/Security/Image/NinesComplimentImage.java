package com.example.Security.Image;

import com.example.Security.Text.AESText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NinesComplimentImage {

    public static String encrypt(String text) {

        String key = "10101010";

        StringBuilder comp_length = new StringBuilder();

        Map<Character, Integer> t = new HashMap<>();
        Map<Integer, Character> t1 = new HashMap<>();

        char c; int m = -300;
        for(c = (char) -300; c >= 1; ++c) {
            t.put(c, m);
            m++;
        }


        for(c = 0; c <= 300; ++c) {
            t.put(c, m);
            m++;
        }


        m = -300;
        for(c = (char) -300; c >= 1; ++c) {
            t1.put(m, c);
            m++;
        }


        for(c = 0; c <= 300; ++c) {
            t1.put(m, c);
            m++;
        }

        String number;
        ArrayList<Character> nine = new ArrayList<>();
        for(int j = 0; j < text.length(); j++) {
            try{
                number = t.get(text.charAt(j)).toString();
                //System.out.println("NUMBER: "+number);
                char[] n=number.toCharArray();
                for (int i=0 ; i < n.length ; i++ ){
                    n[i] = (char)((int)('9') - (int)(n[i]) + (int)('0'));
                    nine.add(n[i]);
                }
                //System.out.println(n);
                comp_length.append(n.length);
            }

            catch (Exception e) {
               System.out.println("text char "+(int)text.charAt(j));
            }


        }

        ArrayList<String> six = new ArrayList<>();

        for(Character n: nine) {
            int dec=Integer.parseInt(n.toString());
            String result= "00000000";
            int i=result.length()-1;
            while(dec!=0) {
                char[] a =result.toCharArray();
                a[i--]= String.valueOf(dec%2).charAt(0);
                result=new String(a);
                dec=dec/2;
            }
            six.add(result);
        }

        ArrayList<String> xor = new ArrayList<>();
        for(String n: six) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < n.length(); i++) {
                sb.append(n.charAt(i)^key.charAt(i));
            }
            xor.add(sb.toString());
        }

        ArrayList<String> one = new ArrayList<>();
        for(String n: xor) {
            StringBuilder ones = new StringBuilder();
            for(int i = 0; i < n.length(); i++) {
                ones.append((n.charAt(i) == '0') ? '1' : '0');
            }
            one.add(ones.toString());
        }

        StringBuilder encryptedText = new StringBuilder();
        for(String n: one) {
            int dec = Integer.parseInt(n, 2);
            dec += 32;
            encryptedText.append(t1.get(dec));
        }
        encryptedText.append((char)170).append(comp_length);
        return encryptedText.toString();


    }

    public static String decrypt(String encryptedText) {
        // Decrypt
        String key = "10101010";
        Map<Character, Integer> t = new HashMap<>();
        Map<Integer, Character> t1 = new HashMap<>();

        char c; int m = -300;
        for(c = (char) -300; c >= 1; ++c) {
            t.put(c, m);
            m++;
        }


        for(c = 0; c <= 300; ++c) {
            t.put(c, m);
            m++;
        }

        m = -300;
        for(c = (char) -300; c >= 1; ++c) {
            t1.put(m, c);
            m++;
        }


        for(c = 0; c <= 300; ++c) {
            t1.put(m, c);
            m++;
        }

        String comp_length;
        char delimiter = 170;
        String[] token = encryptedText.split(String.valueOf(delimiter));
        encryptedText = token[0];
        comp_length = token[1];

        ArrayList<String> decimal = new ArrayList<>();
        for(int i = 0; i < encryptedText.length(); i++) {
            int ans = t.get(encryptedText.charAt(i))-32;
            String s = Integer.toString(ans);
            decimal.add(s);
        }

        ArrayList<String> six = new ArrayList<>();

        for(String n: decimal) {
            int dec=Integer.parseInt(n);
            String result= "00000000";
            int i=result.length()-1;
            while(dec!=0) {
                char[] a =result.toCharArray();
                a[i--]= String.valueOf(dec%2).charAt(0);
                result=new String(a);
                dec=dec/2;
            }
            six.add(result);
        }

        ArrayList<String> xor = new ArrayList<>();
        for(String n: six) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < n.length(); i++) {
                sb.append(n.charAt(i)^key.charAt(i));
            }
            xor.add(sb.toString());
        }

        ArrayList<String> one = new ArrayList<>();
        for(String n: xor) {
            StringBuilder ones = new StringBuilder();
            for(int i = 0; i < n.length(); i++) {
                ones.append((n.charAt(i) == '0') ? '1' : '0');
            }
            one.add(ones.toString());
        }

        String number;
        ArrayList<Character> nine = new ArrayList<>();
        for (String s : one) {
            number = String.valueOf(Integer.parseInt(s, 2));
            char[] n = number.toCharArray();
            for (int i = 0; i < n.length; i++) {
                n[i] = (char) ((int) ('9') - (int) (n[i]) + (int) ('0'));
                nine.add(n[i]);
            }
        }

        ArrayList<String> mod_nine = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < comp_length.length(); i++){
            String s = nine.get(k).toString();
            for(int j = 0; j < Integer.parseInt(String.valueOf(comp_length.charAt(i)))-1; j++) {
                s = s.concat(String.valueOf(nine.get(k+1)));
                k++;
            }
            mod_nine.add(s);
            k++;
        }

        StringBuilder decryptedText = new StringBuilder();
        for(String s: mod_nine) {
            decryptedText.append(t1.get(Integer.parseInt(s)));
        }





//        System.out.println("\n");
//        System.out.println(decimal);
//        System.out.println(six);
//        System.out.println(xor);
//        System.out.println(one);
//        System.out.println(nine);
//        System.out.println("Mod Nine "+ mod_nine);
//        System.out.println("decyprt "+ decryptedText);

        return decryptedText.toString();
    }


}
