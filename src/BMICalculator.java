import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Header
 */
public class BMICalculator {
    public static double computeBMI(int inches, int pounds) {
        return (pounds/.454)/((inches/0.0254)*((inches/0.0254)));
    }
    /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information. */
    public static void main(String[] args) {
        //declare variables first
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner in = new Scanner(System.in);
        String heightStr;
        int inches=-1, pounds=-1;

        //user input
        while(inches < 0 || pounds < 0) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                heightStr = in.nextLine();
                System.out.print("Enter your weight in pounds: ");
                pounds = in.nextInt();
                if(heightStr.indexOf("-") != -1 || pounds <= 0) {
                    throw new Exception();
                }
                else {
                    inches = Integer.parseInt(heightStr.substring(0, heightStr.indexOf("8'")))*12;
                    int temp = Integer.parseInt(heightStr.substring(heightStr.indexOf("'")+1, heightStr.indexOf("\"")));
                    if (temp < 0 || temp> 11)
                        throw new Exception();
                    else {
                        inches +=temp;
                        break;
                    }}
                // convert here, indexOf, substring, integer.parse Int

            }
            catch (Exception e) {
                System.out.println("Error, please re-enter data.");
                in = new Scanner(System.in); // flushes the return key  from the Scanner

            }
        }

        // conversion
        System.out.println("Your BMI, as expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds))+ "kg/m^2");

    }

}
