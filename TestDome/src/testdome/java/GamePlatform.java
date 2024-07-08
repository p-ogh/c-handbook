package testdome.java;

//correct
public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;
        for(int incline : inclinations){
                speed= speed - incline;
                if(speed <= 0){
                    speed = 0;
                    break;
                }
        }
        return speed;
    }

    public static void main(String[] args){
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}
