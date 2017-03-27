package com.example.valhallasoft.usuariotaxa.Utils;

import android.content.SharedPreferences;

/**
 * Created by Sandoval on 21/03/2017.
 */

public class Util {

    public static int getIdUser(SharedPreferences preference){
        return preference.getInt("id",0);
    }

    public static String getEmailPreference(SharedPreferences preference){
        return preference.getString("email","");
    }

    public static String getNamePreference(SharedPreferences preference){
        return preference.getString("name","");
    }

    public static String getLastNPreference(SharedPreferences preference){
        return preference.getString("last_name","");
    }
    public static String getNumberPreference(SharedPreferences preference){
        return preference.getString("number","");
    }
}