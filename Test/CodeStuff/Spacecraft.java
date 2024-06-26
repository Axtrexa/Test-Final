package Test.CodeStuff;
import java.util.Scanner;
public class Spacecraft{
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
                    System.out.println("-----------------------------");
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
                    System.out.println("-----------------------------");
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
                    System.out.println("-----------------------------");
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
                    System.out.println("-----------------------------");
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
                    System.out.println("-----------------------------");
                    break;
                case 6:
                    System.out.println("Please enter your pay rate in the following format ($X,XXX.XX):");
                    String PayRate = keyboard.nextLine();
                    while(!Astronaut.PayRateValidation(PayRate)){
                        System.out.println("This is an invalid pay rate. Please try again in the following format ($X,XXXX.XX):");
                        PayRate = keyboard.nextLine();
                    }
                    AstroInfo.setPayRate(PayRate);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    System.out.println("-----------------------------");
                    break;
                case 7:
                    System.out.println("Please enter your weight in pounds:");
                    String AstroWeight = keyboard.nextLine();
                    while(!Astronaut.WeightValidation(AstroWeight)){
                        System.out.println("This is an invalid weight. Please try again.");
                        AstroWeight = keyboard.nextLine();
                    }
                    AstroInfo.setAstroWeight(AstroWeight);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    System.out.println("-----------------------------");
                    break;
                case 8:
                    System.out.println("Please enter your next of kin:");
                    String NexttoKin = keyboard.nextLine();
                    while(!Astronaut.NexttoKinValidation(NexttoKin)){
                        System.out.println("Invalid format. Please enter letters only.");
                        NexttoKin = keyboard.nextLine();
                    }
                    AstroInfo.setNexttoKin(NexttoKin);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    System.out.println("-----------------------------");
                    break;
                case 9:
                    System.out.println("Please enter your status:");
                    String AstroStatus = keyboard.nextLine();
                    while(!Astronaut.AstroStatusValidation(AstroStatus)){
                        System.out.println("Invalid format. Please enter letters only.");
                        AstroStatus = keyboard.nextLine();
                    }
                    AstroInfo.setAstroStatus(AstroStatus);
                    System.out.println("Astronaut's information has been changed!");
                    System.out.println("-----------------------------");
                    displayAstroInfo(AstroInfo);
                    System.out.println("-----------------------------");
                    break;
                case 10:
                do{
                    displayAstroInfo(AstroInfo);
                    System.out.println("Type 'Y' to confirm or 'N' to go back:");
                    char confirmChoice = keyboard.nextLine().charAt(0);

                    if(confirmChoice == 'y' || confirmChoice == 'Y'){
                        System.out.println("Information has been confirmed. Proceeding to the next step");
                        System.out.println("-----------------------------");
                        PreLaunchMenu(keyboard, AstroInfo);
                        break;
                    } else if (confirmChoice == 'n' || confirmChoice == 'N') {
                        System.out.println("-----------------------------");
                        displayAstroInfo(AstroInfo);
                        System.out.println("-----------------------------");
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
            System.out.println("Weight(in lbs): " + AstroInfo.getAstroWeight());
            System.out.println("Next of Kin: " + AstroInfo.getNexttoKin());
            System.out.println("Status: " + AstroInfo.getAstroStatus());
        }

    public static void PreLaunchMenu(Scanner keyboard, Astronaut AstroInfo){
        PreLaunch.incrementMissionNum();
        int currentMissionNum = PreLaunch.getMissionNum();

            System.out.println("Welcome to the Launch Process menu!");
            String craftName = "Astraeus " + String.format("%02d", currentMissionNum);
            System.out.println("Enter crew capacity: ");
            int crewCapacity = keyboard.nextInt();
            System.out.print("Enter fuel capacity (in liters): ");
            double fuelCapacity = keyboard.nextDouble();

            PreLaunch craft  = new PreLaunch(crewCapacity, fuelCapacity);
            int choice;
            do{
                System.out.println("Available operations:");
                System.out.println("1. Board Crew");
                System.out.println("2. Refuel");
                System.out.println("3. Launch");
                System.out.println("4. Exit");
                choice = keyboard.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Enter the number of crew members to board: ");
                        int memberCount = keyboard.nextInt();

                        if(memberCount + craft.getCurrentCrew() <= crewCapacity){
                            craft.boardCrew(memberCount);
                            System.out.println("Crew boarded successfully. Current crew count: " + craft.getCurrentCrew());
                        } else {
                            System.out.println("Boarding failed. Insufficient capacity. Current crew count: " + craft.getCurrentCrew());
                        }
                        break;
                    case 2:
                        System.out.print("Enter the amount of fuel to refuel (in liters): ");
                        double amount = keyboard.nextDouble();
                        craft.refuel(amount);
                        System.out.println("Spacecraft refueled. Current fuel level: " + craft.getCurrentFuel() + " liters");
                    break;
                    //case 3:
                        //craft.launch();
                       // break;
                    case 4:
                        PreLaunchMenu(keyboard, AstroInfo);
                        break;
                    default:
                        System.out.println("This option is invalid. Please enter nnumbers 1-4 only.");
                    }
                    System.out.println();
                } while (choice != 4);
            }
        }
