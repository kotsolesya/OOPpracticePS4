import java.util.Scanner;

public class MainCustomer {
	private static Scanner sc;
	private static Scanner sd;

	public static void main(String [] args)

	  {
		Customer customer = new Customer();
		boolean exit=false;
		sc = new Scanner(System.in);    
	    
	      System.out.println("Меню");
	      System.out.println("1 - Введіть новий номер карти");
	      System.out.println("2 - Збільшити кількість покупки");
	      System.out.println("3 - Збільшення підсумкову вартість всіх покупок ");
	      System.out.println("4 - Збільшення зведену кількість покупок ");
	      System.out.println("0 - Вихід");
	      do
	    	{ 
sd = new Scanner(System.in);
	      	System.out.println("Введіть свій вибір");
	      	int num=sd.nextInt();
	     	switch(num)
	     	{
	     	case 0:{
	 	exit=true;
	 	break;
	 		}
	 	case 1:{
	 	System.out.println("Введіть новий номер карти. Довжина повинна дорівнювати 7");
	 	String card;
	 	card=sc.nextLine();
	 	customer.setNumberOfCard(card);
	 	if(card.length()==6)
	 	System.out.println("Error!!!");
	 	System.out.println("Новий номер карти : "+customer.getNumberOfCard());
	 		break;	
	 		
	 	}
	 	case 2:{
	 	System.out.println("Введення кількості покупок, яких ви хочете додати."
	 				+ " Не дорівнює нулю, будь ласка");
	 	int count;
	 	count=sc.nextInt();
	 	if(count!=0)
	 	customer.setCountOfPurchase(customer.countOfPurchase+count);
	 	else
	 	System.out.println("Error!!!");
System.out.println("Кількість покупок : "+customer.getCountOfPurchase());break;	
	 	}
	 	case 3:{
	 	System.out.println("Введення ціни покупок, яких ви хочете додати."
	 				+ " Не дорівнює нулю, будь ласка");
	 	double count;
	 	count=sc.nextDouble();
	 	if(count!=0)
	 	customer.setcountPriceOfGoods(customer.countPriceOfGoods+count);
	 	else
	 	System.out.println("Error!!!");
System.out.println("Сумарна ціна покупки : "+customer.getcountPriceOfGoods());
	 	break;	
	 	}
	 	case 4:{
	 	System.out.println("Введення кількості відвідувань ви хочете додати."
	 				+ " Не дорівнює нулю, будь ласка");
	 	int count;
	 	count=sc.nextInt();
	 	if(count!=0)
	 	customer.setcountOfVisits(customer.countOfVisits+count);
	 	else
	 	System.out.println("Error!!!");	
	 System.out.println("Кількість відвідувань : "+customer.getcountOfVisits());
	 	break;
	 	}
	 	default: exit=true; break;
	 	}
	    }while(!exit);
}}
