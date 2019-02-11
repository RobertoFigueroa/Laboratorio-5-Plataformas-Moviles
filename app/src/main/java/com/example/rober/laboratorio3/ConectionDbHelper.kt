package com.example.rober.laboratorio3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.rober.laboratorio3.Utilities.Utilities

class ConectionDbHelper  : SQLiteOpenHelper {


    constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : super(
        context,
        name,
        factory,
        version
    )

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Utilities.CREATE_USER_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

}