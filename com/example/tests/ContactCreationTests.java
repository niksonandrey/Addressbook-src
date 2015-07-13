package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact_tmp) {
	app.getNavigationHelper().openMainPage();
	
	// save initial state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
	app.getContactHelper().initContactCreation();
	app.getContactHelper().fillContactForm(contact_tmp);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact_tmp);
    Collections.sort(newList);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

}
