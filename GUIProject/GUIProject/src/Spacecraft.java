
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Spacecraft {
    public static void astroConsole(ActionEvent e){
        int selection;

        Scanner keyboard = new Scanner(System.in);
        Astronaut AstroInfo = new Astronaut();
        
        System.out.println("Welcome User");
        System.out.println("ASTRONAUT INFO:");
        displayAstroInfo(AstroInfo);
        System.out.println("-----------------------------");


        do{
        InfoMenu();
        System.out.println("Please enter your choice from the following options:");
        while(!keyboard.hasNextInt()){
            System.out.println("Invalid selection. Please try again.");
            keyboard.nextLine();
        }
        selection = keyboard.nextInt();
        keyboard.nextLine();

            if(selection < 1 || selection > 10){
                System.out.println("Invalid selection. Please try again.");
                System.out.println("-----------------------------");
            }
            else{
            switch(selection){
                case 1:
                    System.out.println("Please enter your first and last name:");
                    String AstroName = keyboard.nextLine();
                    while(!Astronaut.NameValidation(AstroName)){
                        System.out.println("Invalid mame format. Please enter letters and spaces only.");
                        AstroName = keyboard.nextLine();
                    }
                    AstroInfo.setAstroName(AstroName);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 2:
                    System.out.println("Please enter your birthdate (dd/mm/yyyy):");
                    String Birthdate = keyboard.nextLine();
                    while(!Astronaut.BirthdateValidation(Birthdate)){
                        System.out.println("This date is invalid. Please try again in the following format (dd/mm/yyyy):");
                        Birthdate = keyboard.nextLine();
                    }
                    AstroInfo.setBirthdate(Birthdate);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 3:
                    System.out.println("Please enter your address:");
                    String Address = keyboard.nextLine();
                    while(!Astronaut.AddressValidation(Address)){
                        System.out.println("This address is invalid. Please try again.");
                        Address = keyboard.nextLine();
                    }
                    AstroInfo.setAddress(Address);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 4:
                    System.out.println("Please enter your email:");
                    String Email = keyboard.nextLine();
                    while(!Astronaut.EmailValidation(Email)){
                        System.out.println("This email is invalid. Please try again in the following format (name@example.com):");
                        Email = keyboard.nextLine();
                    }
                    AstroInfo.setEmail(Email);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 5:
                    System.out.println("Please enter your phone number in the following format ((XXX)XXX-XXXX):");
                    String PhoneNum = keyboard.nextLine();
                    while(!Astronaut.PhoneNumValidation(PhoneNum)){
                        System.out.println("This number is invalid. Please try again in the following format ((XXX)XXX-XXXX):");
                        PhoneNum = keyboard.nextLine();
                    }
                    AstroInfo.setPhoneNum(PhoneNum);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 6:
                    System.out.println("Please enter your pay rate:");
                    String PayRate = keyboard.nextLine();
                    while(!Astronaut.PayRateValidation(PayRate)){
                        System.out.println("This is an invalid pay rate. Please try again in the following format ($X,XXX,XXX)");
                        PayRate = keyboard.nextLine();
                    }
                    AstroInfo.setPayRate(PayRate);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 7:
                    System.out.println("Please enter your weight in pounds:");
                    double AstroWeight = keyboard.nextDouble();
                    keyboard.nextLine();
                    AstroInfo.setAstroWeight(AstroWeight);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 8:
                    System.out.println("Please enter your next of kin:");
                    String NexttoKin = keyboard.nextLine();
                    AstroInfo.setNexttoKin(NexttoKin);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 9:
                    System.out.println("Please enter your status:");
                    String AstroStatus = keyboard.nextLine();
                    AstroInfo.setAstroStatus(AstroStatus);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 10:
                do{
                    displayAstroInfo(AstroInfo);
                    System.out.println("Type 'Y' to confirm or 'N' to go back:");
                    char confirmChoice = keyboard.nextLine().charAt(0);

                    if(confirmChoice == 'y' || confirmChoice == 'Y'){
                        System.out.println("Information has been confirmed. Proceeding to the next step");
                        break;
                    } else if (confirmChoice == 'n' || confirmChoice == 'N') {
                        displayAstroInfo(AstroInfo);
                        break;
                    } else{
                        System.out.println("This option is invalid. Please type 'Y' or 'N' to confirm or deny.");
                    }
                } while(true);
                break;
            }
        }
    }   while(true);
}

    public static void InfoMenu(){
        System.out.println("1. Edit Astronaut's Name");
        System.out.println("2. Edit Astronaut's Birthdate");
        System.out.println("3. Edit Astronaut's Address");
        System.out.println("4. Edit Astronaut's Email");
        System.out.println("5. Edit Astronaut's Phone Number");
        System.out.println("6. Edit Astronaut's Pay Rate");
        System.out.println("7. Edit Astronaut's Weight");
        System.out.println("8. Edit Astronaut's Next of Kin");
        System.out.println("9. Edit Astronaut's Status");
        System.out.println("10. Confirm information is correct?");
    }

    public static void displayAstroInfo(Astronaut AstroInfo){
            System.out.println("Name: " + AstroInfo.getAstroName());
            System.out.println("Birthdate: " + AstroInfo.getBirthdate());
            System.out.println("Address: " + AstroInfo.getAddress());
            System.out.println("Email: " + AstroInfo.getEmail());
            System.out.println("Phone Number: " + AstroInfo.getPhoneNum());
            System.out.println("Pay Rate: " + AstroInfo.getPayRate());
            System.out.println("Weight: " + AstroInfo.getAstroWeight());
            System.out.println("Next of Kin: " + AstroInfo.getNexttoKin());
            System.out.println("Status: " + AstroInfo.getAstroStatus());
        }
}
