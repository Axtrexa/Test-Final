package Test.CodeStuff;
import java.util.Random;
public class PasswordManager {
    private String password;
    int length = 4;
    Random gen = new Random();
    


    public boolean verifyPassword(String password)
    {
        if(this.password == password)
        {
            return true;
        } else {
            return false;
        }
    }
}
