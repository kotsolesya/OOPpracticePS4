package GroupStudents;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
 
public class Group {
 
    private List<Student> studentsList;
 
    public Group() {
        studentsList = new ArrayList(30);
    }
 
    public void addStudent(BufferedReader br) throws IOException {
        System.out.print("������� ���: ");
        String name = br.readLine(); 
        System.out.print("������� �������: ");
        String surname = br.readLine(); 
        System.out.print("������� ����� ��������: "); 
        String phone = br.readLine(); 
        Student student = new Student(name, surname, phone);
        studentsList.add(student);
    }
 
    public void findStudent(BufferedReader br) throws IOException {
        System.out.print("������� (��� ��� �������) : ");
        String name = br.readLine();
        Boolean found = Boolean.FALSE;
        for (Student student : studentsList){
            if (student.getName().equals(name) || student.getSurname().equals(name)) { found = Boolean.TRUE; }
        }
        if (found) { System.out.println("���� �����"); }
        else { System.out.println("�� �������"); }
    }
 
}