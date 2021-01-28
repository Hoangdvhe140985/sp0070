package j.s.p0070;

import java.util.Scanner;

public class Validation {
    public static int getInt(String msg, int minVal, int maxVal) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        
        while (true) {
            try {           
                int result = Integer.parseInt(sc.nextLine());
                if (minVal <= result && result <= maxVal) {
                    return result;
                }
                System.err.print("Number must be between [" + minVal + "-" + maxVal + "], try again: ");
            } catch (NumberFormatException e) {
                System.err.print("Invalid input, try again: ");
            }
        }
    }
}
