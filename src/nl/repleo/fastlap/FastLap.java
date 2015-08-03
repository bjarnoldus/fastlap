package nl.repleo.fastlap;
/**
 * Created by Jeroen Arnoldus on 02-08-15.
 */

import java.util.ArrayList;
import java.util.regex.*;

public class FastLap {
    public boolean newrace() {
        System.out.println("Do you want to start a new race? (Y/N):");
        String result = Util.getStringInput( Pattern.compile("y|Y|n|N")).toUpperCase();
        if (result.equals("Y")) {
            System.out.println("How many cars join the race? [1-5]");
            int cars = Util.getIntInput(1, 5);
            System.out.println("How many laps? [1-12]");
            int nrOfLaps = Util.getIntInput(1, 12);

            Race race = new Race(cars,nrOfLaps);
            Clock clock = new RealClock();
            ArrayList<Lap> winners = race.run(clock);
            if(winners == null){
                System.out.println("Race has been aborted");
                System.out.println();
            } else {
                System.out.println("Race is finished");
                System.out.println();
                System.out.println("Winners of the race:");

                for (Lap winner : winners)
                    System.out.println(winners.toString());

                System.out.println();
            }


            return true;
        } else {
            return false;
        }
    }

}

