package com.example.contactapp;

public class Constants {

    public static final String DATABASE_NAME = "Contact_DB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Contact_Table";

    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_PHONE = "PHONE";
    public static final String C_EMAIL = "EMAIL";
    public static final String C_NOTE = "NOTE";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_NAME + " TEXT, "
            + C_PHONE + " TEXT, "
            + C_EMAIL + " TEXT, "
            + C_NOTE + " TEXT "
            + " );";
}
