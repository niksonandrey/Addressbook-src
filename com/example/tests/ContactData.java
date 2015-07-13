package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String accname;
	public String surname;
	public String address1;
	public String mobilephone;
	public String homephone;
	public String workphone;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String phone2;

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

}