package com.grandcircus.SpringDemo;
import java.util.Calendar;

public class Utility {
	public static String copyright() {
		return "<br><br><br><br><br>&nbsp;&nbsp;&nbsp;&copy; Kris Cherven " + Calendar.getInstance().get(Calendar.YEAR);
	}
}