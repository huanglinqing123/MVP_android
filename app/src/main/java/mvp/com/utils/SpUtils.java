package mvp.com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * SharedPreference操作类
 *
 */
public class SpUtils {
    private static final String spFileName = "app";


    public static String getString(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        String result = setPreferences.getString(strKey, "");
        return result;
    }

    public static String getString(Context context, String strKey, String strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        String result = setPreferences.getString(strKey, strDefault);
        return result;
    }

    public static void putString(Context context, String strKey, String strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putString(strKey, strData);
        editor.commit();
    }

    public static Boolean getBoolean(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        Boolean result = setPreferences.getBoolean(strKey, false);
        return result;
    }

    public static Boolean getBoolean(Context context, String strKey,
                                     Boolean strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        Boolean result = setPreferences.getBoolean(strKey, strDefault);
        return result;
    }


    public static void putBoolean(Context context, String strKey,
                                  Boolean strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(strKey, strData);
        editor.commit();
    }

    public static int getInt(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        int result = setPreferences.getInt(strKey, -1);
        return result;
    }

    public static int getInt(Context context, String strKey, int strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        int result = setPreferences.getInt(strKey, strDefault);
        return result;
    }

    public static void putInt(Context context, String strKey, int strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putInt(strKey, strData);
        editor.commit();
    }

    public static long getLong(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        long result = setPreferences.getLong(strKey, -1);
        return result;
    }

    public static long getLong(Context context, String strKey, long strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        long result = setPreferences.getLong(strKey, strDefault);
        return result;
    }

    public static void putLong(Context context, String strKey, long strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putLong(strKey, strData);
        editor.commit();
    }

    /******************** 用户信息 *********************/

//    // User Login Info
//    public static void setUser(User user) {
//        SharedPreferences.Editor editor = getUserConfigSharedpref().edit();
//        editor.putString(KEY_LOGIN_USER, new Gson().toJson(user)).commit();
//    }
//
//    // User Login Info
//    public static User getUser() {
//        SharedPreferences editor = getUserConfigSharedpref();
//        String result = editor.getString(KEY_LOGIN_USER, "");
//        if (TextUtils.isEmpty(result)) {
//            return null;
//        } else {
//            return new Gson().fromJson(result, User.class);
//        }
//    }

    //存储list

//    public static  <T> List<String> setDataList(String tag, List<T> datalist) {
//        if (null == datalist || datalist.size() <= 0)
//            return null;
//        SharedPreferences.Editor editor = getUserConfigSharedpref().edit();
//        Gson gson = new Gson();
//        //转换成json数据，再保存
//        String strJson = gson.toJson(datalist);
//        //editor.clear();
//        editor.putString(tag, strJson);
//        editor.commit();
//
//        return null;
//    }
//
//    /**
//     * 获取List
//     * @param tag
//     * @return
//     */
//    public static  <T> List<T> getDataList(String tag) {
//        SharedPreferences editor = getUserConfigSharedpref();
//        List<T> datalist=new ArrayList<T>();
//        String strJson = editor.getString(tag, null);
//        if (null == strJson) {
//            return datalist;
//        }
//        try {
//            Gson gson = new Gson();
//            datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {
//            }.getType());
//        } catch (Exception e) {
//            return null;
//        }
//        return datalist;
//
//    }
}