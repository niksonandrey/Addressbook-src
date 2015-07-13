package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		// save initial state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    app.getContactHelper().initContactModificatation(index);
		app.getContactHelper().submitContactRemoval();
		app.getContactHelper().returnHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(index);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
