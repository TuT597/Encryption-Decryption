package EncryptionDecryption;

/*
To Do:
Trim white spaces on text before encrypting/decrypting.
Add error message if decryption is not possible.
 */
public class Application {

    Encryption AES = new Encryption();

    public static void main(String[] args) {

        AppFrame appFrame = new AppFrame(new Application());
    }

    public String Encrypt(String OriginalString, String secretKey) {
        return AES.encrypt(OriginalString, secretKey);
    }

    public String Decrypt(String OriginalString, String secretKey) {
        return AES.decrypt(OriginalString, secretKey);
    }
}





/*
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
*/

