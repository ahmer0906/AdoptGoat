package com.adoptgoat.reusability;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericFunctions {
	
	public static String currentDateTime() {
		return new SimpleDateFormat("dd-MMM_hh-mm-SSS").format(new Date());
	}
}
