package com.grandcircus.SpringDemo;

public class Account {
	private String firstName;
	private String lastName;
	private String city;
	private String address;
	private String phone;
	private String email;
	public Account(String a, String b, String c, String d, String e, String f) {
		firstName = a;
		lastName = b;
		city = c;
		address = d;
		phone = e;
		email = f;
	}
	// getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCity() {
		return city;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	// misc
	public String getWelcomeMessage() {
		String ret = "<h1 style=\"text-align: center\">" + "Welcome, " + firstName + " " + lastName + "!" + "</h1>";
		ret += "<h3 style=\"text-align: center\">You've been registered.</h3><br><br><br><br><br>";
		ret += "<h4 style=\"text-align: justify; margin-left: 33%\">";
		ret += ("<strong>City</strong>: " + city + "<br>");
		ret += ("<strong>Address</strong>: " + address + "<br>");
		ret += ("<strong>Phone</strong>: " + phone + "<br>");
		ret += ("<strong>Email</strong>: " + email + "<br>");
		ret += "</h4>";
		return ret;
	}
}
