package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
	    String host="localhost";
	    String port="3306";

	      Connection con=DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/Demo","root","admin");

	      Statement s=con.createStatement();
	      ResultSet rs=s.executeQuery("select * from credentials where scenario='Zerobalancecard'");
	      while(rs.next())
	{	 
	  		System.setProperty("webdriver.gecko.driver","C:\\Users\\kusuma\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 FirefoxDriver driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.get("https://login.salesforce.com/");
			 driver.findElementByXPath("//input[@id='username']").sendKeys(rs.getString("username"));
	     //System.out.println(rs.getString("username"));
			 driver.findElementByXPath("//input[@id='password']").sendKeys(rs.getString("password"));
	     //System.out.println(rs.getString("password"));
			 driver.close();
	}

	}

}
