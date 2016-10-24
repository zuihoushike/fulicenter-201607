package app.cn.com.fulicenter.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.cn.com.fulicenter.I;

/**
 * Created by 最后时刻 on 2016/10/24.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static DBOpenHelper instance;
    private static final String CREATE_USER_TABLE = "";

    public static DBOpenHelper onInfo(Context context){
        if (instance==null){
            instance = new DBOpenHelper(context);
        }
        return instance;
    }

    public DBOpenHelper(Context context) {
        super(context, getUserDatabaseName(), null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqlLiteDatabase) {
        sqlLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static String getUserDatabaseName() {
        return I.User.TABLE_NAME + "demo.db";
    }

    public void closeDB(){
        if (instance != null){
            instance.close();
            instance = null;
        }
    }
}
