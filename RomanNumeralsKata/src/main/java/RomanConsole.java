import java.util.Scanner;

/**
 * @author Inna Pirina (<a href="mailto:Inna.Pirina@cas.de">Inna.Pirina@cas.de</a>)
 * @since 15.07.2020
 */
public class RomanConsole {

    public static void main(String[] args) {

        RomanNumberConverter romanNumberConverter = new RomanNumberConverter();
        System.out.println("This is a roman number converter. Insert any decimal number between 1 and 3.999 and " +
                "we'll convert it into a roman number.");
        System.out.println("Enter your number and press enter to start a conversion. Enter 'q' to stop the application.");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equalsIgnoreCase("q")) {
                System.out.println("Bye! :)");
                return;
            }
            try {
                int givenNumber = Integer.parseInt(s);
                System.out.println(romanNumberConverter.convertToRoman(givenNumber));
            }
            catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid whole number");
            }
        }
    }
}
