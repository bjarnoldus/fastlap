package nl.repleo.fastlap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome! This is FastLap");
        FastLap fastlap = new FastLap();
        while( fastlap.newrace() ){}
        System.out.println("Thank you for using FastLap");
    }
}
