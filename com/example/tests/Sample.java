package com.example.tests;

public class Sample {
	
	
	public static void main(String[] args){
		
		String a = "Some sentence with digits 3456839";
		String[] list = a.split("34");
		
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(a.substring(list[0].length()));
		System.out.println(a.toLowerCase().replace("3456839", "www"));
		System.out.println(a.substring(a.length()-7));
		System.out.println(a.replaceAll("[\\D]", ""));
		String b = a.replaceAll("[ a-zA-Z]", "");
		System.out.println(b.matches("\\d*"));
	}
}
