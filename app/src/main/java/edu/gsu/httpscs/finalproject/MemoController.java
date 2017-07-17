package edu.gsu.httpscs.finalproject;

import android.content.Context;

import java.util.List;

/**
 * Created by nipunasenanayake on 7/8/17.
 */

public class MemoController {
    private Memo model;
    private DatabaseAccess databaseAccess;

    public MemoController(Context app_context) {
        model = new Memo();
        databaseAccess = DatabaseAccess.getInstance(app_context);
    }

    public  DatabaseAccess getDatabaseInstance(Context context) {
        return databaseAccess;
    }

    public List getAllMemos(){
        return databaseAccess.getAllMemos();
    }






}
