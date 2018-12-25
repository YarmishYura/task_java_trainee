package task;// Please, do not use internet or any other sources of information during the test
// tast shouldn’t take more than 30 minutes
// There are 3 classes: Student, Subject and Mark
// - Fill the data according to the following conditions (use lists)
// 1. It is known that there are such students in the group: Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko
// 2. Mathematics, Physics, Astronomy, History and Ethics are learned by this group and all subjects are mandatory excluding Ethics. It is optional.
// 3. Fill the data about marks if it is known that students have mark 3 for mandatory subjects and Maria has mark 5 for History and Ethics.
// 4. Please print results in a such way:
//   Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3 (do not display the subject info if there is no data about it)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        // 1
        List<Student> students_list = Arrays.asList(new Student("Valery", "Popov"), new Student("Semyon", "Korzhev"), new Student("Peter", "Ivanov"), new Student("Maria", "Semenova"), new Student("Kolya", "Nesterenko"));
        // 2
        List<Subject> subjects_list = Arrays.asList(new Subject("Mathematics", true), new Subject("Physics", true), new Subject("Astronomy", true), new Subject("History", true), new Subject("Ethics", false));
        // 3
        List<Mark> list = new ArrayList<>();
        for (Student aStudents_list : students_list) {
            for (Subject aSubjects_list : subjects_list) {
                if (aStudents_list.getFirstName().equals("Maria") && (aSubjects_list.getName().equals("History") || aSubjects_list.getName().equals("Ethics"))) {
                    list.add(new Mark(aStudents_list, aSubjects_list, 5));
                } else if (aSubjects_list.isMandatory()) {
                    list.add(new Mark(aStudents_list, aSubjects_list, 3));
                }
            }
        }
        // 4
        for (Student student_1 : students_list) {
            List<Mark> list_mark_1 = list.stream().filter(mark -> student_1.equals(mark.getStudent())).collect(Collectors.toList());
            System.out.print(student_1.getFirstName() + " " + student_1.getLastName() + " ");
            for (int j = 0; j < list_mark_1.size(); j++) {
                System.out.print(subjects_list.get(j).getName() + "-" + list_mark_1.get(j).getRank() + " ");
            }
            System.out.println();
        }
    }
}

