package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact_tmp) {
		app.getNavigationHelper().openMainPage();
		
		// save initial state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    app.getContactHelper().initContactModificatation(index);
		app.getContactHelper().fillContactForm(contact_tmp);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(index);
	    oldList.add(contact_tmp);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
