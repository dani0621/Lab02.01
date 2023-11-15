import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Takes in user input of inches and pounds as a string, converts it an integer and then into meters and kilograms, and returns the BMI value as a double
 * @version 11.14.2023
 * @author 25lid
 */
public class BMICalculator {
    /**
     * takes inches and pounds, converts it to meters and kilograms, and returns the BMI value
     * @param inches an Integer
     * @param pounds an Integer
     * @return double of BMI value
     */
    public static double computeBMI(int inches, int pounds) {
        if (inches <= 0 || pounds <= 0)
            return 0.;
        double meters = inches * .0254;
        double kilograms = pounds * 0.454;
        return kilograms / (meters * meters);
    }

    /**
     * Uses a Scanner to prompt the user for info, process the feet to inches conversion, calls the computeBMI method and prints the
     * correct information.
     *
     * Main method of class BMI Calculator
     * @param args command line args if needed
     */
    public static void main(String[] args) {
        //declare variables first
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner in = new Scanner(System.in);
        String heightStr;
        int inches = -1, pounds = -1;
        while (inches < 0 || pounds < 0) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                heightStr = in.nextLine();
                System.out.print("Enter your weight in pounds: ");
                pounds = in.nextInt();
                if (heightStr.indexOf("-") != -1 || pounds <= 0) {
                    throw new Exception();
                }
                else {
                    inches = Integer.parseInt(heightStr.substring(0, heightStr.indexOf("'"))) * 12;
                    int temp = Integer.parseInt(heightStr.substring(heightStr.indexOf("'") + 1, heightStr.indexOf("\"")));
                    if (temp < 0 || temp > 11)
                        throw new Exception();
                    else
                        inches += temp;
                    break;
                }

            }
            // convert here, indexOf, substring, integer.parse Int
            catch (Exception e) {
                System.out.println("Error, please re-enter data.");
                in = new Scanner(System.in); // flushes the return key  from the Scanner

            }

        }
        System.out.println("Your BMI, as expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)) + "kg/m^2");
    }

}