package EncryptionDecryption;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AppFrame extends JFrame {


    // Make a new frame to be called on in the application
    AppFrame() {
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

        JButton encBtn = new JButton("Encrypt >");
        encBtn.setBounds(190,150,100,30);
        panel.add(encBtn);

        JButton decBtn = new JButton("< Decrypt");
        decBtn.setBounds(190,200,100,30);
        panel.add(decBtn);

        JButton saveBtn = new JButton("Save as .txt");
        saveBtn.setBounds(190,250,100,30);
        panel.add(saveBtn);

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



        this.setVisible(true);
    }
}
