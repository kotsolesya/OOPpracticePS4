package avtivka;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
	public class Main{
		public static void main(String[] args) {
	       String marka="���";
	       String rik="1978";
	       String tehnogl="2013";
	       int kst_misc=5;
	       double kost_fuel = 20.50;
	       int speed = 110;
	       int distance=1000000;
	   
	       
	       Scanner a = new Scanner(System.in);
	       String komand;
	       System.out.println("��� ��������� ����� ������ 'Show'"+"\n��� ����� ���� ����� ������ 'Input'"+"\n��� ������ �������� q");
	       
	       while(true)
	       {
	    	   komand=a.nextLine();
	       
	       if(komand.equals("Show")){
	    	   System.out.println("�����: "+marka+"\nг�: "+rik+"\n��������: "+tehnogl+
	    			   			"\nʳ������ ����: "+kst_misc+"\n������� ������: "+kost_fuel+
	    			   			"\n��������: "+speed+"\n���������: "+distance);
	    	   
	       }
	       else if(komand.equals("Input")){
	    		  System.out.print("�����: ");
	    		  marka=a.nextLine();
	    		  System.out.print("г�: ");
	    		  rik=a.nextLine();
	    		  System.out.print("��������: ");
	    		  tehnogl=a.nextLine();
	    		  System.out.print("ʳ������ ����: ");
	    		  kst_misc=a.nextInt();
	    		  System.out.print("������� ������: ");
	    		  kost_fuel=a.nextDouble();
	    		  System.out.print("��������: ");
	    		  speed=a.nextInt();
	    		  System.out.print("���������: ");
	    		  distance=a.nextInt();
	    		  }
	       else if(komand.equals("q")){ System.out.println("��������");}
	       else {System.out.println("������ �������");}
	       
	       
	       }  
	    }
}




