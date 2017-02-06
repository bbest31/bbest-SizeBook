package com.example.bbest.bbest_sizebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**The RecordsListManager makes sure that all the Records are loaded and saved properly when accessed by the RecordsListController
 * Created by bbest on 05/02/17.
 */

public class RecordsListManager {
    static final String preFile = "RecordsList";
    static final String rlKey = "recordsList";
    Context context;

    static private RecordsListManager recordsListManager = null;
    //initializes the manager and creates one if none exists.
    public static void initManager(Context context){
        if(recordsListManager == null){
            if(context == null){
                throw new RuntimeException("Missing content for RecordsListManager.");
            }
            recordsListManager = new RecordsListManager(context);
        }
    }
    //Returns the manager if one exists
    public static RecordsListManager getManager(){

            if(recordsListManager == null){
                throw new RuntimeException("Did not initialize Manager.");
            }

        return recordsListManager;
    }

    public RecordsListManager(Context context){
        this.context = context;
    }

    //Loads the record list that was saved on the start of the app if one exists.
    public RecordsList loadRecordsList() throws IOException, ClassNotFoundException{
        SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        String recordsListData = settings.getString(rlKey,"");
        if(recordsListData.equals("")){
            return new RecordsList();
        }else{
            return recordsListFromString(recordsListData);
        }
    }
    //Returns the lists in form of RecordList objects from a string format form which it was saved in.
    static public RecordsList recordsListFromString(String personListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(personListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (RecordsList) oi.readObject();

    }
    //converts the list to a string format that can be saved.
    static public String recordsListToString(RecordsList rl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(rl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
    //Saves the lists by using recordsListToString() to convert the lists into a savabel string
    public void saveRecordsList(RecordsList rl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(rlKey, recordsListToString(rl));
        editor.commit();
    }
}
