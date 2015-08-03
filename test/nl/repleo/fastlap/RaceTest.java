package nl.repleo.fastlap;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jeroen Arnoldus on 03-08-15.
 */
public class RaceTest {
    private static long basetime = new Long("1420110000000");

    private void printWinners(ArrayList<Lap> winners){
        if(winners == null){
            System.out.println("Race has been aborted");
        } else {
            System.out.println("Winners of the race: ");

            for (Lap winner : winners)
                System.out.println(winners.toString());

            System.out.println();
        }
    }
    @Test
    public void testRace_simple_1() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));
        laptimes.add(new TestLap(1,1000+basetime));
        Race race = new Race(1,1);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);
        //printWinners(winners);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(1,1,basetime,1000));
        assertEquals(expectedWinners, winners);
    }

    @Test
    public void testRace_simple_2() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));
        laptimes.add(new TestLap(1,1000+basetime));
        laptimes.add(new TestLap(1,2000+basetime));
        laptimes.add(new TestLap(1,3000+basetime));
        laptimes.add(new TestLap(1,3995+basetime));
        laptimes.add(new TestLap(1,5000+basetime));
        laptimes.add(new TestLap(1,6000+basetime));
        laptimes.add(new TestLap(1,7000+basetime));
        laptimes.add(new TestLap(1,8000+basetime));
        laptimes.add(new TestLap(1,9000+basetime));
        laptimes.add(new TestLap(1,10000+basetime));
        laptimes.add(new TestLap(1,11000+basetime));
        laptimes.add(new TestLap(1,12000+basetime));

        Race race = new Race(1,12);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);
        //printWinners(winners);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(1,4,3000+basetime,995));
        assertEquals(expectedWinners, winners);
    }
    @Test
    public void testRace_simple_3() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));
        laptimes.add(new TestLap(1,1000+basetime));
        laptimes.add(new TestLap(1,2000+basetime));
        laptimes.add(new TestLap(1,3000+basetime));
        laptimes.add(new TestLap(1,3995+basetime));
        laptimes.add(new TestLap(1,5000+basetime));
        laptimes.add(new TestLap(1,6000+basetime));
        laptimes.add(new TestLap(1,7000+basetime));
        laptimes.add(new TestLap(1,8000+basetime));
        laptimes.add(new TestLap(1,9000+basetime));
        laptimes.add(new TestLap(1,10000+basetime));
        laptimes.add(new TestLap(1,11000+basetime));
        laptimes.add(new TestLap(1,12000+basetime));
        laptimes.add(new TestLap(1,12500+basetime));

        Race race = new Race(1,12);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(1,4,3000+basetime,995));
        assertEquals(expectedWinners, winners);
    }
    @Test
    public void testRace_1() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));
        laptimes.add(new TestLap(2,10+basetime));
        laptimes.add(new TestLap(1,1000+basetime));
        laptimes.add(new TestLap(2,2000+basetime));
        laptimes.add(new TestLap(2,2000+1000+basetime));

        Race race = new Race(2,2);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(1,1,basetime,1000));
        expectedWinners.add(new Lap(2,2,2000+basetime,1000));
        assertEquals(expectedWinners, winners);
    }

    @Test
    public void testRace_2() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));
        laptimes.add(new TestLap(2,0+basetime));
        laptimes.add(new TestLap(3,0+basetime));
        laptimes.add(new TestLap(4,0+basetime));
        laptimes.add(new TestLap(5,0+basetime));
        laptimes.add(new TestLap(1,1000+basetime));
        laptimes.add(new TestLap(2,2000+basetime));
        laptimes.add(new TestLap(3,2500+basetime));
        laptimes.add(new TestLap(4,2800+basetime));
        laptimes.add(new TestLap(5,500+basetime));
        laptimes.add(new TestLap(2,2000+1000+basetime));
        laptimes.add(new TestLap(2,500+2000+1000+basetime));
        Race race = new Race(5,3);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(5,1,basetime,500));
        expectedWinners.add(new Lap(2,3,2000+1000+basetime,500));
        assertEquals(expectedWinners, winners);
    }
    @Test
    public void testRace_abort() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(0,new TestLap(0,0+basetime));
        laptimes.add(1,new TestLap(0,100+basetime));

        Race race = new Race(1,1);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);
        assertEquals(null, winners);
    }


    @Test
    public void testRace_full() throws Exception {
        ArrayList<TestLap> laptimes = new ArrayList<TestLap>();
        laptimes.add(new TestLap(1,0+basetime));//1,12:00:00
        laptimes.add(new TestLap(2,1000+basetime));//2,12:00:01
        laptimes.add(new TestLap(3,1000+basetime));//3,12:00:01
        laptimes.add(new TestLap(4,2000+basetime));//4,12:00:02
        laptimes.add(new TestLap(5,2000+basetime));//5,12:00:02
        laptimes.add(new TestLap(2,60000+basetime));//2,12:01:00
        laptimes.add(new TestLap(1,70000+basetime));//1,12:01:10
        laptimes.add(new TestLap(4,70000+basetime));//4,12:01:10
        laptimes.add(new TestLap(5,72000+basetime));//5,12:01:12
        laptimes.add(new TestLap(3,75000+basetime));//3,12:01:15
        laptimes.add(new TestLap(2,130000+basetime));//2,12:02:10
        laptimes.add(new TestLap(1,132000+basetime));//1,12:02:12
        laptimes.add(new TestLap(4,132000+basetime));//4,12:02:12
        laptimes.add(new TestLap(5,136000+basetime));//5,12:02:16
        laptimes.add(new TestLap(3,137000+basetime));//3,12:02:17
        laptimes.add(new TestLap(1,195000+basetime));//1,12:03:15
        laptimes.add(new TestLap(2,200000+basetime));//2,12:03:20
        laptimes.add(new TestLap(4,206000+basetime));//4,12:03:26
        laptimes.add(new TestLap(3,216000+basetime));//3,12:03:36
        laptimes.add(new TestLap(5,217000+basetime));//5,12:03:37
        laptimes.add(new TestLap(2,260000+basetime));//2,12:04:20
        laptimes.add(new TestLap(1,268000+basetime));//1,12:04:28
        laptimes.add(new TestLap(5,273000+basetime));//5,12:04:33
        laptimes.add(new TestLap(4,285000+basetime));//4,12:04:45
        laptimes.add(new TestLap(3,286000+basetime));//3,12:04:46

        Race race = new Race(5,4);

        Clock clock = new TestClock(laptimes);
        ArrayList<Lap> winners = race.run(clock);

        ArrayList<Lap> expectedWinners = new ArrayList<Lap>();
        expectedWinners.add(new Lap(2,1,1000+basetime,59000));
        assertEquals(expectedWinners, winners);

        printWinners(winners);
    }



}
