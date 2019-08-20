package com.grandcircus.SpringDemo;
import java.util.ArrayList;
public class Data {
	private static ArrayList<Account> accounts = new ArrayList<>();
	public static void createAccount(String fname, String lname, String city, String address, String phone, String email) {
		accounts.add(new Account(fname, lname, city, address, phone, email));
	}
}