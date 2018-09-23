package com.sharan.admin;

import com.sharan.PasswordHashing;

public class AdminCredentials {

    private static final String userName="sharan";
    private static final String password="lmslogin";



    public static String getUsername() {
        return userName;
    }

    public static String getHashedPassword() {
        PasswordHashing passwordHashing = new PasswordHashing();
        return passwordHashing.hashPassword(password);
    }
}
