package Test.CodeStuff;
public class Astronaut {
    private String AstroName;
    public String Birthdate;
    private String SerialNum;
    private String Address;
    private String Email;
    private String PhoneNum;
    private double PayRate;
    private double AstroWeight;
    private String NexttoKin;
    private String AstroStatus;

    // Get Astronaut's name
    public String getAstroName(){
        return AstroName;
    }
    // Get Astronaut's birthdate
    public String getBirthdate(){
        return Birthdate;
    }
    // Get Astronaut's generated serial
    public String getSerialNum(){
        return SerialNum;
    }
    // Get Astronaut's address
    public String getAddress(){
        return Address;
    }
    // Get Astronaut's email
    public String getEmail(){
        return Email;
    }
    // Get Astronaut's phone number
    public String getPhoneNum(){
        return PhoneNum;
    }
    // Get Astronaut's pay rate
    public double getPayRate(){
        return PayRate;
    }
    // Get Astronaut's weight
    public double getAstroWeight(){
        return AstroWeight;
    }
    // Get Astronaut's next to kin
    public String getNexttoKin(){
        return NexttoKin;
    }
    // Get Astronaut's status
    public String getAstroStatus(){
        return AstroStatus;
    }
    // Set Astronaut's name
    public void setAstroName(String AstroName){
        this.AstroName = AstroName;
    }
    // Set Astronaut's age
    public void setBirthdate(String Birthdate){
        this.Birthdate = Birthdate;
    }
    // Set Astronaut's generated serial
    public void setSerialNum(String SerialNum){
        this.SerialNum = SerialNum;
    }
    // Set Astronaut's address
    public void setAddress(String Address){
        this.Address = Address;
    }
    // Set Astronaut's email
    public void setEmail(String Email){
        this.Email = Email;
    }
    // Set Astronaut's phone number
    public void setPhoneNum(String PhoneNum){
        this.PhoneNum = PhoneNum;
    }
    // Set Astronaut's pay rate
    public void setPayRate(double PayRate){
        this.PayRate = PayRate;
    }
    //Set Astronaut's weight
    public void setAstroWeight(double AstroWeight){
        this.AstroWeight = AstroWeight;
    }
    // Set Astronaut's next to kin
    public void setNexttoKin(String NexttoKin){
        this.NexttoKin = NexttoKin;
    }
    // Set Astronaut's status
    public void setAstroStatus(String AstroStatus){
        this.AstroStatus = AstroStatus;
    }

    public static String serialNumGenerator(int length){
        String characters = "0123456789";
        StringBuilder randomSerial = new StringBuilder();
        Random gen = new Random();
        for(int i = 0; i < length; i++){
             int index = gen.nextInt(characters.length());
            randomSerial.append(characters.charAt(index));

        }
        return randomSerial.toString();
    }

    public static boolean PhoneNumValidation(String PhoneNum){
        if(PhoneNum.length() != 13){
            System.out.println("Invalid length");
            return false;
        }
        for(int i = 0; i < PhoneNum.length(); i++){
            switch(i){
                case 0:
                    if(PhoneNum.charAt(i) != '('){
                        System.out.println("Missing '(' at position " + i);
                        return false;
                    }
                    break;
                case 4:
                    if(PhoneNum.charAt(i) != ')'){
                        System.out.println("Missing ')' at position " + i);
                        return false;
                    }
                    break;
                case 5:
                case 9:
                    if(PhoneNum.charAt(i) != '-'){
                        System.out.println("Missing '-' at position " + i);
                        return false;
                    }
                    break;
                default:
                    if(!Character.isDigit(PhoneNum.charAt(i))){
                        System.out.println("Invalid character at position " + i);
                        return false;
                    }
            }
        }
        return true;
    }
}
    
