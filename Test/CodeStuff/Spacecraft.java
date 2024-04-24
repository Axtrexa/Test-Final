import java.util.Scanner;
public class Spacecraft {
    public static void main(String[] args){
        int selection;

        Scanner keyboard = new Scanner(System.in);
        Astronaut AstroInfo = new Astronaut();
        System.out.println("Welcome aboard Astronaut!");
        System.out.println("ASTRONAUT INFO:");
        displayAstroInfo(AstroInfo);
        System.out.println("-----------------------------");


        do{
        InfoMenu();
        System.out.println("Please enter your choice from the following options:");
        selection = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("-----------------------------");

            while(selection < 1 || selection > 10){
                System.out.println("Invalid selection. Please try again.");
                selection = keyboard.nextInt();
                keyboard.nextLine();
            }

            switch(selection){
                case 1:
                    System.out.println("Please enter your first and last name:");
                    String AstroName = keyboard.nextLine();
                    AstroInfo.setAstroName(AstroName);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 2:
                    System.out.println("Please enter your birthdate (dd/mm/yy):");
                    String Birthdate = keyboard.nextLine();
                    AstroInfo.setBirthdate(Birthdate);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 3:
                    System.out.println("Please enter your address:");
                    String Address = keyboard.nextLine();
                    AstroInfo.setAddress(Address);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 4:
                    System.out.println("Please enter your email:");
                    String Email = keyboard.nextLine();
                    AstroInfo.setEmail(Email);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 5:
                    System.out.println("Please enter your phone number:");
                    String PhoneNum = keyboard.nextLine();
                    AstroInfo.setPhoneNum(PhoneNum);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 6:
                    System.out.println("Please enter your pay rate:");
                    double PayRate = keyboard.nextDouble();
                    keyboard.nextLine();
                    AstroInfo.setPayRate(PayRate);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 7:
                    System.out.println("Please enter your weight in pounds:");
                    double AstroWeight = keyboard.nextDouble();
                    keyboard.nextLine();
                    AstroInfo.setAstroWeight(AstroWeight);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 8:
                    System.out.println("Please enter your next of kin:");
                    String NexttoKin = keyboard.nextLine();
                    AstroInfo.setNexttoKin(NexttoKin);
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    break;
                case 9:
                    System.out.println("Please enter your status:");
                    String AstroStatus = keyboard.nextLine();
                    AstroInfo.setAstroStatus(AstroStatus);
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
        } while(true);
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
