package com.example.brookelin.cs317trialrun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by BrookeLin on 4/27/2018.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME="travelBuddy";

        public static final String TABLE_NAME="Cities";
        public static final String COL_1="Name";
        public static final String COL_2="State";
        public static final String COL_3="Country";
        //SQLiteDatabase db;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
            SQLiteDatabase db= this.getWritableDatabase();
            Toast.makeText(context, "Database helper made", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // db.execSQL("CREATE TABLE "+TABLE_NAME+ " (Name Text, State Text, Country Text)");
            //db.execSQL("INSERT INTO "+TABLE_NAME+" VALUES (New York, NY, USA), (Miami, FL, USA), (Quebec City, Quebec, CA)");
            // db.insert(TABLE_NAME,null,"(New York, NY, USA, (Miami, FL, USA), (Quebec City, Quebec, CA)");
            // insertData("New York","NY", "USA");
            //insertData("Miami","FL","USA");
            //insertData("Quebec City","Quebec","Canada");
            //Toast.makeText(MainActivity, "Data Inserted", Toast.LENGTH_LONG).show();


        }
        public boolean insertData(String name, String state, String country){
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put (COL_1, name);
            contentValues.put (COL_2, state);
            contentValues.put (COL_3, country);
            db.insert(TABLE_NAME,null,contentValues);
            System.out.println("tried to insert");
            return true;

        }
        public Cursor getAllData(){
            SQLiteDatabase db= this.getWritableDatabase();
            Cursor results= db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
            return results;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
        }
}

