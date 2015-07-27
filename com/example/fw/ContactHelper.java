package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> contactRecords = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement contactRecord : contactRecords) {
		String surname = contactRecord.findElement(By.xpath("./td[2]")).getText();
		String accname = contactRecord.findElement(By.xpath("./td[3]")).getText();
		String email1 = contactRecord.findElement(By.xpath("./td[4]")).getText();
		String homephone = contactRecord.findElement(By.xpath("./td[5]")).getText();
		cachedContacts.add(new ContactData().withSurname(surname).withAccName(accname).withEmail1(email1).withHomePhone(homephone));
		}
	}

	public ContactHelper createContact(ContactData contact_tmp) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact_tmp, CREATION);
	    submitContactCreation();
	    returnHomePage();
	    rebuildCache();
	    return this;
	}
	
	public void removeContact(int index) {
		manager.navigateTo().mainPage();
	    initContactModificatation(index);
		submitContactRemoval();
		returnHomePage();
		rebuildCache();
	}

	public void modifyContact(int index, ContactData contact_tmp) {
		manager.navigateTo().mainPage();
	    initContactModificatation(index);
		fillContactForm(contact_tmp, MODIFICATION);
		submitContactModification();
		returnHomePage();
		rebuildCache();
	}


	// ----------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getAccname());
		type(By.name("lastname"), contact.getSurname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("home"), contact.getHomephone());
		type(By.name("work"), contact.getWorkphone());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
/*		if (formType == CREATION) {
			//selectByText(By.name("new_group"), "group 1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
			throw new Error ("Group selector exists in contact modification form");
			}
		}
*/		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper initContactModificatation(int index) {
		click(By.xpath("(//input[@type='checkbox'])[" + (index+1) + "]"));		
		click(By.xpath("(//img[@title='Edit'])[" + (index+1) + "]"));
		return this;
	}

	public ContactHelper submitContactRemoval() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;		
	}

}
