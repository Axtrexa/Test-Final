package Test.CodeStuff;
public class Astronaut {
    private String AstroName;
    public String Birthdate;
    private String SerialNum;
    private String Address;
    private String Email;
    private String PhoneNum;
    private String PayRate;
    private String AstroWeight;
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
    public String getPayRate(){
        return PayRate;
    }
    // Get Astronaut's weight
    public String getAstroWeight(){
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
    public void setPayRate(String PayRate){
        this.PayRate = PayRate;
    }
    //Set Astronaut's weight
    public void setAstroWeight(String AstroWeight){
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

    public static boolean NameValidation(String AstroName){
        for(char name: AstroName.toCharArray()){
            if(!Character.isLetter(name) && name != ' '){
                return false;
            }
        }
        return true;
    }

    public static boolean BirthdateValidation(String Birthdate){

        int day;
        int month;
        int year;

        if(Birthdate.length() != 10){
            return false;
        }

        try{
        day = Integer.parseInt(Birthdate.substring(0, 2));
        month = Integer.parseInt(Birthdate.substring(3,5));
        year = Integer.parseInt(Birthdate.substring(6));
        } catch (NumberFormatException e){
            return false;
        }

        boolean isValid = true;
        if(day < 1 || day > 31){
            isValid = false;
        }
        if(month < 01 || month > 12){
            isValid = false;
        }
        if(year < 1900 || year > 2024){
            isValid = false;
        }
        for(int i = 0; i < Birthdate.length(); i++){
            switch(i){
                case 2:
                case 5:
                    if(Birthdate.charAt(i) != '/'){
                        return false;
                    }
                    break;
                default:
                    if(!Character.isDigit(Birthdate.charAt(i))){
                        return false;
                    }
            }
        }
        return isValid;
    }

    public static boolean AddressValidation(String Address){
        for(int i = 0; i < Address.length(); i++){
            char address = Address.charAt(i);
            if(!Character.isLetter(address) && !Character.isDigit(address) && address != ' ' && address != '/'){
                return false;
            }
        }
        return true;
    }

    public static boolean EmailValidation(String Email){
        int atCount = 0;
        int dotCount = 0;

        if(Email.length() <= 10){
            return false;
        }

        for(int i = 0; i < Email.length(); i ++){
            char email = Email.charAt(i);
            if(email == '@'){
                atCount ++;
            }
            else if (email == '.'){
                dotCount ++;
            }
            else if (!Character.isLetter(email) && !Character.isDigit(email) && email != '_' && email != '-'){
                return false;
            }
        }
        if(atCount != 1 || dotCount < 1){
            return false;
        }
        return true;
    }

    public static boolean PhoneNumValidation(String PhoneNum){
        if(PhoneNum.length() != 13){
            return false;
        }
        for(int i = 0; i < PhoneNum.length(); i++){
            switch(i){
                case 0:
                    if(PhoneNum.charAt(i) != '('){
                        return false;
                    }
                    break;
                case 4:
                    if(PhoneNum.charAt(i) != ')'){
                        return false;
                    }
                    break;
                case 8:
                    if(PhoneNum.charAt(i) != '-'){
                        return false;
                    }
                    break;
                default:
                    if(!Character.isDigit(PhoneNum.charAt(i))){
                        return false;
                    }
            }
        }
        return true;
    }

    public static boolean PayRateValidation(String PayRate){

    }

    public static boolean WeightValidation(String AstroWeight){
    }

    public static boolean NexttoKinValidation(String NexttoKin){
        for(char nextKin: NexttoKin.toCharArray()){
            if(!Character.isLetter(nextKin)){
                return false;
            }
        }
        return true;
    }

    public static boolean AstroStatusValidation(String AstroStatus){
        for(char astroStat: AstroStatus.toCharArray()){
            if(!Character.isLetter(astroStat)){
                return false;
            }
        }
        return true;
        }
}


    
