package menu;

import java.time.LocalDate;

public class Entry {
    public static void showMenu(LocalDate today) {
        System.out.println("*******************");
        System.out.println("Registration System");
        System.out.println("*******************");
        System.out.println("1. Add student");
        System.out.println("2. See student information");
        System.out.println("3. Change student information");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
