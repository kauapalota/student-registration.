package application;

import constructors.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

  private static ArrayList<Student> students = new ArrayList<>();
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    boolean isRunning = true;

    System.out.println("Current date: " + today);
    while (isRunning) {

      System.out.println("*******************");
      System.out.println("Registration System");
      System.out.println("*******************");
      System.out.println("1. Add student");
      System.out.println("2. See student information");
      System.out.println("3. Change student information");
      System.out.println("4. Delete student");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");

      int choice = sc.nextInt();
      sc.nextLine();
      System.out.println();

      switch (choice) {
        case 1 -> newStudent();
        case 2 -> seeInformation();
        case 3 -> changeStudent();
        case 4 -> deleteStudent();
        case 5 -> isRunning = false;
        default -> System.out.println("Invalid option!");
      }
    }

    sc.close();
  }

  // ==============================
  // CREATE
  // ==============================
  public static void newStudent() {

    System.out.print("Name: ");
    String name = sc.nextLine();

    System.out.print("Year of birth: ");
    int birthYear = sc.nextInt();
    System.out.print("Month of birth (1-12): ");
    int birthMonth = sc.nextInt();
    System.out.print("Day of birth: ");
    int birthDay = sc.nextInt();
    sc.nextLine();

    LocalDate dateOfBirth = LocalDate.of(birthYear, birthMonth, birthDay);

    System.out.print("Sex (M/F): ");
    String sex = sc.nextLine();
    if (!isValidSex(sex)) {
      System.out.println("Invalid sex! Use M or F.");
      return;
    }

    Student s = new Student(name, sex, dateOfBirth);

    students.add(s);

    System.out.println("Student created successfully!");
    System.out.println("Student ID: " + s.getId());
  }
  public static boolean isValidSex(String sex) {
    return sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F");
  }

  // ==============================
  // READ
  // ==============================
  public static void seeInformation() {

    if (students.isEmpty()) {
      System.out.println("No students registered!");
      return;
    }

    System.out.print("Enter student ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    Student s = findStudentById(id);

    if (s == null) {
      System.out.println("Student not found!");
      return;
    }

    System.out.println("\n" + s + "\n");
  }

  // ==============================
  // UPDATE
  // ==============================
  public static void changeStudent() {

    if (students.isEmpty()) {
      System.out.println("No students registered!");
      return;
    }

    System.out.print("Enter student ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    Student s = findStudentById(id);

    if (s == null) {
      System.out.println("Student not found!");
      return;
    }

    System.out.println("1. Change name");
    System.out.println("2. Change sex");
    System.out.println("3. Change date of birth");
    System.out.print("Choice: ");

    int option = sc.nextInt();
    sc.nextLine();

    if (option == 1) {
      System.out.print("New name: ");
      s.setName(sc.nextLine());
      System.out.println("Name updated!");
    }else if (option == 2) {
      System.out.print("New sex: ");
      String newSex = sc.nextLine();
      if (!isValidSex(newSex)) {
        System.out.println("Invalid sex! Use M or F.");
        return;
      }
      s.setSex(newSex);
      System.out.println("Sex updated!");
    } else if (option == 3) {
        System.out.println("New date of birth: ");
        System.out.print("Year of birth: ");
        int newBirthYear = sc.nextInt();
        System.out.print("Month of birth (1-12): ");
        int newBirthMonth = sc.nextInt();
        System.out.print("Day of birth: ");
        int newBirthDay = sc.nextInt();
        sc.nextLine();
        LocalDate newDateOfBirth = LocalDate.of(newBirthYear, newBirthMonth, newBirthDay);
        s.setDateOfBirth(newDateOfBirth);
        System.out.println("Date of birth updated!");

    } else {
      System.out.println("Invalid option!");
    }
  }

// ==============================
// DELETE
// ==============================
  public static void deleteStudent() {

    if (students.isEmpty()) {
      System.out.println("No students registered!");
      return;
    }

    System.out.print("Enter student ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    Student s = findStudentById(id);

    if (s == null) {
      System.out.println("Student not found!");
      return;
    }

    students.remove(s);
    System.out.println("Student deleted successfully!");
  }

  // ==============================
  // SEARCH BY ID
  // ==============================

  public static Student findStudentById(int id) {

    for (Student s : students) {
      if (s.getId() == id) {
        return s;
      }
    }

    return null;
  }
}