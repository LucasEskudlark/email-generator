package application;

import entities.Email;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Infinite loop
        while (true) {
            // Ask for user choice (Generate email or Exit program)
            System.out.println("\nWhat do you want to do?");
            System.out.println("""
                    [1] Generate Email\s
                    [2] Exit""");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            // If option = 2 -> Exit program
            if (choice == 2) {
                break;
            }

            // If option = 1 -> Generate email
            if (choice == 1) {
                // Ask for user's first and last name
                System.out.print("First name: ");
                sc.nextLine();
                String firstName = sc.nextLine();
                System.out.print("Last name: ");
                String lastName = sc.nextLine();

                // Create object
                Email email = new Email(firstName, lastName);
                System.out.println(email);

                // Ask if the user wants to change password
                System.out.println("""
                        Do you want to change your password?\s
                        [1] Yes\s
                        [2] No""");
                System.out.print("Your choice: ");
                int passwordChoice = sc.nextInt();

                // If user wants to change password
                if (passwordChoice == 1) {
                    System.out.print("Type your new password: ");
                    sc.nextLine();
                    String password = sc.nextLine();

                    System.out.print("Repeat it: ");
                    String passwordCheck = sc.nextLine();

                    // While passwords don't match, ask passwords again
                    while (!password.equals(passwordCheck)) {
                        System.out.println("Passwords don't match. Try again: ");
                        System.out.print("Type your new password: ");
                        password = sc.nextLine();

                        System.out.print("Repeat it: ");
                        passwordCheck = sc.nextLine();
                    }
                    // Inform success
                    email.changePassword(password);
                    System.out.println("Password changed! Your new password is: " + password);
                }

                // Ask if the user wants to change mailbox capacity
                System.out.println("""
                        Do you want to change your mailbox capacity?\s
                        [1] Yes\s
                        [2] No""");
                System.out.print("Your choice: ");
                int mailboxdChoice = sc.nextInt();

                // If user wants to change mailbox capacity
                if (mailboxdChoice == 1) {
                    System.out.print("Type your new mailbox capacity(mb): ");
                    int mailboxCapacity = sc.nextInt();
                    email.setMailboxCapacity(mailboxCapacity);
                    System.out.println("Mailbox capacity changed! Your new password is: " + mailboxCapacity);
                }
            }

        }
    }
}
