package application;

import constructors.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import static menu.Entry.showMenu;

public class Main {

  private static ArrayList<Student> students = new ArrayList<>();
  private static Scanner sc = new Scanner(System.in);
  private static int year = LocalDate.now().getYear();

  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    boolean isRunning = true;

    System.out.println("Current date: " + today);
    while (isRunning) {

      showMenu(today);

      int choice = sc.nextInt();
      sc.nextLine();
      System.out.println();

      switch (choice) {
        case 1 -> newStudent();
        case 2 -> seeInformation();
        case 3 -> changeStudent();
        case 4 -> isRunning = false;
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
    int dateOfBirth = sc.nextInt();
    sc.nextLine();

    System.out.print("Sex (M/F): ");
    String sex = sc.nextLine();
    if (!isValidSex(sex)) {
      System.out.println("Invalid sex! Use M or F.");
      return;
    }

    int age = year - dateOfBirth;
    Student s = new Student(name, sex, dateOfBirth, age);

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
    } else {
      System.out.println("Invalid option!");
    }
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