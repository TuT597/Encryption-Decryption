package EncryptionDecryption;

import javax.swing.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Encryptor-3000");
        frame.setSize(500,500);
        frame.setResizable(false);










        Encryption AES = new Encryption();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a key: ");

        // Read the input string and set the key
        final String secretKey = scanner.nextLine();

        // Prompt the user for input
        System.out.println("Key has been set.");
        System.out.println();
        System.out.println("Please enter text to encrypt: ");

        // Enter message to encrypt
        String originalString = scanner.nextLine();
        System.out.println();

        // Generates encrypted text
        String encSite = AES.encrypt(originalString, secretKey);

        // Decrypts the text
        String decSite = AES.decrypt(encSite, secretKey);

        // Prints encrypted text
        System.out.println("Your encrypted text is:");
        System.out.println(encSite);
        System.out.println();
        System.out.println("Decryption test:");
        System.out.println(decSite);

    }

}
