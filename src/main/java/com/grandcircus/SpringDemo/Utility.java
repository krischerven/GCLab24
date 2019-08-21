package com.grandcircus.SpringDemo;
import java.util.Calendar;

public class Utility {
	public static String footer() {
		return "<br><br><br><br><br><h4><em>&nbsp;&nbsp;<a href=\"home\">Return to index</a></em></h4>&nbsp;&nbsp;&nbsp;&copy;Kris Cherven " + 
			Calendar.getInstance().get(Calendar.YEAR);
	}
}