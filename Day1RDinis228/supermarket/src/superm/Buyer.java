package superm;
import java.util.Scanner;
public class Buyer {

		static int kilkist_pokupok =0;
		static int vartist_pokupok =2;	

	int zbil_kilkist_pokupok(int n){ // першиий метод
		kilkist_pokupok = kilkist_pokupok + n;
		return kilkist_pokupok;
	}
		
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int z;
        Buyer ob = new Buyer();

        System.out.print("«б≥льшити к≥льк≥сть в: ");
        if(sc.hasNextInt()) { 
          z = sc.nextInt(); 
          System.out.println(ob.zbil_kilkist_pokupok(z));
          
        } 
}
	int zbil_vartist_pokupok(int r){ // другий метод
		vartist_pokupok = vartist_pokupok + r;
		return vartist_pokupok;
	}
		
	public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int q;
        Buyer ob = new Buyer();

        System.out.print("«б≥льшити варт≥сть в: ");
        if(sc.hasNextInt()) { 
          q = sc.nextInt(); 
          System.out.println(ob.zbil_kilkist_pokupok(q));
          
        } 
        switch(2) {
        case kilkist_pokupok :
           // Statements
           break; // optional
        
        case vartist_pokupok :
           // Statements
           break; // optional
}
	} 	


        

