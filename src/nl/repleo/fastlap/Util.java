package nl.repleo.fastlap;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Jeroen Arnoldus on 02-08-15.
 */
public class Util {
    public static String getStringInput(Pattern pattern) {
        boolean validData = false;
        String result = "";
        while (validData == false) {
            try {
                Scanner scan = new Scanner(System.in);
                result = scan.next(pattern);
                validData = true;
            } catch (InputMismatchException e) {
            }
        }
        return result;
    }

    public static int getIntInput(int minimal, int maximal) {
        boolean validData = false;
        int result = 0;
        while (validData == false) {
            try {
                Scanner scan = new Scanner(System.in);
                result = scan.nextInt();
                if((minimal <= result) && (result <= maximal))
                    validData = true;
            } catch (InputMismatchException e) {
            }
        }
        return result;
    }
}
