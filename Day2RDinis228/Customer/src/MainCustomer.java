import java.util.Scanner;

public class MainCustomer {
	private static Scanner sc;
	private static Scanner sd;

	public static void main(String [] args)

	  {
		Customer customer = new Customer();
		boolean exit=false;
		sc = new Scanner(System.in);    
	    
	      System.out.println("����");
	      System.out.println("1 - ������ ����� ����� �����");
	      System.out.println("2 - �������� ������� �������");
	      System.out.println("3 - ��������� ��������� ������� ��� ������� ");
	      System.out.println("4 - ��������� ������� ������� ������� ");
	      System.out.println("0 - �����");
	      do
	    	{ 
sd = new Scanner(System.in);
	      	System.out.println("������ ��� ����");
	      	int num=sd.nextInt();
	     	switch(num)
	     	{
	     	case 0:{
	 	exit=true;
	 	break;
	 		}
	 	case 1:{
	 	System.out.println("������ ����� ����� �����. ������� ������� ���������� 7");
	 	String card;
	 	card=sc.nextLine();
	 	customer.setNumberOfCard(card);
	 	if(card.length()==6)
	 	System.out.println("Error!!!");
	 	System.out.println("����� ����� ����� : "+customer.getNumberOfCard());
	 		break;	
	 		
	 	}
	 	case 2:{
	 	System.out.println("�������� ������� �������, ���� �� ������ ������."
	 				+ " �� ������� ����, ���� �����");
	 	int count;
	 	count=sc.nextInt();
	 	if(count!=0)
	 	customer.setCountOfPurchase(customer.countOfPurchase+count);
	 	else
	 	System.out.println("Error!!!");
System.out.println("ʳ������ ������� : "+customer.getCountOfPurchase());break;	
	 	}
	 	case 3:{
	 	System.out.println("�������� ���� �������, ���� �� ������ ������."
	 				+ " �� ������� ����, ���� �����");
	 	double count;
	 	count=sc.nextDouble();
	 	if(count!=0)
	 	customer.setcountPriceOfGoods(customer.countPriceOfGoods+count);
	 	else
	 	System.out.println("Error!!!");
System.out.println("������� ���� ������� : "+customer.getcountPriceOfGoods());
	 	break;	
	 	}
	 	case 4:{
	 	System.out.println("�������� ������� ��������� �� ������ ������."
	 				+ " �� ������� ����, ���� �����");
	 	int count;
	 	count=sc.nextInt();
	 	if(count!=0)
	 	customer.setcountOfVisits(customer.countOfVisits+count);
	 	else
	 	System.out.println("Error!!!");	
	 System.out.println("ʳ������ ��������� : "+customer.getcountOfVisits());
	 	break;
	 	}
	 	default: exit=true; break;
	 	}
	    }while(!exit);
}}
