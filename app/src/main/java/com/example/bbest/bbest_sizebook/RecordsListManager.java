package com.example.bbest.bbest_sizebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by bbest on 05/02/17.
 */

public class RecordsListManager {
    static final String preFile = "RecordsList";
    static final String rlKey = "recordsList";
    Context context;

    static private RecordsListManager recordsListManager = null;

    public static void initManager(Context context){
        if(recordsListManager == null){
            if(context == null){
                throw new RuntimeException("Missing content for RecordsListManager.");
            }
            recordsListManager = new RecordsListManager(context);
        }
    }

    public static RecordsListManager getManager(){

            if(recordsListManager == null){
                throw new RuntimeException("Did not initialize Manager.");
            }

        return recordsListManager;
    }

    public RecordsListManager(Context context){
        this.context = context;
    }

    public RecordsList loadRecordsList() throws IOException, ClassNotFoundException{
        SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        String recordsListData = settings.getString(rlKey,"");
        if(recordsListData.equals("")){
            return new RecordsList();
        }else{
            return recordsListFromString(recordsListData);
        }
    }

    static public RecordsList recordsListFromString(String personListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(personListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (RecordsList) oi.readObject();

    }

    static public String recordsListToString(RecordsList rl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(rl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public void saveRecordsList(RecordsList rl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(rlKey, recordsListToString(rl));
        editor.commit();
    }
}
