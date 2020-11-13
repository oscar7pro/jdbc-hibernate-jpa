/*
package com.mycompany.invoise.invoiseweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class OLDInvoiseWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OLDInvoiseWebApplication.class, args);
		DataSource dataSource = context.getBean(DataSource.class);
		Connection connection = null;
		try{
			connection = dataSource.getConnection();
			System.out.println("success");
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE");
			while (resultSet.next()) {
				System.out.println(resultSet.getLong("INVOICE_NUMBER") + " | "+resultSet.getString("CUSTOMER_NAME"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

}
*/