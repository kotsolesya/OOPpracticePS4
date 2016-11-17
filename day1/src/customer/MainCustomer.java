package customer;
import java.util.Scanner;

public class MainCustomer {
	private static Scanner sc;
	private static Scanner sd;

	public static void main(String [] args)

	  {
		Customer customer = new Customer();
		boolean exit=false;
		sc = new Scanner(System.in);    
	    
	      System.out.println("Menu");
	      System.out.println("1 - Enter new card number");
	      System.out.println("2 - Increase count of purchase");
	      System.out.println("3 - Increase summary price of all purchases ");
	      System.out.println("4 - Increase summary count of purchases ");
	      System.out.println("0 - Exit");
	      do
	    { sd = new Scanner(System.in);
	      System.out.println("enter your choice");
	      int num=sd.nextInt();
	     switch(num)
	     {
	     case 0:{
	 		exit=true;
	 		break;
	 		}
	 	case 1:{
	 		System.out.println("Input new card Number. Length must be equals to 7");
	 		String card;
	 		card=sc.nextLine();
	 		customer.setNumberOfCard(card);
	 		if(card.length()==6)
	 		System.out.println("Error!!!");
	 		System.out.println("New Card Number : "+customer.getNumberOfCard());
	 		break;	
	 		
	 	}
	 	case 2:{
	 		System.out.println("Input count of purchases you want to add."
	 				+ " Not equals to null, please");
	 		int count;
	 		count=sc.nextInt();
	 		if(count!=0)
	 		customer.setCountOfPurchase(customer.countOfPurchase+count);
	 		else
	 		System.out.println("Error!!!");
	 		System.out.println("Count of purchases : "+customer.getCountOfPurchase());break;	
	 	}
	 	case 3:{
	 		System.out.println("Input summary price of purchases you want to add."
	 				+ " Not equals to null, please");
	 		double count;
	 		count=sc.nextDouble();
	 		if(count!=0)
	 	customer.setcountPriceOfGoods(customer.countPriceOfGoods+count);
	 		else
	 		System.out.println("Error!!!");
	 		System.out.println("Summary price of purchases : "+customer.getcountPriceOfGoods());
	 		break;	
	 	}
	 	case 4:{
	 		System.out.println("Input summary count of visits you want to add."
	 				+ " Not equals to null, please");
	 		int count;
	 		count=sc.nextInt();
	 		if(count!=0)
	 		customer.setcountOfVisits(customer.countOfVisits+count);
	 		else
	 		System.out.println("Error!!!");	
	 		System.out.println("summary count of visits : "+customer.getcountOfVisits());
	 		break;
	 	}
	 	default: exit=true; break;
	 	}
	    }while(!exit);
	}
    }
