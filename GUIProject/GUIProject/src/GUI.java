import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
//er

public class GUI {
    private static final String CREDENTIALS_FILE = "user_credentials.txt";
    private static final String AES_KEY = "aesEncryptionKey"; // AES encryption key (must be kept secure)
    private static final String ASTRO_FILE = "astroInfo.txt";

    private static Map<String, String> userCredentials = new HashMap<>();
    
    public static void main(String[] args) {
        loadUserCredentials(); // Load existing user credentials from file
        

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(520, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Login");

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(140, 170, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(230, 170, 150, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(140, 210, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(230, 210, 150, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 250, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(230, 250, 100, 25);
        panel.add(registerButton);
        File f = new File(CREDENTIALS_FILE);
        if(f.exists() && !f.isDirectory()) { 
            panel.remove(registerButton);
        }
       

        // Second frame for successful login
        JFrame secondFrame = new JFrame();
        secondFrame.setSize(400, 300);

        // Rockets frame
        JFrame rocketsFrame = new JFrame();
        rocketsFrame.setSize(300, 200);
        rocketsFrame.setTitle("Rockets Screen");
        rocketsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Astronauts frame
        JFrame astronautsFrame = new JFrame();
        astronautsFrame.setSize(300, 500);
        astronautsFrame.setTitle("Astronauts Screen");
        astronautsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    

        // Login action listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (isValidLogin(username, password)) {
                    // Successful login
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    openSecondWindow(username); // Open the second window with username
                } else {
                    // Failed login
                    JOptionPane.showMessageDialog(frame, "Login failed. Invalid credentials.",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean isValidLogin(String username, String password) {
                String encryptedPassword = userCredentials.get(username);
                if (encryptedPassword != null) {
                    String decryptedPassword = decryptPassword(encryptedPassword);
                    return decryptedPassword.equals(password);
                }
                return false;
            }

            private void openAstronautWindow() {
                astronautsFrame.getContentPane().removeAll(); // Clear previous content
                astronautsFrame.setTitle("Astronaut Editor");

                JButton astroAddButton = new JButton("Add");
                astroAddButton.setBounds(20, 430, 80, 25);
                astronautsFrame.add(astroAddButton);
                
                JLabel astroLabel = new JLabel("why");
                astroLabel.setBounds(50, 50, 50, 50);
                astronautsFrame.add(astroLabel);

                astronautsFrame.setLayout(null);
                astronautsFrame.setVisible(true);
            }
            
            private void openSecondWindow(String username) {
                secondFrame.getContentPane().removeAll(); // Clear previous content
                secondFrame.setTitle("Welcome, " + username + "!");

                // Rockets button
                JButton rocketsButton = new JButton("Rockets");
                rocketsButton.setBounds(50, 50, 120, 30);
                secondFrame.add(rocketsButton);

                // Astronauts button
                JButton astronautsButton = new JButton("Astronauts");
                astronautsButton.setBounds(200, 50, 120, 30);
                secondFrame.add(astronautsButton);

                // Launch Button
                JButton launchButton = new JButton("LAUNCH");
                launchButton.setBounds(90, 100, 200, 100);
                secondFrame.add(launchButton);

                // Rockets button action listener
                rocketsButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        rocketsFrame.setVisible(true);
                    }
                });

                // Astronauts button action listener
                astronautsButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                      Spacecraft.astroConsole(e);
                    }
                });

                secondFrame.setLayout(null);
                secondFrame.setVisible(true);
            }
        });
        
        // Register action listener
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and password cannot be empty.",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else if (userCredentials.containsKey(username)) {
                    JOptionPane.showMessageDialog(frame, "Username already exists. Please choose a different one.",
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Register new user
                    panel.remove(registerButton);
                    String encryptedPassword = encryptPassword(password);
                    userCredentials.put(username, encryptedPassword);
                    saveUserCredentials(); // Save updated user credentials to file
                    JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
                    
                }
            }
        });

        frame.setVisible(true);
    }
    
    
    
    //Method to save astronaut info to file


    // Method to save user credentials to file
    private static void saveUserCredentials() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CREDENTIALS_FILE))) {
            for (Map.Entry<String, String> entry : userCredentials.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load user credentials from file
    private static void loadUserCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String credLine;
            while ((credLine = reader.readLine()) != null) {
                String[] parts = credLine.split(",");
                if (parts.length == 2) {
                    userCredentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // File does not exist or other IO error (first run, no users)
            System.out.println("No existing user credentials found.");
        }
    }

    // Method to encrypt password using AES
    private static String encryptPassword(String password) {
        try {
            Key aesKey = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to decrypt password using AES
    private static String decryptPassword(String encryptedPassword) {
        try {
            Key aesKey = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
            byte[] decrypted = cipher.doFinal(decodedBytes);
            return new String(decrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
