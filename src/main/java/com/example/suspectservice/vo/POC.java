package com.example.suspectservice.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class POC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java.time.LocalDateTime.now()
		System.out.println(java.time.LocalDateTime.now());
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
	    String strDate = formatter.format(date);  
	    System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);  
	    
	    
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
	    String date1 = "23-Mar-2019";
	    LocalDateTime localDate = LocalDateTime.parse(strDate);
	    System.out.println(localDate);
	    
	}

}
