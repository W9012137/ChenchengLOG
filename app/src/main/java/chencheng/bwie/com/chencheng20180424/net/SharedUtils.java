package chencheng.bwie.com.chencheng20180424.net;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dell on 2018/4/24.
 */

public class SharedUtils {
    static SharedPreferences preferences;
    static String  File = "data";

    //保存数据的方法
    public static void savaBooleanData(Context context, String key, boolean value){
        if (preferences == null) {
            preferences = context.getSharedPreferences(File, Context.MODE_PRIVATE);
        }

        //获取编辑器对象
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value).commit();
    }

    //获取数据的方法
    public static boolean getBooleanData(Context context, String key,boolean defValue){
        if (preferences == null) {
            preferences = context.getSharedPreferences(File, Context.MODE_PRIVATE);
        }

        return preferences.getBoolean(key, defValue);
    }
}
