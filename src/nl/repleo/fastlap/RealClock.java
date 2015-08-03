package nl.repleo.fastlap;

/**
 * Created by Jeroen Arnoldus on 03-08-15.
 */
public class RealClock implements Clock {
    public int getCar(int max_cars){
        return Util.getIntInput(0, max_cars);
    }
    public long getTime(){
        return System.currentTimeMillis();
    }
}
