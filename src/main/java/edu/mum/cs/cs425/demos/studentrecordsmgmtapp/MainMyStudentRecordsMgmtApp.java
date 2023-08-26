package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.CodingPractice;
import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class MainMyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(110001, "Dave", "11/18/1951"));
        list.add(new Student(110002, "Anna", "12/07/1990"));
        list.add(new Student(110003, "Erica", "01/31/1974"));
        list.add(new Student(110004, "Carlos", "08/22/2009"));
        list.add(new Student(110005, "Bob", "03/05/1990"));

        int[] numList1 = new int[]{10, 15, 21, 28, 70, 20, 25, 35, 42, 56, 34};

        int[] numList2 = new int[]{1, 2, 3, 4, 5};
        int[] numList3 = new int[]{9, 6, 5, 2};

        System.out.println("============================= Q.n.3.3 ============================");
        printListOfStudents(list);

        System.out.println("\n================================================================");

        System.out.println("\n============================= Q.n. 3.4 ============================");
        getListOfPlatinumAlumniStudents(list);

        System.out.println("\n================================================================");

        System.out.println("\n============================= Q.n. 3.5.1 ============================");
        CodingPractice.printHelloWorld(numList1);

        System.out.println("\n================================================================");

        System.out.println("\n============================= Q.n. 3.5.2 ============================");
        int secondBigNum = CodingPractice.findSecondBiggest(numList2);
        System.out.println("Second biggest number is: " + secondBigNum);

    }

    /**
     * 3.3.	In the MyStudentRecordsMgmtApp class, also add a method named, printListOfStudents, which takes as input,
     * the array of students and it iterates through the objects and prints out all the students data to the console/screen.
     * This print-out should be in ascending order of the Students Names. Note: Call your printListOfStudents(...)
     * method within your MyStudentRecordsMgmtApp  class's main method, then execute it.
     *
     * @param list
     */
    public static void printListOfStudents(ArrayList<Student> list) {
        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(
                student -> {
                    System.out.println("studentId: " + student.getStudentId() + ", name: " + student.getName() + ", dateOfAdmission: " + student.getDateOfAdmission());
                }
        );
    }

    /**
     * 3.4.	Also, in the MyStudentRecordsMgmtApp class, add another method named, getListOfPlatinumAlumniStudents, which takes as input,
     * the array of all students and it returns a List of only PlatinumAlumni students.
     * A PlatinumAlumni student is a student who gained admission into the University at least 30 years ago.
     * Note: Call your getListOfPlatinumAlumniStudents(...) method within your MyStudentRecordsMgmtApp  class's main method,
     * print the list of the platinum-alumni students, in descending order of their dates of admission, then execute it.
     *
     * @param list
     */
    public static void getListOfPlatinumAlumniStudents(ArrayList<Student> list) {
        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(
                student -> {
                    if (getDifferenceInYears(student.getDateOfAdmission()) >= 30) {
                        System.out.println("studentId: " + student.getStudentId() + ", name: " + student.getName() + ", dateOfAdmission: " + student.getDateOfAdmission());
                    }
                }
        );
    }

    public static int getDifferenceInYears(String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate admitDate = LocalDate.parse(date, inputFormatter);
        return Period.between(admitDate, LocalDate.now()).getYears();
    }
}