package com.hcl.utility;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class  LocalDateTimeUtility{

	/*

		    @Override 
		    public LocalDateTime convert(Date source) { 
		        return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault()); 
		    }*/
	public static void main(String ar[]){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");		
		Date date1 = Calendar.getInstance().getTime();	
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today.toString());
		/*CharSequence c="2017-01-17T00:36:00.000Z";
		Instant in=Instant.parse(c);
		System.out.println(in);*/
		
		
		
		
		String strDate = today.toString();
		LocalDate aLD = LocalDate.parse(strDate);
		DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		//CharSequence c="2017-01-17T00:36:00.000Z";
		
		CharSequence c=dTF.format(aLD);
		System.out.println(aLD + " formats as " + c);
		Instant in=Instant.parse(c);
		
	}
	
	
	public  Date getDate()  {
		try{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return ft.parse(ft.format(dNow));
		}catch(Exception eee){
			
		}
		return null;
	}
}
