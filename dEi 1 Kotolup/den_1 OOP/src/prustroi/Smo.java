package prustroi;

import java.util.Scanner;

class Smoo{
	

	static int kil_prust=0;
	int obm_cherg=2;
	int ser_chas_obsl_prust=30;
	int ser_chas_vumog=30;
	
// метод присвоєння значень змінним
	void dod_prust_obsl(char computer,char printer, char tester){
		kil_prust = computer;
		kil_prust = printer;
		kil_prust = tester;
	}
	
// метод для обчислення
	void dodatu_prustrii(){
		Scanner kil_prust = new Scanner(System.in);  // Reading from System.in
		 System.out.println("Введіть новий пристрій: ");
		 String nazvPrist = kil_prust.next();
		 System.out.println("Новий пристрій: "+ nazvPrist);
	}

void vudal_prustrii(){
	System.out.println("Введіть новий пристрій: ");
		Scanner kil_prust = new Scanner(System.in);  // Reading from System.in
		 
		 String nazvPrist = kil_prust.next();
		 System.out.println("Новий пристрій: ");
	}
	/*
	int vuzn_kil_zain_prustroiv(){
		
	}
	
	double vuzn_dovz_cherg(){

	}
	
	double zainytu_sust_mas_obslug(){
	
	}
	
	double zviln_sust_mas_obslug(){

	}*/
}

public class Smo {
public static void main (String[] args){
//створюємо перший пристрій обслуговування
	Smoo mysmoo1 = new Smoo();
//викликаємо метод в меню
	 System.out.println("						Menu						");
	 System.out.println("				1. Додати пристрій обслуговування			");
	 System.out.println("				2. Вилучити пристрій обслуговування			");
	 System.out.println("				3. Визначити кількість зайнятих пристроїв	");
	 System.out.println("				4. Визначити довжину черги					");
	 System.out.println("				5. Зайняти систему масового обслуговування	");
	 System.out.println("				6. Звільнити систему масового обслуговування");
	  
Scanner reader = new Scanner(System.in);  // Reading from System.in
	 System.out.println("					Введіть номер пункту меню: ");
	 int smur = reader.nextInt(); 
	switch (smur) {
	    case (1) : {mysmoo1.dodatu_prustrii();}
	             break;
	    case (2): {mysmoo1.vudal_prustrii();}
	            break;
	            /* case (3):  System.out.println("dsfdsfdsf = " + mysmoo1.vuzn_kil_zain_prustroiv()+ "хв.");
	             break;
	    case (4):  System.out.println("ghjghghgh = " + mysmoo1.vuzn_dovz_cherg()+ "хв.");
	             break;
	    case (5):  System.out.println("dfgasgre = " + mysmoo1.zainytu_sust_mas_obslug()+ "хв.");
	             break;
	    case (6):  System.out.println("gdfsgrere = " + mysmoo1.zviln_sust_mas_obslug()+ "хв.");
	             break;*/
default:
	}

	
	//для чого викликаємо метод safeVolume(), який повертає обчислений об'єм кожного сейфу
    
	
}
}
