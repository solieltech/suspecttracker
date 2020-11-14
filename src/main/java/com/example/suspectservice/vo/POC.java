package com.example.suspectservice.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.activation.MailcapCommandMap;

import com.google.gson.Gson;

import lombok.Data;

public class POC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java.time.LocalDateTime.now()
		//System.out.println(java.time.LocalDateTime.now());
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
	    String strDate = formatter.format(date);  
	    //System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);  
	    
	    
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
	    String date1 = "23-Mar-2019";
	   // LocalDateTime localDate = LocalDateTime.parse(strDate);
	    //System.out.println(localDate);
	    
	    
	    
	    
	    Person p =new Person();
	    p.setName("Kiran");
	    
	    List<Person> pList = new ArrayList<>();
	    Person p1=new Person();p1.setName("Sycho");
	    Person p2=new Person();p2.setName("Mr.cool");pList.add(p1);pList.add(p2);
	    p.setPersonList(pList);
	    
	    
	    List<Person> mainList = new ArrayList<>();
	    mainList.add(p);
	    
	
		
		  List<Person> flat = mainList.stream().map(x->{
		  if(x.getPersonList().size()>0) { return x.getPersonList();
		  } return null; }).flatMap(x->x.stream()).collect(Collectors.toList());
		 
	    
	    System.out.println(new Gson().toJson(mainList));
	    System.out.println(new Gson().toJson(flat));
	    
	    
	    
	    
	}

}
@Data
class Person {
	
	private String name;
	private List<Person> personList= new ArrayList<Person>();
	
}
