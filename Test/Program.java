package Test;
import javax.swing.*;

import Test.CodeStuff.PasswordManager;
class gui{
    public static void main(String args[]){
       JFrame frame = new JFrame("My First GUI");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       JButton button = new JButton("hi");
       frame.getContentPane().add(button); // Adds Button to content pane of frame
       frame.setVisible(true);


        
        PasswordManager passMan = new PasswordManager();
        passMan.verifyPassword("cookies123$");

    }
}