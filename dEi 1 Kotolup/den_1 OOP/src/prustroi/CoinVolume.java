package prustroi;

import java.util.Scanner;

public class CoinVolume {
	     public static void main(String[] args) {
	    
	    	 System.out.println("		Menu		");
	    	 System.out.println("1 show");
	    	 System.out.println("2 edit");
	    	  
	    Scanner reader = new Scanner(System.in);  // Reading from System.in
	    	 System.out.println("Enter a number: ");
	    	 int smur = reader.nextInt(); 
	    
	    	 switch(smur) {
	              case 1:
	                  System.out.println("Тест работает");
	                  break;
	             case 2:
	                  System.out.println("Тест добрый");
	                 break;
	             case 3:
	                 System.out.println("Тест поможет вам");
	                 break;
	             default:
	                 System.out.println("Тест интересный");
	                 break;
	         }
	     }
	 }