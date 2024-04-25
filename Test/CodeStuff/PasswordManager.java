package Test.CodeStuff;
import java.util.Random;
public class PasswordManager {
    
    public static String serialNumGenerator(int length){
        String characters = "0123456789";
        StringBuilder randomPass = new StringBuilder();
        Random gen = new Random();
        for(int i = 0; i < length; i++){
             int index = gen.nextInt(characters.length());
            randomPass.append(characters.charAt(index));

        }
        return randomPass.toString();

        
    }
