package com.example.virtualcm.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "VirtualCM.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
           CREATE TABLE Cliente (
           cli_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
           cli_usu TEXT NOT NULL,
           cli_nom TEXT NOT NULL,
           cli_ape TEXT NOT NULL,
           cli_tele TEXT NOT NULL,
           cli_email TEXT NOT NULL,
           cli_pass TEXT NOT NULL
           )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Menu (
            menu_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            menu_nom TEXT NOT NULL,
            menu_des TEXT NOT NULL,
            menu_pre TEXT NOT NULL
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Cocinero (
            coci_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            coci_nom TEXT NOT NULL
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Pedido (
            ped_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            cli_id INTEGER NOT NULL,
            menu_id INTEGER NOT NULL,
            ped_monto REAL NOT NULL,
            ped_canti INTEGER NOT NULL,
            ped_fecha TEXT NOT NULL,
            coci_id INTEGER,
            FOREIGN KEY (cli_id) REFERENCES Cliente(cli_id),
            FOREIGN KEY (menu_id) REFERENCES Menu(menu_id),
            FOREIGN KEY (coci_id) REFERENCES Cocinero(coci_id)
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE HistorialPedido (
            hist_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            ped_id INTEGER NOT NULL,
            cli_id INTEGER NOT NULL,
            menu_id INTEGER NOT NULL,
            ped_canti INTEGER NOT NULL,
            ped_monto REAL NOT NULL,
            coci_id INTEGER,
            ped_fecha TEXT NOT NULL,
            FOREIGN KEY (ped_id) REFERENCES Pedido(ped_id),
            FOREIGN KEY (cli_id) REFERENCES Cliente(cli_id),
            FOREIGN KEY (menu_id) REFERENCES Menu(menu_id),
            FOREIGN KEY (coci_id) REFERENCES Cocinero(coci_id)
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Cliente")
        db.execSQL("DROP TABLE IF EXISTS Menu")
        db.execSQL("DROP TABLE IF EXISTS Cocinero")
        db.execSQL("DROP TABLE IF EXISTS Pedido")
        db.execSQL("DROP TABLE IF EXISTS HistorialPedido")
        onCreate(db)
    }
}