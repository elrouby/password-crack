import java.io.*;
import java.util.*;

public class ass1 {
//username m3 password lel test bs
    private static final String USERNAME = "hello";
    private static final String PASSWORD = "hello";
//text folder ha7ot feh el kalemat
    private static final String DICTIONARY_FILE = "dictionary.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        if (!enteredUsername.equals(USERNAME)) {
            System.out.println("Invalid username. Exiting.");
            return;
        }

        System.out.println("Attempting dictionary attack...");
        if (dictionaryAttack()) {
            System.out.println("Password cracked using dictionary attack!");
        } else {
            System.out.println("Dictionary attack failed. Starting brute force attack...");
            if (bruteForceAttack()) {
                System.out.println("Password cracked using brute force attack!");
            } else {
                System.out.println("Password could not be cracked.");
            }
        }
        scanner.close();
    }

    // Dictionary Attack Method
    private static boolean dictionaryAttack() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(PASSWORD)) {
                    System.out.println("Found password in dictionary: " + line);
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
        }
        return false;
    }

    //hena mazbota 3ala el 5 7roof
    private static boolean bruteForceAttack() {
        char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] attempt = new char[5];

        for (char c1 : characters) {
            for (char c2 : characters) {
                for (char c3 : characters) {
                    for (char c4 : characters) {
                        for (char c5 : characters) {
                            attempt[0] = c1;
                            attempt[1] = c2;
                            attempt[2] = c3;
                            attempt[3] = c4;
                            attempt[4] = c5;

                            String attemptPassword = new String(attempt);

                            if (attemptPassword.equals(PASSWORD)) {
                                System.out.println("Brute force found password: " + attemptPassword);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
