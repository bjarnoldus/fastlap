package nl.repleo.fastlap;

import java.io.IOException;
import java.util.*;
import java.text.*;

/**
 * Created by Jeroen Arnoldus on 02-08-15.
 */


class Lap{
    private int car;
    private int lapnumber;
    private long starttime;
    private long duration;

    public Lap(int car, int lapnumber, long starttime, long duration) {
        this.car = car;
        this.lapnumber = lapnumber;
        this.starttime = starttime;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lap lap = (Lap) o;

        if (car != lap.car) return false;
        if (duration != lap.duration) return false;
        if (lapnumber != lap.lapnumber) return false;
        if (starttime != lap.starttime) return false;

        return true;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(starttime);
        return  "Car: " + car +
                " lap: " + lapnumber +
                " Starttime: " + dateFormat.format(date) +
                " duration: " + duration / 1000  + "." + duration % 1000 + "s" ;
    }
}

public class Race {
    private int cars;
    private int numberOfLaps;
    //private long starttime;


    public Race(int cars, int numberOfLaps){
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
    }





    public ArrayList<Lap> run(Clock clock) {
        System.out.println("Race started with " + this.cars + " cars and " + this.numberOfLaps + " laps. Enter 0 to abort the race.");
        System.out.println("Enter the number of the car followed by enter when it passes the finish.");


        int[] lapcounters = new int[this.cars];
        long[] lapstarttimes = new long[this.cars];
        ArrayList<Lap> winners = new ArrayList<Lap>();
        long fastestlap = 0;


        boolean finished = false;
        while (!finished) {
            int car = clock.getCar(this.cars);
            if( car == 0 ){
                finished = true;
                winners = null;
                break;
            }
            long time = clock.getTime();

            if(lapstarttimes[car-1] == 0 ){
                lapstarttimes[car-1] = time;
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.println("car: " + car + " start time: " + dateFormat.format(lapstarttimes[car-1]));
            } else {
                long timelap = time - lapstarttimes[car - 1];
                if ((fastestlap == 0) || (fastestlap > timelap)) {
                    winners = new ArrayList<Lap>();
                    fastestlap = timelap;
                    winners.add(new Lap(car, lapcounters[car - 1], lapstarttimes[car - 1], timelap));
                } else if (fastestlap == timelap) {
                    winners.add(new Lap(car, lapcounters[car - 1], lapstarttimes[car - 1], timelap));
                }
                lapstarttimes[car - 1] = time;
                System.out.println("car: " + car + " lap: " + lapcounters[car - 1] + " duration: " + timelap / 1000 + "." + timelap % 1000 + "s");
            }
            lapcounters[car - 1]++;
            if (lapcounters[car-1] > this.numberOfLaps){
                finished = true;
            }

        }





        return winners;
    }
}
