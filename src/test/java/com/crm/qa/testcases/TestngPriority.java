package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPriority {

	@BeforeSuite
	public void bsuite(){
		System.out.println("1.before suite");
	}
	@BeforeTest
	public void btest(){
		System.out.println("2.Before test");
	}
	@BeforeClass
	public void bclass(){
		System.out.println("3.before class");
	}
	@BeforeMethod
	public void bmethod(){
		System.out.println("4.before method");
	}
	@Test
	public void test(){
		System.out.println("5.test");
	}
	@Test
	public void test1(){
		System.out.println("test1");
	}
	@AfterMethod
	public void amethod(){
		System.out.println("6.After method");
	}
	@AfterClass
	public void aclass(){
		System.out.println("7.After class");
	}
	@AfterTest
	public void atest(){
		System.out.println("8.After test");
	}
	@AfterSuite
	public void asuite(){
		System.out.println("9.After suite");
	}
}
