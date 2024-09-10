package com.jdbcexample.connectionconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

  public static Connection getConnection() {
    Connection con = null;
    Properties properties = new Properties();
    try {
      FileInputStream fileInputStream = new FileInputStream("resources/database.properties");
      // loading propertie file
      properties.load(fileInputStream);
      // getting the driver class
      String driverClass = properties.getProperty("jdbc.driverClassName");
      // getting url
      String url = properties.getProperty("jdbc.url");
      // String username
      String userName = properties.getProperty("jdbc.username");
      // String password
      String userPwd = properties.getProperty("jdbc.password");
      Class.forName(driverClass);
      con = DriverManager.getConnection(url, userName, userPwd);
      System.out.println("Opened database successfully");
    } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return con;
  }

}
