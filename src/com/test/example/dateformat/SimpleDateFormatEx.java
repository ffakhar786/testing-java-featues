package com.test.example.dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {

	public static void main(String[] args) {
		Date crtDate = new Date();
		DateFormat sqlformatter = new SimpleDateFormat("MMM, dd yyyy");
		String crteDteStr = sqlformatter.format(crtDate);
		System.out.println(crteDteStr);
	}

}
