package EncryptionDecryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


// This class will contain the AES setup process for later encryption and decryption
public class Encryption {
    // this will be set later in the application
    private SecretKeySpec secretKey;
    // turns the key into an array
    private byte[] key;
    public String algorithm = "AES";
    public String operation = "ECB";
    public String padding = "PKCS5Padding";

    // set key method called in the encryption/decryption methods
    public void setKey(String myKey) {
        try {
            // turns myKey into a byte array using UTF-8 encoding
            key = myKey.getBytes("UTF-8");
            // creates instance of MessageDigest class using SHA-1 encoding
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            // turns the key into an SHA-1 hash
            key = sha.digest(key);
            // shortens the key array to 16 bytes if its longer
            key = Arrays.copyOf(key, 16);
            // Creates secretkeyspec using the given key and AES algorithm, a secretkeyspec is a
            // class that can be used in AES encryption and decryption
            secretKey = new SecretKeySpec(key, "AES");

        }
        catch (NoSuchAlgorithmException e){}
        catch (UnsupportedEncodingException e) {}
    }

    // Configure encryption settings
    private String crypter() {
        return algorithm + "/" + operation + "/" + padding;
    }

    // Encrypt
    public String encrypt(String strToEnc, String sec) {
        try {
            // calls the above method
            setKey(sec);
            // Creates a cipher object using the AES algo, ECB operation mode, and PKCS5 padding scheme
            Cipher cipher = Cipher.getInstance(crypter());
            // the cipher created is initialized in Encryption Mode using the secretKey we generated previously
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // a few things happen here, first the strToEnc given to the method is converted to bytes using UTF-8 encoding
            // then the doFinal method of the cipher is called to encrypt the bytes. Finally the encrypted message
            // is returned in Base64 format.
            byte[] encrypted = cipher.doFinal(strToEnc.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch (Exception e) {

        }
        return null;
    }

    // Decrypt
    public String decrypt(String strToDec, String sec) {
        try {
            // i will only  be commenting on differences here since most of it is the same as encryption
            setKey(sec);
            Cipher cipher = Cipher.getInstance(crypter());
            // here we initialize the cipher in DECRYPTION mode instead of encryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // here we are passed a string and instead of encrypting it we use the doFinal method to decrypt
            // the message. Then return it as a normal string.
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDec)));
        }
        catch (Exception e) {

        }
        return null;
    }
}
