package edu.gsu.httpscs.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

final class MVCModel {
    private static final String DB_NAME = "tasks_db";
    private static final String TABLE_NAME = "task";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE_QUERY = "CREATE TABLE " + MVCModel.TABLE_NAME + " (id integer primary key autoincrement, title text not null);";
    private final SQLiteDatabase database;
    private final SQLiteOpenHelper helper;

    public MVCModel(final Context ctx) {
        helper = new SQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {
            @Override
            public void onCreate(final SQLiteDatabase db) {
                db.execSQL(DB_CREATE_QUERY);
            }

            @Override
            public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                this.onCreate(db);
            }
        };
        database = helper.getWritableDatabase();
    }

    public void addTask(ContentValues data) {
        database.insert(TABLE_NAME, null, data);
    }

    public void deleteTask(final String field_params) {
        database.delete(TABLE_NAME, field_params, null);
    }

    public Cursor loadAllTasks() {
        Log.d(MVCView.APP_TAG, "loadAllTasks()");
        final Cursor c = database.query(TABLE_NAME, new String[]{"title"}, null, null, null, null, null);
        return c;
    }
}