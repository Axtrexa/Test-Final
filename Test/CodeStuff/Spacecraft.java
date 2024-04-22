import java.util.Scanner;
public class Spacecraft {
    public static void main(String[] args){
        int selection;

        Scanner keyboard = new Scanner(System.in);
        Astronaut AstroInfo = new Astronaut();
        System.out.println("Welcome aboard Astronaut!");

        InfoMenu();
        System.out.println("Please enter your choice from the following options:");
        selection = keyboard.nextInt();

            while(selection < 1 || selection > 9){
                System.out.println("Invalid selection. Please try again.");
                selection = keyboard.nextInt();
                keyboard.nextLine();
            }

            switch(selection){
                case 1:
                    System.out.println("Please enter your first and last name:");
                    String AstroName = keyboard.nextLine();
                    AstroInfo.setAstroName(AstroName);
                    break;
                case 2:
                    System.out.println("Please enter your birthdate:");
                    String Birthdate = keyboard.nextLine();
                    AstroInfo.setBirthdate(Birthdate);
                    break;
                case 3:
                    System.out.println("Please enter your address:");
                    String Address = keyboard.nextLine();
                    AstroInfo.setAddress(Address);
                    break;
                case 4:
                    System.out.println("Please enter your email:");
                    String Email = keyboard.nextLine();
                    AstroInfo.setEmail(Email);
                    break;
                case 5:
                    System.out.println("Please enter your phone number:");
                    String PhoneNum = keyboard.nextLine();
                    AstroInfo.setPhoneNum(PhoneNum);
                    break;
                case 6:
                    System.out.println("Please enter your pay rate:");
                    double PayRate = keyboard.nextDouble();
                    AstroInfo.setPayRate(PayRate);
                    break;
                case 7:
                    System.out.println("Please enter your weight in pounds:");
                    double AstroWeight = keyboard.nextDouble();
                    AstroInfo.setAstroWeight(AstroWeight);
                    break;
                case 8:
                    System.out.println("Please enter your next of kin:");
                    String NexttoKin = keyboard.nextLine();
                    AstroInfo.setNexttoKin(NexttoKin);
                    break;
                case 9:
                    System.out.println("Please enter your status:");
                    String AstroStatus = keyboard.nextLine();
                    AstroInfo.setAstroStatus(AstroStatus);
                    break;

            }



    }
    public static void InfoMenu(){
        System.out.println("1. Edit Astronaut's Name");
        System.out.println("2. Edit Astronaut's Birthdate");
        System.out.println("3. Edit Astronaut's Address");
        System.out.println("4. Edit Astronaut's Email");
        System.out.println("5. Edit Astronaut's Phone Number");
        System.out.println("6. Edit Astronaut's PayRate");
        System.out.println("7. Edit Astronaut's Weight");
        System.out.println("8. Edit Astronaut's Next of Kin");
        System.out.println("9. Edit Astronaut's Status");
    }
}
