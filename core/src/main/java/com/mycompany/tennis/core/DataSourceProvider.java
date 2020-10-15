package com.mycompany.tennis.core;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    private static BasicDataSource singleDataSource;
  public  static DataSource getSingleDataSourceInstance() {
        if(singleDataSource == null) {
            String url = "jdbc:mysql://localhost:3306/TENNIS?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
            String user = "root";
            String password = "password";
             singleDataSource = new BasicDataSource();
            singleDataSource.setInitialSize(5);
            singleDataSource.setUrl(url);
            singleDataSource.setUsername(user);
            singleDataSource.setPassword(password);

        }
        return singleDataSource;
    }

}
