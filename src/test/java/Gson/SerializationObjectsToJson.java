package Gson;

import org.testng.annotations.Test;

import com.google.gson.Gson;

public class SerializationObjectsToJson {
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * ObjectsToJsonTest(); }
	 */
	
	@Test
	public static void ObjectsToJsonTest() {
		
		Persons p = new Persons();
		p.setFirstname("Jitendra");
		p.setLastname("punnam");
		p.setRollNo(234);
		
		System.out.println(p);
		
		
		Gson g = new Gson();
		
		String payLoad = g.toJson(p);
		
		System.out.println(payLoad);
		
	}
	
	

}
