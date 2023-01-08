package com.ps.lovequest;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionKeeper {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREF_NAME = "UserSessionPref";
    public static final String KEY_NAME = "Player Name";
    public static final String KEY_GENDER = "Player Gender";
    public static final String  KEY_TOTAL_COUNT = "Total Count";

    public SessionKeeper(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.apply();
    }

    public void createPlayerSession(String name, String gender){
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_GENDER, gender);
        editor.commit();
        editor.apply();
    }
    public void createCountSession(String totalCount){
        editor.putString(KEY_TOTAL_COUNT, totalCount);
        editor.commit();
        editor.apply();
    }

    public HashMap<String, String> getPlayerInfo(){
        HashMap<String, String> player = new HashMap<>();
        player.put(KEY_NAME, pref.getString(KEY_NAME, null));
        player.put(KEY_GENDER, pref.getString(KEY_GENDER, null));
        return player;
    }

    public HashMap<String, String> getTotalCount(){
        HashMap<String, String> totalCount = new HashMap<>();
        totalCount.put(KEY_TOTAL_COUNT, pref.getString(KEY_TOTAL_COUNT, null));
        return  totalCount;
    }

    public void clearSession(){
        editor.clear();
        editor.apply();
    }
}
