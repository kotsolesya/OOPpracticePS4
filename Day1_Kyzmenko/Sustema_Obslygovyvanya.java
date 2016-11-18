package com.company;
import java.util.Scanner;
import java.io.IOException;

public class Sustema_Obslygovyvanya {
    String nazvaPrustroya;
    String novuyPrustriy;
    int kilkist_prusrtoiv=5;
    int obmejenya_chergu=3;
    int ser_time_obslygov_inPrustriy;
    int ser_timeNahodjen_vumog_naObslygov;

    void addPrustriyObslug() {                    //метод 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть новий пристрій обслуговування: ");
        String novuyPrustriy = sc.next();
        System.out.println("Новий пристрій обслуговування:"+novuyPrustriy);
    }

    void Vuluchutu_PrustriyObslug() {             //метод 2
        System.out.println("Введіть пристрій який ви хочите вилучить:");
        Scanner sc = new Scanner(System.in);
        String nazvaPrustroya = sc.next();
        System.out.println("Вилучений пристрій:"+ nazvaPrustroya);
    }

    void Kilkict_zaynytuhPrustroiv() {            //метод 3
        System.out.println(kilkist_prusrtoiv);
    }

    void lengthChergu() {                         //метод 4

    }

    void zuynaytu_system_masovogo_obslyg() {      //метод 5

    }

    void zvilnutu_system_masovogo_obslyg() {      //метод 6

    }

    public static void main(String[] args) {
        System.out.println("Виберіть операцію:\n  \t1 - додати пристрій обслуговування,\n" +
                "\t2 - вилучити пристрій обслуговування,\n" +
                "\t3 - визначити кількість зайнятих пристроїв,\n" +
                "\t4 - визначити довжину черги,\n" +
                "\t5 - зайняти систему масового обслуговування,\n" +
                "\t6 - звільнити систему масового обслуговування\n");
        Sustema_Obslygovyvanya obj1 = new Sustema_Obslygovyvanya();


        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String dayString;

        switch (a) {
            case "1": {obj1.addPrustriyObslug();}
                break;
            case "2":  {obj1.Vuluchutu_PrustriyObslug();}
                break;
            case "3": {obj1.Kilkict_zaynytuhPrustroiv();}
                break;
            case "4":  {obj1.lengthChergu();}
                break;
            case "5":  {obj1.zuynaytu_system_masovogo_obslyg();}
                break;
            case "6":  {obj1.zvilnutu_system_masovogo_obslyg();}
                break;
            default: dayString = "Ошибка";
                break;
        }
        System.out.print("Програма закінчила свою роботу");
    }
}
