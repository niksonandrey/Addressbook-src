package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnHomePage() {
		click(By.linkText("home page"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.accname);
		type(By.name("lastname"), contact.surname);
		type(By.name("address"), contact.address1);
		type(By.name("mobile"), contact.mobilephone);
		type(By.name("home"), contact.homephone);
		type(By.name("work"), contact.workphone);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		//selectByText(By.name("new_group"), "group 1");
		type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void initContactModificatation(int index) {
		click(By.xpath("(//input[@type='checkbox'])[" + (index+1) + "]"));		
		click(By.xpath("(//img[@title='Edit'])[" + (index+1) + "]"));
	}

	public void submitContactRemoval() {
		click(By.xpath("//input[@value='Delete']"));		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> contactRecords = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement contactRecord : contactRecords) {
		ContactData contact = new ContactData();
		contact.surname = contactRecord.findElement(By.xpath("./td[2]")).getText();
		contact.accname = contactRecord.findElement(By.xpath("./td[3]")).getText();
		contact.email1 = contactRecord.findElement(By.xpath("./td[4]")).getText();
		contact.homephone = contactRecord.findElement(By.xpath("./td[5]")).getText();
		contacts.add(contact);
		}
		return contacts;
	}

}
