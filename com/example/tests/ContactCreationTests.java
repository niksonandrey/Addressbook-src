package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact_tmp) {
	
	// save initial state
	 SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
	app.getContactHelper().createContact(contact_tmp);
    
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
assertThat(newList, equalTo(oldList.withAdded(contact_tmp)));
  }

}
