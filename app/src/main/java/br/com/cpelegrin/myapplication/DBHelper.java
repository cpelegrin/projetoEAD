package br.com.cpelegrin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "db_name.db";
    private static final String tableName = "table_name";
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + tableName +
            "(id INTEGER PRIMARY KEY, valor TEXT)";

    public DBHelper(Context context) {
        super(context, dbName, null, 1);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public void insert(String valor) {
        // Get data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();

        values.put("valor", valor);

        db.insert(tableName, null, values);
    }
    
    public Cursor selectAsterisco() {
        // Get data repository in read mode
        SQLiteDatabase db = this.getReadableDatabase();

        // Return all records
        return db.rawQuery( "SELECT * FROM "+ tableName, null );
    }
}