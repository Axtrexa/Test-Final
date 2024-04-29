package Test.CodeStuff;
public class PreLaunch {
    private String craftName;
    private int crewCapacity;
    private double fuelCapacity;
    private int currentCrew;
    private double currentFuel;

    public PreLaunch(String craftName, int crewCapacity, double fuelCapacity){
        this.craftName = craftName;
        this.crewCapacity = crewCapacity;
        this.fuelCapacity = fuelCapacity;

        currentCrew = 0;
        currentFuel = 0.0;
    }

        public boolean boardCrew(int memberCount){
            if(memberCount + currentCrew <= crewCapacity){
                currentCrew += memberCount;
                return true;
            }
            else{
                return false;
            }
        }

        public void refuel(double amount){
            currentFuel = Math.min(currentFuel + amount, fuelCapacity);
        }

        public void launch(String destination){
            if(currentCrew == crewCapacity && currentFuel == fuelCapacity){
                System.out.printf("Spacecraft '%s' successfully launched!", craftName);
                currentFuel = 0.0;
            }
            else{
                System.out.println("Launch failed. Insufficient crew or fuel.");
            }
        }

        public int getCurrentCrew(){
            return this.currentCrew;
        }

        public double getCurrentFuel(){
            return this.currentCrew;
        }

 }


