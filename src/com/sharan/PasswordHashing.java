package com.sharan;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

    public String hashPassword(String string) {

        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes());
            byte[] bytes=messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();

            for(int i=0; i< bytes.length ;i++)
            {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuilder.toString();

        }catch (NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
            return string;
        }
    }
}