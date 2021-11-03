package entities;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String alternativeEmail;
    private String department;
    private String email;
    private String companySuffix = "arlogistics.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method to ask/set the department
        this.department = setDepartment();

        // Call a method to ask/set the password
        this.password = randomPassword(defaultPasswordLength);

        // Combine all the elements together
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Set department method
    private String setDepartment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Department Code: ");
        System.out.println("[1] Sales \n" +
                "[2] Accounting \n" +
                "[3] Production \n" +
                "[4] Marketing \n" +
                "[5] None");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        while (choice > 5 || choice <= 0) {
            System.out.print("Invalid choice. Try again: ");
            choice = sc.nextInt();
        }
        return switch (choice) {
            case 1 -> "sales";
            case 2 -> "accounting";
            case 3 -> "production";
            case 4 -> "marketing";
            default -> "";
        };
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set and get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set and get alternate email
    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }
    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    // Change and get password
    public void changePassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    // toString() Override to show information
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
