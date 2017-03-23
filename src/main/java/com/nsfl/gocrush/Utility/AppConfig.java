/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsfl.gocrush.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class AppConfig {

    public Connection con;
    private static AppConfig instance;

    private AppConfig() {
        try {
            System.out.println("1");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("2");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gocrush", "root", "");
            if (con != null) {
                System.out.println("Connected to the database");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Not connected");
            System.err.println(e.getMessage());

        }
    }

    public static AppConfig getInstance() {
        if (instance == null) {

            instance = new AppConfig();

        }

        return instance;

    }
}
