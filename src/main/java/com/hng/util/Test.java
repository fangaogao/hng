package com.hng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		//String startdate="2013-08-31";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();

		Calendar cld=Calendar.getInstance();

		cld.setTime(date);

		cld.add(Calendar.DATE, 1);

		
		System.out.println(sdf.format(cld.getTime()));
	}
}
