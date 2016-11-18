package avtivka;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
	public class Main{
		public static void main(String[] args) {
	       String marka="Ваз";
	       String rik="1978";
	       String tehnogl="2013";
	       int kst_misc=5;
	       double kost_fuel = 20.50;
	       int speed = 110;
	       int distance=1000000;
	   
	       
	       Scanner a = new Scanner(System.in);
	       String komand;
	       System.out.println("Для перегляду даних введіть 'Show'"+"\nДля вводу своїх даних введіть 'Input'"+"\nДля виходу натисніть q");
	       
	       while(true)
	       {
	    	   komand=a.nextLine();
	       
	       if(komand.equals("Show")){
	    	   System.out.println("Марка: "+marka+"\nРік: "+rik+"\nТехогляд: "+tehnogl+
	    			   			"\nКількість місць: "+kst_misc+"\nВартість палива: "+kost_fuel+
	    			   			"\nШвидкість: "+speed+"\nДистанція: "+distance);
	    	   
	       }
	       else if(komand.equals("Input")){
	    		  System.out.print("Марка: ");
	    		  marka=a.nextLine();
	    		  System.out.print("Рік: ");
	    		  rik=a.nextLine();
	    		  System.out.print("Техогляд: ");
	    		  tehnogl=a.nextLine();
	    		  System.out.print("Кількість місць: ");
	    		  kst_misc=a.nextInt();
	    		  System.out.print("Вартість палива: ");
	    		  kost_fuel=a.nextDouble();
	    		  System.out.print("Швидкість: ");
	    		  speed=a.nextInt();
	    		  System.out.print("Дистанція: ");
	    		  distance=a.nextInt();
	    		  }
	       else if(komand.equals("q")){ System.out.println("зупинено");}
	       else {System.out.println("Невірна команда");}
	       
	       
	       }  
	    }
}




