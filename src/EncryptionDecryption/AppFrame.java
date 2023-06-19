package EncryptionDecryption;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AppFrame extends JFrame {

    private Application application;
    public String key;

    // Here i set up a new appframe and give it an instance of Application
    // so it's classes can be used in the future.
    public AppFrame(Application application) {
        this.application = application;
        // basic frame set-up
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Encryptor-3000");
        this.setSize(500, 500);
        this.setResizable(false);


        // A panel goes into the frame and hold objects (similar to a container in HTML)
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        JLabel keyLabel = new JLabel("Key: ");
        keyLabel.setBounds(20, 20, 80, 25);
        panel.add(keyLabel);

        JTextField keyText = new JTextField();
        keyText.setBounds(75, 20, 150, 25);
        panel.add(keyText);

        JLabel encLabel = new JLabel("Plain Text");
        encLabel.setBounds(20, 50, 150, 25);
        panel.add(encLabel);

        JTextArea encText = new JTextArea();
        encText.setBounds(20, 80, 150, 300);
        encText.setBorder(new LineBorder(Color.BLACK));
        encText.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(3, 3, 3, 3)));
        encText.setLineWrap(true); // Enable line wrap
        encText.setWrapStyleWord(true); // Enable word wrap
        panel.add(encText);

        JLabel decLabel = new JLabel("Encrypted Text");
        decLabel.setBounds(310, 50, 150, 25);
        panel.add(decLabel);

        JTextArea decText = new JTextArea();
        decText.setBounds(310, 80, 150, 300);
        decText.setBorder(new LineBorder(Color.BLACK));
        decText.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(3, 3, 3, 3)));
        decText.setLineWrap(true); // Enable line wrap
        decText.setWrapStyleWord(true); // Enable word wrap
        panel.add(decText);

        // The Encrypt and Decrypt button take text from the key and a text field
        // those are used as variables for the encryption and decryption methods
        // in the main Application class.
        JButton encBtn = new JButton("Encrypt >");
        encBtn.setBounds(190,150,100,30);
        encBtn.addActionListener(e -> {
            key = keyText.getText();
            String plainText = encText.getText();
            String encryptedText = application.Encrypt(plainText, key);
            decText.setText(encryptedText);
        });
        panel.add(encBtn);

        JButton decBtn = new JButton("< Decrypt");
        decBtn.setBounds(190,200,100,30);
        decBtn.addActionListener(e -> {
            key = keyText.getText();
            String encryptedT = decText.getText();
            String decryptedText = application.Decrypt(encryptedT, key);
            encText.setText(decryptedText);
        });
        panel.add(decBtn);


        // Here i set up a file saving system for the decText field
        // first by initation a file path UI, then calling on the textToFile
        // method
        JButton saveBtn = new JButton("Save as .txt");
        saveBtn.setBounds(190,250,100,30);
        saveBtn.addActionListener(e ->{

            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();

                saveTextToFile(decText.getText(), filePath);
            }




        });
        panel.add(saveBtn);

        this.setVisible(true);
    }

    // Text to file method
    public void saveTextToFile(String text, String fileName) {
        if (!fileName.toLowerCase().endsWith(".txt")) {
            fileName += ".txt";
        }
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

