package GroupStudents;
public class Studentgroup{
 
	static String nazva_group = "�� 4-1";
	static String spisok_studentiv ="\n1. ϳ������ ����� ��������� \n"
									+"2. ������ ����� ³�������� \n"
									+"3. ϳ���������� ��������� ���������";
	static String spisok_disciplin = "\n1. ���� \n"
									+"2. OO�\n"
									+"3. ���\n"
									+"4. ��\n"
									+"5. Գ���������";
	static String rozklad_zanyat = "\n��������:\n"
									+ "1. ���� \n"
									+ "2. �� \n"
									+ "3. ��� \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "³������:\n"
									+ "1. Գ��������� \n"
									+ "2. ��� \n"
									+ "3. �� \n"
									+ "4. �� \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "������:\n"
									+ "1. ��� \n"
									+ "2. Գ��������� \n"
									+ "3. ��� \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "������: \n"
									+ "1. ���� \n"
									+ "2. ��� \n"
									+ "3. ��� \n"
									+ "_-_-_-_-_-_-_-_ \n"
									+ "�'������: \n"
									+ "1. ��� \n"
									+ "2. Գ��������� \n"
									+ "3. ���";
	

	public static void main(String[] args) {

        System.out.println("����� ����� "+ nazva_group);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("������ ��������: "+ spisok_studentiv);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("������ ��������: "+ spisok_disciplin);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("������� ������: "+ rozklad_zanyat);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
 
}