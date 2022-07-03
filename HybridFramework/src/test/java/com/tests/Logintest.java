package com.tests;

import org.testng.Assert;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Dashboardpage;
import com.pages.Loginpage;

public class Logintest extends BaseClass {

	Loginpage lp = null;
	Dashboardpage dp;
	@BeforeSuite
	public void setup() throws Exception {
		initialization();
		reportInit();
		lp = new Loginpage(driver);
	dp=new Dashboardpage(driver);
	}
	
	@AfterSuite
	public void tearDown(){
		driver.close();
		report.flush();
	}

	
	@Test
	public void passtest(){
	lp.loginToApplication("kiran@gmail.com", "123456");
	Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}
	
	@Test
	public void failtest(){
	Assert.assertTrue(false);
	}
	
	@Test
	public void skiptest(){

	throw new SkipException("We are skipping this");
	}
	
	@Test(dependsOnMethods="passtest")
	public void dashboardtest(){
		
		Assert.assertTrue(dp.verifyCourses());
	}
}
