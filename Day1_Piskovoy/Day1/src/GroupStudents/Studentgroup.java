package GroupStudents;
public class Studentgroup{
 
	static String nazva_group = "ПС 4-1";
	static String spisok_studentiv ="\n1. Пісковий Денис Вадимович \n"
									+"2. Паршук Сергій Віталійович \n"
									+"3. Підмогильний Олександр Сергійович";
	static String spisok_disciplin = "\n1. ІЗВП \n"
									+"2. OOП\n"
									+"3. КПЗ\n"
									+"4. ОС\n"
									+"5. Фізкультура";
	static String rozklad_zanyat = "\nПонеділок:\n"
									+ "1. ІЗВП \n"
									+ "2. ОС \n"
									+ "3. КПЗ \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "Вівторок:\n"
									+ "1. Фізкультура \n"
									+ "2. ООП \n"
									+ "3. ОС \n"
									+ "4. ОС \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "Середа:\n"
									+ "1. КПЗ \n"
									+ "2. Фізкультура \n"
									+ "3. ООП \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "Четвер: \n"
									+ "1. ІЗВП \n"
									+ "2. КПЗ \n"
									+ "3. ООП \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "П'ятниця: \n"
									+ "1. ООП \n"
									+ "2. Фізкультура \n"
									+ "3. КПЗ";
	

	public static void main(String[] args) {

        System.out.println("Назва групи "+ nazva_group);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список студентів: "+ spisok_studentiv);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список дисциплін: "+ spisok_disciplin);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Розклад занять: "+ rozklad_zanyat);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
 
}