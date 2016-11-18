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
        System.out.print("Введите имя: ");
        String name = br.readLine(); 
        System.out.print("Введите фамилие: ");
        String surname = br.readLine(); 
        System.out.print("Введите номер телефона: "); 
        String phone = br.readLine(); 
        Student student = new Student(name, surname, phone);
        studentsList.add(student);
    }
 
    public void findStudent(BufferedReader br) throws IOException {
        System.out.print("Студент (имя или фамилие) : ");
        String name = br.readLine();
        Boolean found = Boolean.FALSE;
        for (Student student : studentsList){
            if (student.getName().equals(name) || student.getSurname().equals(name)) { found = Boolean.TRUE; }
        }
        if (found) { System.out.println("Есть такой"); }
        else { System.out.println("Не найдено"); }
    }
 
}