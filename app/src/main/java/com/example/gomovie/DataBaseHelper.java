package com.example.gomovie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "psw";


    public static final String TABLE_FILM = "film";
    public static final String COLUMN_ID_FILM = "id";
    public static final String COLUMN_USER_USERNAME = "username";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_TEL = "tel";
    public static final String COLUMN_ADRESS = "adress";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    SQLiteDatabase db;
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PASSWORD + " TEXT)";
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_FILM_TABLE = "CREATE TABLE " + TABLE_FILM + " ("
                + COLUMN_ID_FILM + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_USERNAME + " TEXT, "
                + COLUMN_USER_EMAIL + " TEXT, "
                + COLUMN_TEL + " INTEGER, "
                + COLUMN_ADRESS + " TEXT);";
        db.execSQL(CREATE_FILM_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILM);
        onCreate(db);
    }
    public boolean addUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        long result=db.insert(TABLE_USER, null, values);
        db.close();
        return result != -1;
    }
    public boolean addFilm(String username, String email, String tel, String adress) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, username);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_TEL, tel);
        values.put(COLUMN_ADRESS, adress);
        long result=db.insert(TABLE_FILM, null, values);
        db.close();
        return result != -1;
    }


    public boolean checkUser(String username, String psw) {

        SQLiteDatabase db = this.getReadableDatabase();
        // Requête SQL pour vérifier si un utilisateur avec cet email et mot de passe existe
        String query = "SELECT * FROM " + TABLE_USER + " WHERE "
                + COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, psw});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists;// Si l'utilisateur existe, retourne true.
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, oldPassword});

        if (cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_PASSWORD, newPassword);
            db.update(TABLE_USER, values, COLUMN_USERNAME + " = ?", new String[]{username});
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
    public Cursor getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_USER, null, null, null, null, null, null);
    }

}
