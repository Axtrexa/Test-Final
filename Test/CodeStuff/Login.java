package Test.CodeStuff;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.File;

public class Login{
public static void main(String[] args) {
    String testyes = PasswordManager.passwordGenerator(5);
    System.out.println(testyes + " Test Pass");
    Writer writer = null;

try {
    writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("filename.txt"), "utf-8"));
    writer.write("Something");
} catch (IOException ex) {
    // Report
} finally {
   try {writer.close();} catch (Exception ex) {/*ignore*/}
}
File f = new File("C:/Users/000060552.CODEDOJO/Documents/GitHub/Test-Final/filename.txt");
if(f.exists() && !f.isDirectory()) { 
    System.out.println("Exists");
}
}
 }
