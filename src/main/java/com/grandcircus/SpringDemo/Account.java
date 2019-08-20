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
	public String getWelcomeMessage() {
		String ret = "<h1 style=\"text-align: center\">" + "Welcome, " + firstName + " " + lastName + "!" + "</h1>" + "<br><br>";
		ret += "<h3 style=\"text-align: center\">";
		ret += ("City: " + city + "<br>");
		ret += ("Address: " + address + "<br>");
		ret += ("Phone: " + phone + "<br>");
		ret += ("Email: " + email + "<br>");
		ret += "</h3>";
		return ret;
	}
}
