package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {
		
		// save initial state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    app.getContactHelper().removeContact(index);

		//save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}
