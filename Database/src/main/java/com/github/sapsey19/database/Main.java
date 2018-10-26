package com.github.sapsey19.database;

/**
 *
 * @author Saspey
 */
public class Main {

    public static String DEFAULT_DB = "tests.db";
    public static String DEFAULT_URL = "jdbc:sqlite:" + DEFAULT_DB;

    public static void main(String[] args) {

        DBHelper db = new DBHelper();

        //db.createNewDatabase(DEFAULT_DB);
        //db.createNewTable();
        db.insert("Raw Materials", 3000);
        db.insert("Semifinished Goods", 4000);
        db.insert("Finished Goods", 5000);
        db.selectAll();
    }
}
