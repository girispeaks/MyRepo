package com.selcukesfw.stepimplementations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.BeforeClass;

public class dateCreation {
	@BeforeClass
	 public String dates(){
         Date today = new Date();
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
         df.setTimeZone(TimeZone.getTimeZone("PST"));
         String PST = df.format(today);
         return PST;
	   }
	@BeforeClass
	  public String dayAfterStart(){
          Date today = new Date();
          DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
          df.setTimeZone(TimeZone.getTimeZone("PST"));
          String PST = df.format(today);
          Calendar cal = Calendar.getInstance();
          cal.setTime(today);
          cal.add(Calendar.DAY_OF_YEAR, 2); 
          Date tomorrow = cal.getTime();
          String futuStartDate = df.format(tomorrow);
          return futuStartDate;
   }
	  @BeforeClass
	  public String dayAfterEnd(){
          Date today = new Date();
          DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
          df.setTimeZone(TimeZone.getTimeZone("PST"));
          String PST = df.format(today);
          Calendar cal = Calendar.getInstance();
          cal.setTime(today);
          cal.add(Calendar.DAY_OF_YEAR, 4); 
          Date tomorrow = cal.getTime();
          String futuEndDate = df.format(tomorrow);
          return futuEndDate;
   }
}
