package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String accname;
	private String surname;
	private String address1;
	private String mobilephone;
	private String homephone;
	private String workphone;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;
	private String phone2;

	public ContactData(String accname, String surname, String address1,
			String mobilephone, String homephone, String workphone,
			String email1, String email2, String bday, String bmonth,
			String byear, String address2, String phone2) {
		this.accname = accname;
		this.surname = surname;
		this.address1 = address1;
		this.mobilephone = mobilephone;
		this.homephone = homephone;
		this.workphone = workphone;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
	}

	public ContactData() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	/*	result = prime * result + ((accname == null) ? 0 : accname.hashCode());
		result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		result = prime * result
				+ ((homephone == null) ? 0 : homephone.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
	*/	return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (accname == null) {
			if (other.accname != null)
				return false;
		} else if (!accname.equals(other.accname))
			return false;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (homephone == null) {
			if (other.homephone != null)
				return false;
		} else if (!homephone.equals(other.homephone))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactData [accname=" + accname + ", surname=" + surname
				+ ", homephone=" + homephone + ", email1=" + email1 + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		if (this.surname.toLowerCase().equals(other.surname.toLowerCase())) {
			if (this.accname.toLowerCase().equals(other.accname.toLowerCase())) {
				if (this.email1.toLowerCase().equals(other.email1.toLowerCase())) {
					return this.homephone.compareTo(other.homephone);
				} else {
					return this.email1.toLowerCase().compareTo(other.email1.toLowerCase());
				}

			} else {
				return this.accname.toLowerCase().compareTo(other.accname.toLowerCase());
			}
		} else {
			return this.surname.toLowerCase().compareTo(other.surname.toLowerCase());
		}
	}

	public ContactData withAccName(String accname) {
		this.accname = accname;
		return this;
	}

	public ContactData withSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public ContactData withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public ContactData withMobilePhone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withHomePhone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withWorkPhone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBDay(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBMonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withBYear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getAccname() {
		return accname;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress1() {
		return address1;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

}