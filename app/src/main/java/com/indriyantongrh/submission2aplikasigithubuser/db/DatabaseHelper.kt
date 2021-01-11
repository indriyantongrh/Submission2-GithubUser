



 package com.indriyantongrh.submission2aplikasigithubuser.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import com.indriyantongrh.submission2aplikasigithubuser.db.DatabaseContract.GithubColumns;
import com.indriyantongrh.submission2aplikasigithubuser.db.DatabaseContract.GithubColumns.Companion.TABLE_NAME;



/**
 *  Create by Indriyantongrh on 11/26/20
 */

internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object {

        private const val DATABASE_NAME = "dbgithubuser"

        private const val DATABASE_VERSION = 1

        private val SQL_CREATE_TABLE_GITHUB = "CREATE TABLE $TABLE_NAME" +
                " (${GithubColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${GithubColumns.NAME} TEXT NOT NULL," +
                " ${GithubColumns.FOLLOWERS} TEXT NOT NULL," +
                " ${GithubColumns.FOLLOWING} TEXT NOT NULL," +
                " ${GithubColumns.AVATAR} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_GITHUB)
    }

    /*
    Method onUpgrade akan di panggil ketika terjadi perbedaan versi
    Gunakan method onUpgrade untuk melakukan proses migrasi data
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        /*
        Drop table tidak dianjurkan ketika proses migrasi terjadi dikarenakan data user akan hilang,
        */
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}