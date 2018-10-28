package com.github.sapsey19.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sean Apsey
 */
public class DBHelper {

    public static String DEFAULT_DB = "Menu.db";
    public static String DEFAULT_URL = "jdbc:sqlite:" + DEFAULT_DB;

    public static void createNewDatabase(String fileName) {

        try (Connection conn = DriverManager.getConnection(DEFAULT_URL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS menu (\n"
                + "	itemNumber integer PRIMARY KEY,\n"
                + "	itemName text NOT NULL,\n"
                + "	priceInCents real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(DEFAULT_URL);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DEFAULT_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT itemNumber, itemName, priceInCents FROM menu";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("itemNumber") + "\t"
                        + rs.getString("ItemName") + "\t"
                        + rs.getDouble("priceInCents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String itemName, int priceInCents) {
        String sql = "INSERT INTO menu(itemName, priceInCents) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, itemName);
            pstmt.setInt(2, priceInCents);            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     public String getPriceGreaterThan(int priceInCents){
               String sql = "SELECT itemNumber, itemName, priceInCents " + "FROM menu WHERE priceInCents > ?";
               String result = "";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,priceInCents);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                result = rs.getString("itemName");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
     
     public String getPriceLessThan(int priceInCents){
               String sql = "SELECT itemNumber, itemName, priceInCents " + "FROM menu WHERE priceInCents < ?";
               String result = "";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,priceInCents);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                result = rs.getString("itemName");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
     
       public void update(int itemName, String name, double capacity) {
        String sql = "UPDATE warehouses SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, itemName);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
       
       public void delete(int itemName) { 
        String sql = "DELETE FROM warehouses WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, itemName);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
