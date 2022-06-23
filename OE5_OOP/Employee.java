package OE5_OOP;
import java.util.Scanner;

public class Employee {

    private String name;
    private String username;
    private String email;
    private String password;

    public Employee() {
        name = setName();
        username = setUserName(name);
        email = setEmail(username);
        password = setPassword(username);

    }

    private int countChars(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                count++;
        return count;
    }

    private String setName() {
        int count;
        Scanner scnr = new Scanner(System.in);
        String name;

        do {
            System.out.print("Enter your full name: ");
            name = scnr.nextLine();
            count = countChars(name, ' ');
        } while (count != 1);

        return name;
    }

    private String setUserName(String name) {
        return name.replace(' ', '.').toLowerCase();

    }

    private String setEmail(String username) {
        return username.charAt(0) + username.substring(username.indexOf('.') + 1) + "@oracleacademy.Test";
    }

    public String setPassword(String username) {
        String password = "";

        for (int i = 0; i < username.length() && i < 8; i++) {

            if (username.charAt(i) == 'a' || username.charAt(i) == 'e' || username.charAt(i) == 'i'
                    || username.charAt(i) == 'o' || username.charAt(i) == 'u')
                password += "*";
            else
                password += username.charAt(i);
        }

        while (password.length() < 8)
            password += "*";

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != '*') {
                password = password.substring(0, i) + (password.charAt(i) + "").toUpperCase()
                        + password.substring(i + 1);
                break;
            }
        }
        return password;
    }

    public String toString() {
        return "Employee Details\nName : " + name + "\nUsername : " + username + "\nEmail : " + email
                + "\nInitial Password : " + password;
    }
}
