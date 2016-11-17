package day3;
import java.util.*;
public class LockTester {

	
	



		public static class Lock
		{
		  private boolean nutural = true; 
		  private boolean flag1, flag2, flag3;
		  private int one, two, three, five, four,six, seven,eight,nine, ten;
		  private boolean unlock = true; 
		  private int position = 0; 

		  public Lock (int one, int two, int three)
		  {
			  Scanner scan = new Scanner(System.in); 
			  
		
			  this.one = one;
			  
		    this.two = two;
		    this.three = three;
		  }
		  public void turnRight (int ticks) // 
		  {
		    if (nutural)
		    {
		      position = (40 - ticks);
		      flag1 = false;
		      nutural = false;
		      if (position == one)
		      {
		        flag1 = true;
		       // System.out.println(position);
		      }
		    }
		    else
		    {
		      if (position - ticks > 0 )
		      {
		        position = position - ticks; 
		        // System.out.println(position);
		        flag3 = false; 
		        if (position == three)
		        {
		          flag3 = true; 
		        }
		      }
		      else 
		      {
		        position = (40 - (ticks - position));
		        flag3 = false;
		        //  System.out.println(position);
		        if (position == three )
		        {
		          flag3 = true;
		        }
		      }
		    }
		  }
		  public void turnLeft (int ticks) // turns the dial left the given number of ticks
		  {
		    if (position + ticks < 40 )
		    {
		      position = (position + ticks);
		      // System.out.println(position);
		      flag2 = false;
		      if (position == two )
		      {
		        flag2 = true;
		      }
		    }
		    else
		    {
		      position = ( (position + ticks) - 40 );
		      // System.out.println(position);
		      flag2 = false;  
		      if (position == two) 
		      {
		        flag2 = true; 
		      }
		    }
		  }
		  public void reset ()// встановлює перемикач на 0
		  {
		    nutural = true; 
		    flag1 = false;
		    flag2 = false;
		    flag3 = false; 
		  }
		  public void open ()
		  {
		    if (!(flag1 && flag2 && flag3))
		    {
		      unlock = false;
		      System.out.println("Неправильна комбінація!!"); 
		    }
		    else
		    {
		    System.out.println("Замок відкритий!!");
		    }
		  }
		  public static void main(String[] args)
		  {
		    Lock lock = new Lock(35, 12, 37);
		    lock.turnRight(5);
		    lock.turnLeft(17);
		    lock.turnRight(15);
		    lock.open();
		  }
		}

	}
