package nl.repleo.fastlap;

/**
 * Created by Jeroen Arnoldus on 03-08-15.
 */

import java.util.*;

 class TestLap {
    private int car;
    private long time;

    public TestLap(int car, long time) {
        this.car = car;
        this.time = time;
    }

    public int getCar() {
        return car;
    }

    public long getTime() {
        return time;
    }
}

public class TestClock implements Clock {
    private int counter;
    private ArrayList<TestLap> laptimes;

    public TestClock(ArrayList<TestLap> laptimes) {
        this.laptimes = laptimes;
        counter = 0;
    }

    public int getCar(int max_cars){

        if (laptimes.size() > counter) {
            return laptimes.get(counter).getCar();
        } else {
            return 0;
        }
    }
    public long getTime(){
        if (laptimes.size() > counter) {
            long time = laptimes.get(counter).getTime();
            counter++;
            return time;
        } else {
            return 0;
        }
    }
}
