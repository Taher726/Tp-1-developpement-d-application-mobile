package com.example.applicationtpdevmobile.controller;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.applicationtpdevmobile.model.User;

public class LoginController {
    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static User user;

    public static LoginController instance;

    public static final LoginController getInstance(Context context){
        if(LoginController.instance ==null){
            LoginController.instance = new LoginController();
        }
        recapUser(context);
        return LoginController.instance;
    }
    public void createUser(String userName, String password, Context context) {
        user = new User(userName, password);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }
    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);
        user = new User(username,password);
    }
    public String getUserName() {
        return user.getNom();
    }

    public String getPassword() {
        return user.getMdp();
    }
}
