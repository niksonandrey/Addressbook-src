package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp(){
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown(){
		app.stop();
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group  = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[] {group});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt(1000);
		}
	}
	
	public String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return null;
		} else {
			return "" + rnd.nextInt(10000000);
		}
	}
	
	public String generateRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[new Random().nextInt(11)];
}

	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			ContactData contact_tmp  = new ContactData()
			.withAccName(generateRandomString())
			.withSurname(generateRandomString())
			.withAddress1(generateRandomString())
		    .withMobilePhone(generateRandomNumber())
		    .withHomePhone("057" + (rnd.nextInt(10000000) + 1))
		    .withWorkPhone(generateRandomNumber())
		    .withEmail1((rnd.nextInt(1000) + 1) + "email1@trp.sw")
		    .withEmail2(generateRandomString() + "email2@trp.sw")
		    .withBDay("" + (rnd.nextInt(30) + 1))
		    .withBMonth(generateRandomMonth())
		    .withBYear("" + (rnd.nextInt(2000) + 1))
		    .withAddress2(generateRandomString())
		    .withPhone2(generateRandomNumber());
			list.add(new Object[] {contact_tmp});
		}
		return list.iterator();
	}
}
